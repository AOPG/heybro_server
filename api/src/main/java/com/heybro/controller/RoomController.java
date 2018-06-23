package com.heybro.controller;

import com.alibaba.fastjson.JSONObject;
import com.heybro.domain.BusinessMessage;
import com.heybro.entity.AverageUser;
import com.heybro.entity.Room;
import com.heybro.entity.RoomInfo;
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
     * 打球房间总信息
     */
    @ResponseBody
    @RequestMapping("BallRoomInfo")
    public BusinessMessage<JSONObject> roomInfo(){
        return roomService.roomInfo();
    }


    /**
     * 比赛房间总信息
     */
    @ResponseBody
    @RequestMapping("BasketBallRoomInfo")
    public BusinessMessage<JSONObject> basketBallRoomInfo(){
        return roomService.basketBallRoomInfo();
    }

    /**
     * 比赛房间总信息
     */
    @ResponseBody
    @RequestMapping("JoinBallRoom")
    public BusinessMessage<JSONObject>
    JoinBallRoom(String UserCode,Integer RoomId){
        return roomService.JoinBallRoom(UserCode,RoomId);
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

    /***
     *
     * 查询房间信息
     */
    @ResponseBody
    @RequestMapping("singleRoomInfo")
    public BusinessMessage<JSONObject> singleRoomInfo(Integer roomId){
        return roomService.singleRoomInfo(roomId);
    }

    /**
     * 退出房间
     *
     * */
    @ResponseBody
    @RequestMapping("exitRoom")
    public BusinessMessage<JSONObject> exitRoom(Integer roomId,String userCode){
        return roomService.exitRoom(roomId,userCode);
    }

    /***
     *
     * 查询用户是否已经拥有房间
     */
    @ResponseBody
    @RequestMapping("WethereHaveRoom")
    public BusinessMessage<JSONObject>
    WethereHaveRoom(String userCode){
        return roomService.WethereHaveRoom(userCode);
    }

}
