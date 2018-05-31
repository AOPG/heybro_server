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
     *
     *普通用户登陆
     *
     */
    @ResponseBody
    @GetMapping("ASLogin")
    public String selectAverageUser(String userName,String userPass) throws IOException{

        return userService.selectAverageUser(userName,userPass);
    }

}
