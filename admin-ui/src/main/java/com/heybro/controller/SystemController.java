package com.heybro.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.heybro.domain.BusinessMessage;
import com.heybro.domain.ManageUserDTO;
import com.heybro.entity.ManageRole;
import com.heybro.service.SystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * 系统设置
 */
@RestController
@RequestMapping("system")
public class SystemController {

    @Autowired
    private SystemService systemService;

    /**
     * 查询系统用户
     *
     * @param page
     * @param size
     * @return
     */
    @GetMapping("indexSearch")
    public BusinessMessage<JSONObject> indexSearch(String userName, Integer role,Integer page, Integer size) {
        return this.systemService.findPage(userName, page, size);
    }

    /**
     * 添加人员
     *
     * @return
     */
    @PostMapping("doAddUser")
    public BusinessMessage<JSONObject> doAddUser(ManageUserDTO backendUserDTO) {
        return systemService.doAddUser(backendUserDTO);
    }

    /**
     * 修改人员
     *
     * @param backendUserDTO
     * @return
     */
    @RequestMapping("doEditUser")
    public BusinessMessage<JSONObject> doEditUser(ManageUserDTO backendUserDTO) {
        return systemService.doEditUser(backendUserDTO);
    }

    /**
     * 查询人员
     *
     * @param id
     * @return
     */
    @RequestMapping("findBackendById")
    public BusinessMessage<JSONObject> findBackendById(Integer id) {
        return systemService.findBackendById(id);
    }

    /**
     * 重置密码
     *
     * @return
     */
    @RequestMapping("restoreLoginPwd")
    public BusinessMessage<JSONObject> restoreLoginPwd(Integer id) {
        return systemService.restoreLoginPwd(id);
    }

    @RequestMapping("deleteUser")
    public BusinessMessage<JSONObject> deleteUser(String ids) {
       return this.systemService.deleteUser(ids);
    }

    /**
     * 分页角色
     *
     * @param role
     * @param page
     * @param size
     * @return
     */
    @GetMapping("indexRoleSearch")
    public BusinessMessage<JSONObject> indexRoleSearch(String role, Integer page, Integer size) {
        return systemService.indexRoleSearch(role, page, size);
    }

    /**
     * 添加角色
     *
     * @param role
     * @return
     */
    @RequestMapping("doAddRole")
    public BusinessMessage<JSONObject> doAddRole(ManageRole role) {
        return systemService.doAddRole(role);
    }

    /**
     * 添加角色
     *
     * @param role
     * @return
     */
    @RequestMapping("doEditRole")
    public BusinessMessage<JSONObject> doEditRole(ManageRole role) {
        return systemService.doEditRole(role);
    }

    /**
     * 删除角色
     *
     * @param ids
     * @return
     */
    @RequestMapping("deleteRole")
    public BusinessMessage<JSONObject> deleteRole(String ids) {
        return systemService.deleteRole(ids);
    }

    /**
     * 查询角色信息
     *
     * @param id
     * @return
     */
    @RequestMapping("findRoleById")
    public BusinessMessage<JSONObject> findRoleById(Integer id) {
        return systemService.findRoleById(id);
    }

    /**
     * 授权
     *
     * @param roleId
     * @param menuIds
     * @return
     */
    @PostMapping("doAuthorization")
    public BusinessMessage<JSONObject> doAuthorization(Integer roleId, String menuIds) {
        return systemService.authorization(roleId, menuIds);
    }

    /**
     * 获取系统菜单
     *
     * @return
     */
    @RequestMapping("getMenuTree")
    public BusinessMessage<JSONObject> getMenuTree() {
        return systemService.getMenuTree();
    }

    /**
     * 获取权限通过角色ID
     *
     * @param roleId 角色ID
     * @return
     */
    @RequestMapping("getAuthByRoleId")
    public BusinessMessage<JSONObject> getAuthByRoleId(Integer roleId) {
        return systemService.getAuthByRoleId(roleId);
    }

    /**
     * 获取所有角色信息
     * */

    @RequestMapping("findRoleInfo")
    public BusinessMessage<JSONObject> findRoleInfo() {
        return systemService.findRoleInfo();
    }
}
