package com.heybro.controller;

import com.alibaba.fastjson.JSONObject;
import com.heybro.domain.BusinessMessage;
import com.heybro.service.ConcernService;
import com.heybro.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by 王攀 on 2018/5/29.
 */

@RestController
@RequestMapping("BasketBallRoom")
public class RoomController {
    @Autowired
    RoomService roomService;

    /**
     * 房间总信息
     */
    @ResponseBody
    @RequestMapping("BallRoomInfo")
    public BusinessMessage<JSONObject> roomInfo(){
        return roomService.roomInfo();
    }


    /**
     * 房间信息详情
     */
    @ResponseBody
    @RequestMapping("BallRoomDetailedInfo")
    public BusinessMessage<JSONObject> roomDetailInfo(Integer roomId){
        return roomService.roomDetailInfo(roomId);
    }

    /**
     * 查询用户和房间详细信息
     */
    @ResponseBody
    @RequestMapping("roomAndUserInfo")
    public BusinessMessage<JSONObject> roomAndUserInfo(Integer roomId){
        return roomService.roomAndUserInfo(roomId);
    }


}
