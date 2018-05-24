package com.heybro.security;

import com.heybro.entity.ManageMenu;
import com.heybro.entity.ManageMenuRole;
import com.heybro.entity.ManageUser;
import com.heybro.entity.ManageUserRole;
import com.heybro.mapper.ManageMenuMapper;
import com.heybro.mapper.ManageMenuRoleMapper;
import com.heybro.mapper.ManageUserMapper;
import com.heybro.mapper.ManageUserRoleMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private ManageUserMapper userMapper;

    @Autowired
    private ManageUserRoleMapper manageUserRoleMapper;

    @Autowired
    private ManageMenuRoleMapper manageMenuRoleMapper;

    @Autowired
    private ManageMenuMapper manageMenuMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDetails userDetails = null;
        try {
            ManageUser user = userMapper.selectOne(new ManageUser() {{
                setUsername(username);
            }});

            if (null != user) {
                String menu = getMenu(user.getId());
                userDetails = new LoginUser(user, 10, menu);
            }
        } catch (Exception e) {
            //log.error("查询用户失败, 帐号 {}，{}", username, e.getMessage());
        }

        if (userDetails == null) {
            throw new UsernameNotFoundException("帐号" + username + "不存在");
        }

        return userDetails;
    }
    public String getMenu(Integer id) {
        try {
            //获取当前用户有哪些角色
            Example backendUserRoleExample = new Example(ManageUserRole.class);
            backendUserRoleExample.createCriteria().andEqualTo("backenduserid",id);
            List<ManageUserRole> backendUserRoleList = manageUserRoleMapper.selectByExample(backendUserRoleExample);

            //查询出该角色有哪些权限
            List<Integer> roleIds = new ArrayList<>();
            for (ManageUserRole backendUserRole : backendUserRoleList) {
                roleIds.add(backendUserRole.getRoleid());
            }

            if (roleIds.size() > 0) {
                Example menuRoleExample = new Example(ManageMenuRole.class);
                menuRoleExample.createCriteria().andIn("roleid",roleIds);
                List<ManageMenuRole> menuRoles = manageMenuRoleMapper.selectByExample(menuRoleExample);

                //查询出该角色有哪些菜单
                List<Integer> menuIds = new ArrayList<>();
                menuIds = menuIds.stream().distinct().collect(Collectors.toList());
                for (ManageMenuRole menuRole : menuRoles) {
                    menuIds.add(menuRole.getMenuid());
                }

                if (menuIds.size() > 0) {
                    //该用户所有的菜单
                    Example menuExample = new Example(ManageMenu.class);
                    menuExample.createCriteria().andIn("id",menuIds);
                    menuExample.setOrderByClause("sortNo");
                    List<ManageMenu> menus = manageMenuMapper.selectByExample(menuExample);

                    //所有的一级菜单
                    List<ManageMenu> firstMenus = menus.stream()
                            .filter(menu -> 1 == menu.getGrade())
                            .collect(Collectors.toList());
                    StringBuffer menusb = new StringBuffer();
                    for (ManageMenu menu : firstMenus) {
                        menusb.append("<li><a class=\"dropmenu\" href=\"#\"><i class=\""+menu.getIcon()+"\"></i>&nbsp;&nbsp;<span class=\"hidden-tablet\">" + menu.getName() + "</span></a>");
                        //一级菜单下的所有二级菜单
                        List<ManageMenu> twoMenus = menus.stream()
                                .filter(twoMenu -> menu.getId() == twoMenu.getPid())
                                .collect(Collectors.toList());
                        if(twoMenus!=null && twoMenus.size()>0){
                            menusb.append("<ul>");
                        }
                        for (ManageMenu twoMenu : twoMenus) {
                            menusb.append("<li><a class=\"submenu\" href=\"" + twoMenu.getUrl() + "\"><i class=\""+twoMenu.getIcon()+"\"></i>&nbsp;&nbsp;<span class=\"hidden-tablet\">"+twoMenu.getName()+"</span></a></li>");
                        }
                        if(twoMenus!=null && twoMenus.size()>0){
                            menusb.append("</ul>");
                        }
                        menusb.append("</li>");
                    }
                    return menusb.toString();
                } else {
                    //log.error("当前用户没有菜单,{}", id);
                }
            } else {
                //log.error("当前用户没有角色,{}", id);
            }
        } catch (Exception e) {
            //log.error("获取菜单失败", e);
        }
        return "";
    }
}
