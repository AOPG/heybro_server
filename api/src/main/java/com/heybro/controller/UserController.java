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



    @ResponseBody
    @RequestMapping("hello")
    public String hello(){
        return "hello";
    }



    /**
     *
     *普通用户登陆
     *
     */
    @ResponseBody
    @RequestMapping("ASLogin")
    public BusinessMessage<JSONObject> login(String userName,String userPass){
        return userService.login(userName,userPass);
    }


    /***
     * 注册
     * */
    @ResponseBody
    @GetMapping("ASRegister")
    public BusinessMessage<JSONObject> register(String userName,String userPass){
        return userService.register(userName,userPass);
    }

}
