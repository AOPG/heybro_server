package com.heybro.service;


import com.alibaba.fastjson.JSONObject;
import com.heybro.domain.BusinessMessage;
import com.heybro.domain.BusinessMessageBuilder;
import com.heybro.entity.Room;
import com.heybro.entity.RoomInfo;
import com.heybro.entity.UserInfo;
import com.heybro.mapper.RoomInfoMapper;
import com.heybro.mapper.RoomMapper;
import com.heybro.mapper.UserInfoMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by 壑过忘川 on 2018/6/19.
 * 创建房间
 */
@Service
@Slf4j
public class BasketRoomService {
    @Autowired
    RoomMapper roomMapper;
    @Autowired
    UserInfoMapper userInfoMapper;
    @Autowired
    RoomInfoMapper roomInfoMapper;
    /**
     * 创建房间
     */
    public BusinessMessage<JSONObject> createBasketRoom(String roomId,String roomName,int type,String mode,int rateLow,int rateHigh,int num,String password,String userCode) {
        BusinessMessageBuilder<JSONObject> builder = new BusinessMessageBuilder<>();
        builder.success(false);
        try{
            UserInfo userInfo = new UserInfo();
            Room basketRoom = new Room();
            RoomInfo roomInfo = new RoomInfo();

            userInfo.setUserCode(userCode);
            userInfo = userInfoMapper.selectOne(userInfo);
            if(userInfo.getRoomId() ==0||userInfo.getRoomId() == null) {
                userInfo.setRoomId(Integer.parseInt(roomId));
                basketRoom.setRoomId(Integer.parseInt(roomId));
                basketRoom.setRoomName(roomName);
                basketRoom.setRoomType(type);
                basketRoom.setRoomMode(mode);
                basketRoom.setRoomRateLow(rateLow);
                basketRoom.setRoomRateHigh(rateHigh);
                basketRoom.setRoomNum(num);
                basketRoom.setRoomPeo(1);
                if (password != null) {
                    basketRoom.setRoomPass(password);
                    basketRoom.setRoomPassSet(1);
                } else {
                    basketRoom.setRoomPassSet(0);
                }
                basketRoom.setMasterCode(userCode);

                roomInfo.setUserCode(userCode);
                roomInfo.setRoomId(Integer.parseInt(roomId));
                userInfoMapper.updateByPrimaryKey(userInfo);
                roomMapper.insert(basketRoom);
                roomInfoMapper.insert(roomInfo);
                if (basketRoom != null) {
                    JSONObject json = new JSONObject();
                    json.put("room", basketRoom);
                    json.put("roominfo", roomInfo);
                    json.put("master", userInfo);
                    builder.data(json);
                    builder.success(true);
                    builder.msg("创建成功！");
                } else {
                    builder.msg("创建失败！");
                }
            }else{
                builder.msg("已经加入或创建一个房间，无需创建");
            }
        }catch (Exception e){
            e.printStackTrace();
            builder.msg("服务器异常！");
        }
        return builder.build();
    }

    /**
     * 搜索房间
     * @return
     */
    public BusinessMessage<JSONObject> searchAllRoom(String userCode) {
        BusinessMessageBuilder<JSONObject> builder = new BusinessMessageBuilder<>();
        builder.success(false);
        try{
            List<Room> roomList = new ArrayList<Room>();
            roomList = roomMapper.selectAll();
            if (null != roomList&&roomList.size() > 0) {
                JSONObject json = new JSONObject();
                json.put("roomlist", roomList);
                builder.data(json);
                builder.success(true);
                builder.msg("查询成功！");
            } else {
                builder.msg("查询失败！");
            }
        }catch (Exception e){
            e.printStackTrace();
            builder.msg("服务器异常！");
        }
        return builder.build();
    }

    /**
     * 匹配房间
     * @param mode
     * @param userRate
     * @param type
     * @return
     */
    public BusinessMessage<JSONObject> matchRoom(String mode,int userRate,int type,String userCode) {
        BusinessMessageBuilder<JSONObject> builder = new BusinessMessageBuilder<>();
        builder.success(false);
        try{
            UserInfo userInfo = new UserInfo();
            userInfo.setUserCode(userCode);
            userInfo = userInfoMapper.selectOne(userInfo);
            if(userInfo.getRoomId() ==0||userInfo.getRoomId() == null) {
                if(mode.equals("无限制")){
                    mode = null;
                }
                List<HashMap> matchRoomList = roomMapper.selectByTerm(mode, userRate, type);
                if (null != matchRoomList && matchRoomList.size() > 0) {
                    JSONObject json = new JSONObject();
                    Room matchRoom = new Room();
                    if(matchRoomList.get(0).get("room_Id")!=null){
                        matchRoom.setRoomId((Integer)matchRoomList.get(0).get("room_Id"));
                    }
                    if(matchRoomList.get(0).get("room_name")!=null){
                        matchRoom.setRoomName(matchRoomList.get(0).get("room_name").toString());
                    }
                    if(matchRoomList.get(0).get("room_num")!=null){
                        matchRoom.setRoomNum((Integer)matchRoomList.get(0).get("room_num"));
                    }
                    if(matchRoomList.get(0).get("room_peo")!=null){
                        matchRoom.setRoomPeo(Integer.parseInt(matchRoomList.get(0).get("room_peo").toString()));
                    }
                    json.put("matchRoom", matchRoom);
                    builder.data(json);
                    builder.success(true);
                    builder.msg("匹配成功！");
                } else {
                    builder.msg("没有符合条件的房间！");
                }
            }else{
                builder.msg("已经加入或创建一个房间，无需匹配");
            }
        }catch (Exception e){
            e.printStackTrace();
            builder.msg("服务器异常！");
        }
        return builder.build();
    }
}
