package com.heybro.controller;//package com.heybro.controller;

import com.alibaba.fastjson.JSONObject;
import com.heybro.domain.BusinessMessage;
import com.heybro.domain.ManageUserDTO;
import com.heybro.entity.AverageUser;
import com.heybro.entity.ManageRole;
import com.heybro.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by 王攀 on 2018/5/29.
 */

@RestController
@RequestMapping("averageUser")
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * 查询普通用户列表
     *
     * @param page
     * @param size
     * @return
     */
    @GetMapping("indexSearch")
    public BusinessMessage<JSONObject> indexUserSearch(String userName,Integer page, Integer size) {
        return userService.indexUserSearch(userName,page, size);
    }

    /**
     * 修改用户
     */
    @RequestMapping("doEditAverageUser")
    public BusinessMessage<JSONObject> doEditAverageUser(AverageUser averageUser) {
        System.out.println(1111111);
        return userService.doEditAverageUser(averageUser);
    }

    /**
     * 添加用户
     *
     */
    @RequestMapping("doAddAverageUser")
    public BusinessMessage<JSONObject> doAddAverageUser(AverageUser averageUser) {
        return userService.doAddAverageUser(averageUser);
    }

    /**
     * 查询用户信息
     *
     * @param id
     * @return
     */
    @RequestMapping("findAverageUserById")
    public BusinessMessage<JSONObject> findAverageUserById(Integer id) {
        return userService.findAverageUserById(id);
    }

    /**
     * 删除用户
     *
     * @param ids
     * @return
     */
    @RequestMapping("deleteAverageUser")
    public BusinessMessage<JSONObject> deleteAverageUser(String ids) {
        return userService.deleteAverageUser(ids);
    }

}
