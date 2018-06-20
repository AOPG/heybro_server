package com.heybro.controller;

import com.alibaba.fastjson.JSONObject;
import com.heybro.domain.BusinessMessage;
import com.heybro.entity.Room;
import com.heybro.service.BasketRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by 壑过忘川 on 2018/6/19.
 * 创建房间
 */
@RestController
@RequestMapping("basketRoom")
public class BasketRoomController {
    @Autowired
    BasketRoomService basketRoomService;

    @ResponseBody
    @RequestMapping("createRoom")
    public BusinessMessage<JSONObject> createRoom(String roomName,int type,String mode,int rateLow,int rateHigh,int num,String password,String userCode){
        return basketRoomService.createBasketRoom(roomName,type,mode,rateLow,rateHigh,num,password,userCode);
    }
}