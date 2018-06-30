package com.heybro.controller;


import com.alibaba.fastjson.JSONObject;
import com.heybro.domain.BusinessMessage;
import com.heybro.service.ConcernService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
    @RequestMapping("concern")
public class ConcernController {


    @Autowired
    ConcernService concernService;

    /**
     * 获取关注列表
     * */

    @ResponseBody
    @RequestMapping("getConcernIndex")
    public BusinessMessage<JSONObject> getConcernIndex(String userCode){
        return concernService.getConcernIndex(userCode);
    }

    /**
     * 关注操作
     * */
    @ResponseBody
    @RequestMapping("concernByUserCode")
    public BusinessMessage<JSONObject> concernByUserCode(String userCode,String concernCode,String access_token){
        return concernService.concernByUserCode(userCode,concernCode,access_token);
    }

    /**
     * 取消关注
     * */

}
