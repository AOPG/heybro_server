package com.heybro.controller;//package com.heybro.controller;

import com.alibaba.fastjson.JSONObject;
import com.heybro.domain.BusinessMessage;
import com.heybro.entity.AverageUser;
import com.heybro.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * Created by 王攀 on 2018/5/29.
 */

@RestController
@RequestMapping("averageUser")
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * 根据id查询用户
     * */
    @ResponseBody
    @RequestMapping("searchUserById")
    public BusinessMessage<JSONObject> searchUserById(String id){
        return userService.searchUserById(id);
    }


    /***
     * 注册
     * */
    @ResponseBody
    @RequestMapping("ASRegister")
    public BusinessMessage<JSONObject> register(String userName,String userPass){
        return userService.register(userName,userPass);
    }

    /**
     * 加载用户个人信息
     * */
    @ResponseBody
    @RequestMapping("userInfo")
    public BusinessMessage<JSONObject> userInfo(String username,String access_token){
        return userService.userInfo(username,access_token);
    }

    /**
     * 上传头像
     * */


    /**
     * 修改用户信息
     * */
    @ResponseBody
    @RequestMapping("updateUserInfo")
    public BusinessMessage<JSONObject> updateUserInfo(String userCode,String userNickName,String userSex,
                                                      String userPortrait,String userIntro,String userProvince,String userCity,String birthday,String access_token){
        return userService.updateUserInfo(userCode,userNickName,userSex,userPortrait,userIntro,userProvince,userCity,birthday,access_token);
    }

    /**
     * 根据userCode获取个人信息
     * */
    @ResponseBody
    @RequestMapping("userInfoByCode")
    public BusinessMessage<JSONObject> userInfoByCode(String userCode){
        return userService.userInfoByCode(userCode);
    }


    /**
     * 修改密码
     *
     * */
    @ResponseBody
    @RequestMapping("resetPassword")
    public BusinessMessage<JSONObject> resetPassword(String userCode,String oldPassword,String newPassword,String access_token){
        return userService.resetPassword(userCode,oldPassword,newPassword,access_token);
    }




}
