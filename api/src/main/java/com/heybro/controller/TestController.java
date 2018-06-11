package com.heybro.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("test")
public class TestController {

    @ResponseBody
    @RequestMapping("hello")
    public String hello(){
        return "hello";
    }
}
