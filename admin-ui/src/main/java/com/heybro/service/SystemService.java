package com.heybro.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.heybro.domain.BusinessMessage;
import com.heybro.domain.BusinessMessageBuilder;
import com.heybro.domain.ManageUserDTO;
import com.heybro.entity.*;
import com.heybro.mapper.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class SystemService {

    @Autowired
    private ManageUserMapper manageUserMapper;

    @Autowired
    private ManageRoleMapper manageRoleMapper;

    @Autowired
    private ManageMenuRoleMapper manageMenuRoleMapper;

    @Autowired
    private ManageUserRoleMapper manageUserRoleMapper;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private ManageMenuMapper manageMenuMapper;

    /**
     * 查询系统用户
     *
     * @param page
     * @param size
     * @return
     */
    public BusinessMessage<JSONObject> findPage(String userName, Integer page, Integer size) {
        BusinessMessageBuilder<JSONObject> builder = new BusinessMessageBuilder<>();
        builder.success(false);
        try {
            PageHelper.startPage(page == null || page == 0 ? 1 : page, size == null ? 10 : size);
            Example example = new Example(ManageUser.class);
            if (!StringUtils.isEmpty(userName)) {
                example.createCriteria().andLike("username", "%"+userName+"%");
            }
            List<ManageUser> list = manageUserMapper.selectByExample(example);
            if (null != list && list.size() > 0) {
                PageInfo<ManageUser> pageInfo = new PageInfo<>(list);
                JSONObject json = JSON.parseObject(JSON.toJSONString(pageInfo));
                JSONArray jsonArray = new JSONArray();
                list.forEach(e -> {
                    JSONObject item = new JSONObject();
                    //获取角色ID
                    Example manageUserRoleExample = new Example(ManageUserRole.class);
                    manageUserRoleExample.createCriteria().andEqualTo("backenduserid", e.getId());
                    List<ManageUserRole> manageUserRoles = manageUserRoleMapper.selectByExample(manageUserRoleExample);
                    if (manageUserRoles != null && manageUserRoles.size() > 0) {
                        //获取角色名称
                        ManageRole role = manageRoleMapper.selectByPrimaryKey(manageUserRoles.get(0).getRoleid());
                        item.put("roleName", role.getName());
                        item.put("roleId", role.getId());
                    }
                    item.put("info", e);

                    jsonArray.add(item);
                });
                json.put("list", jsonArray);
                builder.data(json);
                builder.success(true);

            } else {
                builder.msg("该用户订单信息不存在，请重试");
                builder.data(null);
            }
        } catch (Exception e) {
            log.error("该用户查询订单失败:" + e);
        }
        return builder.build();
    }

    @Transactional
    public BusinessMessage<JSONObject> deleteUser(String ids) {
        BusinessMessageBuilder<JSONObject> builder = new BusinessMessageBuilder<>();
        builder.success(false);
        try {
            String[] idsS = ids.split(",");
            List<Integer> listIds = new ArrayList<>();
            for (String id : idsS) {
                listIds.add(Integer.parseInt(id));
            }
            //删除用户
            Example manageUserExample = new Example(ManageUser.class);
            manageUserExample.createCriteria().andIn("id",listIds);
            manageUserMapper.deleteByExample(manageUserExample);

            //删除该用户对应的角色
            Example manageUserRoleExample = new Example(ManageUserRole.class);
            manageUserRoleExample.createCriteria().andIn("backenduserid",listIds);
            manageUserRoleMapper.deleteByExample(manageUserRoleExample);
            builder.msg("删除成功");
            builder.success(true);
        } catch (Exception e) {
            log.error("删除人员失败", e);
            builder.msg("删除失败");
        }
        return builder.build();
    }

    @Transactional
    public BusinessMessage<JSONObject> doAddUser(ManageUserDTO manageUserDTO) {
        BusinessMessageBuilder<JSONObject> builder = new BusinessMessageBuilder<>();
        builder.success(false);
        try {
            ManageUser manageUser = new ManageUser();
            BeanUtils.copyProperties(manageUserDTO, manageUser);
            //加密
            manageUser.setPassword(passwordEncoder.encode(manageUser.getPassword()));
            manageUserMapper.insert(manageUser);

            //插入用户角色关联表
            String[] roleIds = manageUserDTO.getRoleId().split(",");
            ManageUserRole manageUserRole;
            for (String roleId : roleIds) {
                manageUserRole = new ManageUserRole();
                manageUserRole.setBackenduserid(manageUser.getId());
                manageUserRole.setRoleid(Integer.parseInt(roleId));
                manageUserRoleMapper.insert(manageUserRole);
            }

            builder.msg("添加人员成功");
            builder.success(true);
        } catch (Exception e) {
            log.error("添加人员失败", e);
            builder.msg("添加人员失败，请重试");
        }
        return builder.build();
    }

    @Transactional
    public BusinessMessage<JSONObject> doEditUser(ManageUserDTO manageUserDTO) {
        BusinessMessageBuilder<JSONObject> builder = new BusinessMessageBuilder<>();
        builder.success(false);
        try {
            ManageUser manageUser = manageUserMapper.selectByPrimaryKey(manageUserDTO.getId());
            manageUser.setName(manageUserDTO.getName());
            manageUser.setUsername(manageUserDTO.getUsername());
            manageUser.setPhone(manageUserDTO.getPhone());
            if(!StringUtils.isEmpty(manageUserDTO.getPassword())){
                manageUser.setPassword(passwordEncoder.encode(manageUserDTO.getPassword()));
            }
            manageUserMapper.updateByPrimaryKeySelective(manageUser);

            //更新角色
            Example example = new Example(ManageUserRole.class);
            example.createCriteria().andEqualTo("backenduserid",manageUser.getId());
            ManageUserRole manageUserRole = manageUserRoleMapper.selectByExample(example).get(0);
            manageUserRole.setRoleid(Integer.parseInt(manageUserDTO.getRoleId()));
            manageUserRoleMapper.updateByPrimaryKey(manageUserRole);

            builder.msg("修改成功");
            builder.success(true);
        } catch (Exception e) {
            log.error("修改人员失败", e);
            builder.msg("修改人员失败,请重试");
        }
        return builder.build();
    }

    public BusinessMessage<JSONObject> findBackendById(Integer id) {
        BusinessMessageBuilder<JSONObject> builder = new BusinessMessageBuilder<>();
        builder.success(false);
        try {
            ManageUser manageUser = manageUserMapper.selectByPrimaryKey(id);
            ManageUserDTO manageUserDTO = new ManageUserDTO();
            manageUser.setPassword("");

            //获取角色ID
            Example example = new Example(ManageUserRole.class);
            example.createCriteria().andEqualTo("backenduserid",manageUser.getId());
            List<ManageUserRole> manageUserRoles = manageUserRoleMapper.selectByExample(example);
            BeanUtils.copyProperties(manageUser, manageUserDTO);
            if (manageUserRoles != null && manageUserRoles.size() > 0) {
                //获取角色名称
                ManageRole role = manageRoleMapper.selectByPrimaryKey(manageUserRoles.get(0).getRoleid());
                manageUserDTO.setRoleName(role.getName());
                manageUserDTO.setRoleId(role.getId() + "");
            }
            JSONObject data = new JSONObject();
            data.put("info", manageUserDTO);
            builder.data(data);
            builder.success(true);
        } catch (Exception e) {
            log.error("查询人员失败", e);
            builder.msg("查询失败请重试");
        }
        return builder.build();
    }

    public BusinessMessage<JSONObject> restoreLoginPwd(Integer id) {
        BusinessMessageBuilder<JSONObject> builder = new BusinessMessageBuilder<>();
        builder.success(false);
        try {
            ManageUser backendUser = manageUserMapper.selectByPrimaryKey(id);
            backendUser.setPassword(passwordEncoder.encode("888888"));
            manageUserMapper.updateByPrimaryKeySelective(backendUser);
            builder.msg("密码重置成功，密码888888");
            builder.success(true);
        } catch (Exception e) {
            log.error("密码重置失败", e);
            builder.msg("密码重置失败，请重试");
        }
        return builder.build();
    }

    public BusinessMessage<JSONObject> indexRoleSearch(String role, Integer page, Integer size) {
        BusinessMessageBuilder<JSONObject> builder = new BusinessMessageBuilder<>();
        builder.success(false);
        try {
            PageHelper.startPage(page == null || page == 0 ? 1 : page, size == null ? 10 : size);
            Example example = new Example(ManageRole.class);
            if (!StringUtils.isEmpty(role)) {
                example.createCriteria().andLike("name", "%" + role + "%");
            }
            List<ManageRole> list = manageRoleMapper.selectByExample(example);
            if (null != list && list.size() > 0) {
                PageInfo<ManageRole> pageInfo = new PageInfo<>(list);
                JSONObject json = JSON.parseObject(JSON.toJSONString(pageInfo));
                JSONArray jsonArray = new JSONArray();
                list.forEach(e -> {
                    JSONObject item = new JSONObject();
                    item.put("info", e);
                    jsonArray.add(item);
                });
                json.put("list", jsonArray);
                builder.data(json);
                builder.success(true);
            } else {
                builder.msg("读取失败，请重试");
                builder.data(null);
            }
        } catch (Exception e) {
            log.error("该用户查询订单失败:" + e);
        }
        return builder.build();
    }

    public BusinessMessage<JSONObject> doAddRole(ManageRole role) {
        BusinessMessageBuilder<JSONObject> builder = new BusinessMessageBuilder<>();
        builder.success(false);
        try {
            manageRoleMapper.insert(role);
            builder.msg("添加角色成功");
            builder.success(true);
        } catch (Exception e) {
            log.error("添加角色失败", e);
            builder.msg("添加角色失败，请重试");
        }
        return builder.build();
    }

    public BusinessMessage<JSONObject> doEditRole(ManageRole role) {
        BusinessMessageBuilder<JSONObject> builder = new BusinessMessageBuilder<>();
        builder.success(false);
        try {
            manageRoleMapper.updateByPrimaryKeySelective(role);
            builder.msg("修改角色成功");
            builder.success(true);
        } catch (Exception e) {
            log.error("修改角色失败", e);
            builder.msg("修改角色失败，请重试");
        }
        return builder.build();
    }

    @Transactional
    public BusinessMessage<JSONObject> deleteRole(String ids) {
        BusinessMessageBuilder<JSONObject> builder = new BusinessMessageBuilder<>();
        builder.success(false);
        try {
            String[] idsS = ids.split(",");
            List<Integer> listIds = new ArrayList<>();
            for (String id : idsS) {
                listIds.add(Integer.parseInt(id));
            }
            //刪除角色
            Example example = new Example(ManageRole.class);
            example.createCriteria().andIn("id",listIds);
            manageRoleMapper.deleteByExample(example);
            //删除该角色绑定的权限
            Example menuRoleExample = new Example(ManageMenuRole.class);
            menuRoleExample.createCriteria().andIn("roleid",listIds);
            manageMenuRoleMapper.deleteByExample(menuRoleExample);
            builder.msg("删除角色成功");
            builder.success(true);
        } catch (Exception e) {
            log.error("刪除角色失败", e);
            builder.msg("刪除角色失败");
        }
        return builder.build();
    }

    public BusinessMessage<JSONObject> findRoleById(Integer id) {
        BusinessMessageBuilder<JSONObject> builder = new BusinessMessageBuilder<>();
        builder.success(false);
        try {
            JSONObject data = new JSONObject();
            data.put("info", manageRoleMapper.selectByPrimaryKey(id));
            builder.data(data);
            builder.success(true);
        } catch (Exception e) {
            log.error("查询角色失败", e);
            builder.msg("查询角色失败,请重试");
        }
        return builder.build();
    }

    @Transactional
    public BusinessMessage<JSONObject> authorization(Integer roleId, String menuIds) {
        BusinessMessageBuilder<JSONObject> builder = new BusinessMessageBuilder<>();
        builder.success(false);
        try {
            //判断该角色是否存在
            if (manageRoleMapper.selectByPrimaryKey(roleId) == null) {
                builder.msg("该角色不存在");
            }else {

                //清楚原有权限
                Example menuRoleExample = new Example(ManageMenuRole.class);
                menuRoleExample.createCriteria().andEqualTo("roleid",roleId);
                manageMenuRoleMapper.deleteByExample(menuRoleExample);

                String[] menuId = menuIds.split(",");
                ManageMenuRole menuRole;
                if (menuId != null && menuId.length > 0) {
                    for (String menu : menuId) {
                        menuRole = new ManageMenuRole();
                        menuRole.setMenuid(Integer.parseInt(menu));
                        menuRole.setRoleid(roleId);
                        manageMenuRoleMapper.insert(menuRole);
                    }
                }
                builder.msg("授权成功");
            }
        } catch (Exception e) {
            log.error("授权失败", e);
            builder.msg("授权失败,请重试");
        }
        return builder.build();
    }


    public BusinessMessage<JSONObject> getMenuTree() {
        BusinessMessageBuilder<JSONObject> builder = new BusinessMessageBuilder<>();
        builder.success(false);
        try {
            Example example = new Example(ManageMenu.class);
            example.setOrderByClause("sortNo");
            List<ManageMenu> lists = manageMenuMapper.selectByExample(example);
            JSONObject data = new JSONObject();
            data.put("tree", lists);
            builder.data(data);
            builder.success(true);
        } catch (Exception e) {
            log.error("获取菜单失败");
            builder.msg("获取菜单失败,请重试");
        }
        return builder.build();
    }

    public BusinessMessage<JSONObject> getAuthByRoleId(Integer roleId) {
        BusinessMessageBuilder<JSONObject> builder = new BusinessMessageBuilder<>();
        builder.success(false);
        try {
            Example menuRoleExample = new Example(ManageMenuRole.class);
            menuRoleExample.createCriteria().andEqualTo("roleid",roleId);
            JSONObject data = new JSONObject();
            data.put("tree", manageMenuRoleMapper.selectByExample(menuRoleExample));
            builder.data(data);
            builder.success(true);
        } catch (Exception e) {
            log.error("查询权限失败", e);
            builder.msg("查询权限失败，请重试");
        }
        return builder.build();
    }

    public BusinessMessage<JSONObject> findRoleInfo() {
        return null;
    }
}
