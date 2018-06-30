package com.heybro.service;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import com.heybro.domain.BusinessMessage;
import com.heybro.domain.BusinessMessageBuilder;
import com.heybro.entity.AverageUser;
import com.heybro.entity.Room;
import com.heybro.entity.RoomInfo;
import com.heybro.entity.UserInfo;
import com.heybro.mapper.AverageUserMapper;
import com.heybro.mapper.RoomInfoMapper;
import com.heybro.mapper.RoomMapper;
import com.heybro.mapper.UserInfoMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.HashMap;
import java.util.List;

/**
 * Created by 王攀 on 2018/5/29.
 */
@Service
@Slf4j
public class RoomService {

    @Autowired
    RoomMapper roomMapper;

    @Autowired
    RoomInfoMapper roomInfoMapper;

    @Autowired
    UserInfoMapper userInfoMapper;


    /**
     *
     * 房间信息详情
     *
     */
    public BusinessMessage<JSONObject> roomDetailInfo(Integer roomId) {
        BusinessMessageBuilder<JSONObject> builder = new BusinessMessageBuilder<>();
        builder.success(false);
        try {

            List<HashMap> roomDetailInfoList = roomMapper.RoomDetailInfoList(roomId);
            if (null != roomDetailInfoList && roomDetailInfoList.size() > 0) {
                JSONObject json  = new JSONObject();
                JSONArray jsonArray = new JSONArray();
                for (int i = 0;i<roomDetailInfoList.size();i++) {
                    JSONObject item = new JSONObject();

                    if(roomDetailInfoList.get(i).get("user_name")!=null){
                        item.put("userName",roomDetailInfoList.get(i).get("user_name").toString());
                    }else{
                        item.put("userName","");
                    }

                    if(roomDetailInfoList.get(i).get("user_portrait")!=null){
                        item.put("userPortrait",roomDetailInfoList.get(i).get("user_portrait").toString());
                    }else{
                        item.put("userPortrait","");
                    }
                    if(roomDetailInfoList.get(i).get("user_Intro")!=null){
                        item.put("userIntro",roomDetailInfoList.get(i).get("user_Intro").toString());
                    }else{
                        item.put("userIntro","");
                    }

                    if(roomDetailInfoList.get(i).get("user_nickname")!=null){
                        item.put("userNickname",roomDetailInfoList.get(i).get("user_nickname").toString());
                    }else{
                        item.put("userNickname","");
                    }

                    if(roomDetailInfoList.get(i).get("room_name")!=null){
                        item.put("roomName",roomDetailInfoList.get(i).get("room_name").toString());
                    }else{
                        item.put("roomName","");
                    }

                    if(roomDetailInfoList.get(i).get("room_num")!=null){
                        item.put("roomNum",roomDetailInfoList.get(i).get("room_num").toString());
                    }else{
                        item.put("roomNum","");
                    }

                    if(roomDetailInfoList.get(i).get("room_peo")!=null){
                        item.put("roomPeo",roomDetailInfoList.get(i).get("room_peo").toString());
                    }else{
                        item.put("roomPeo","");
                    }


                    jsonArray.add(item);
                }
                json.put("list", jsonArray);
                builder.data(json);
                builder.success(true);

            }
            else{
                builder.msg("加载房间详细信息失败！");
            }


        }catch (Exception e){
            builder.msg("服务器异常");
            e.printStackTrace();
        }
        return builder.build();
    }



    /**
     *
     * 加载房间信息
     *
     */
    public JSONObject loadingRoom(List<HashMap> RoomList){
        JSONObject json  = new JSONObject();
        JSONArray jsonArray = new JSONArray();
        for (int i = 0;i<RoomList.size();i++) {
            JSONObject item = new JSONObject();

            if(RoomList.get(i).get("room_Id")!=null){
                item.put("roomId",RoomList.get(i).get("room_Id").toString());
            }else{
                item.put("roomId","");
            }

            if(RoomList.get(i).get("room_name")!=null){
                item.put("roomName",RoomList.get(i).get("room_name").toString());
            }else{
                item.put("roomName","");
            }

            if(RoomList.get(i).get("room_num")!=null){
                item.put("roomNum",RoomList.get(i).get("room_num").toString());
            }else{
                item.put("roomNum","");
            }

            if(RoomList.get(i).get("room_peo")!=null){
                item.put("roomPeo",RoomList.get(i).get("room_peo").toString());
            }else{
                item.put("roomPeo","");
            }


            if(RoomList.get(i).get("room_pass")!=null){
                item.put("roomPass",RoomList.get(i).get("room_pass").toString());
            }else{
                item.put("roomPass","");
            }

            if(RoomList.get(i).get("room_pass_set")!=null){
                item.put("roomPassSet",RoomList.get(i).get("room_pass_set").toString());
            }else{
                item.put("roomPassSet","");
            }

            if(RoomList.get(i).get("room_lat")!=null){
                item.put("roomLat",RoomList.get(i).get("room_lat").toString());
            }else{
                item.put("roomLat","");
            }

            if(RoomList.get(i).get("room_lng")!=null){
                item.put("roomLng",RoomList.get(i).get("room_lng").toString());
            }else{
                item.put("roomLng","");
            }

            jsonArray.add(item);
        }
        json.put("list", jsonArray);


        return json;

    }


    /**
     *
     *  添加用户
     *
     * */

    @Transactional
    public BusinessMessage<JSONObject> JoinBallRoom(Integer roomId,String userCode)  {
        BusinessMessageBuilder<JSONObject> builder = new BusinessMessageBuilder<>();
        builder.success(false);
        try {

            RoomInfo roomInfo = new RoomInfo();
            roomInfo.setUserCode(userCode);
            roomInfo.setRoomId(roomId);

            //在房间详情中插入  房间id 用户code

            roomInfoMapper.insert(roomInfo);

            //在用户详情表插入 对应用户的 用户code

            userInfoMapper.updateRoomByUsercode(userCode,roomId);

            //当某一个用户进入房间后 房间已有的人数加一

            roomMapper.updateRoomNumByRoomId(roomId);


            builder.msg("加入讨论组成功");
            builder.success(true);
        } catch (Exception e) {
            builder.msg("加入讨论组失败，请重试");
        }
        return builder.build();
    }


    /**
     *
     * 打球房间信息
     *
     */

    public BusinessMessage<com.alibaba.fastjson.JSONObject> roomInfo() {
        BusinessMessageBuilder<com.alibaba.fastjson.JSONObject> builder = new BusinessMessageBuilder<>();
        builder.success(false);
        try {

            List<HashMap> RoomList = roomMapper.RoomInfoList();
            if (null != RoomList && RoomList.size() > 0) {

                builder.data(loadingRoom(RoomList));
                builder.success(true);

            }
            else{
                builder.msg("加载打球房间信息失败！");
            }


        }catch (Exception e){
            builder.msg("服务器异常");
            e.printStackTrace();
        }
        return builder.build();
    }



    /**
     *
     * 比赛房间信息
     *
     */

    public BusinessMessage<com.alibaba.fastjson.JSONObject> basketBallRoomInfo() {
        BusinessMessageBuilder<com.alibaba.fastjson.JSONObject> builder = new BusinessMessageBuilder<>();
        builder.success(false);
        try {

            List<HashMap> RoomList = roomMapper.BasketBallRoomInfoList();
            if (null != RoomList && RoomList.size() > 0) {

                builder.data(loadingRoom(RoomList));
                builder.success(true);

            }
            else{
                builder.msg("加载比赛房间信息失败！");
            }


        }catch (Exception e){
            builder.msg("服务器异常");
            e.printStackTrace();
        }
        return builder.build();
    }


    /**
     *
     * 查询用户和房间详细信息
     * */

    public BusinessMessage<com.alibaba.fastjson.JSONObject> roomAndUserInfo(Integer roomId) {
        BusinessMessageBuilder<com.alibaba.fastjson.JSONObject> builder = new BusinessMessageBuilder<>();
        builder.success(false);
        try {
            Room room = new Room();
            room.setRoomId(roomId);
            room = roomMapper.selectOne(room);
            List<HashMap> roomDetailInfoList = roomMapper.RoomDetailInfoList(roomId);
            if (null != roomDetailInfoList && roomDetailInfoList.size() > 0) {
                if (null!=room.getRoomType()&&room.getRoomType()!=2){
                    JSONObject json  = new JSONObject();
                    JSONArray jsonArray = JSONArray.parseArray(JSONArray.toJSONString(roomDetailInfoList));
                    json.put("list", jsonArray);
                    json.put("roomMode",room.getRoomMode());
                    json.put("roomId",room.getRoomId());
                    json.put("roomName",room.getRoomName());
                    json.put("roomPass",room.getRoomPass());
                    json.put("roomMasterCode",room.getMasterCode());
                    builder.data(json);
                    builder.success(true);
                }else {
                    builder.msg("该房间不存在！");
                }
            } else{
                builder.msg("加载房间信息失败！");
            }
        }catch (Exception e){
            builder.msg("服务器异常");
            e.printStackTrace();
        }
        return builder.build();
    }

    /**
     * 单个房间信息
     * */
    public BusinessMessage<JSONObject> singleRoomInfo(Integer roomId) {
        BusinessMessageBuilder<com.alibaba.fastjson.JSONObject> builder = new BusinessMessageBuilder<>();
        builder.success(false);
        builder.code("500");
        try {
            Room room = roomMapper.selectOne(new Room(){{
                setRoomId(roomId);
            }});
            if (null!=room){
                JSONObject roomInfo = JSONObject.parseObject(JSONObject.toJSONString(room));
                builder.data(roomInfo);
                builder.success(true);
                builder.msg("加载成功!");
                builder.code("200");
            }else {
                builder.msg("无该房间信息!");
            }
        }catch (Exception e){
            builder.msg("服务器异常");
            e.printStackTrace();
        }
        return builder.build();
    }



    /**
     *
     * 用户是否拥有房间
     *
     */

    public BusinessMessage<com.alibaba.fastjson.JSONObject> WethereHaveRoom(String userCode) {
        BusinessMessageBuilder<com.alibaba.fastjson.JSONObject> builder = new BusinessMessageBuilder<>();
        builder.success(false);
        try {

            Example example = new Example(UserInfo.class);
            Example.Criteria criteria = example.createCriteria();
            System.out.println(userCode);
            criteria.andEqualTo("userCode",userCode);
            List<UserInfo> UserInfolList = userInfoMapper.selectByExample(example);
            JSONObject json  = new JSONObject();

            if (null != UserInfolList && UserInfolList.size() > 0) {

                JSONArray jsonArray = new JSONArray();

                for (int i = 0;i<UserInfolList.size();i++) {

                        JSONObject item = new JSONObject();
                        item.put("roomId", UserInfolList.get(i).getRoomId());

                        jsonArray.add(item);
                    }

                json.put("list", jsonArray);
                builder.data(json);
                builder.success(true);

            }
            else{
                builder.msg("加载打球房间信息失败！");
            }


        }catch (Exception e){
            builder.msg("服务器异常");
            e.printStackTrace();
        }
        return builder.build();
    }

    /**
     * 退出房间
     * */
    @Transactional
    public BusinessMessage<JSONObject> exitRoom(Integer roomId,String userCode) {
        BusinessMessageBuilder<com.alibaba.fastjson.JSONObject> builder = new BusinessMessageBuilder<>();
        builder.success(false);
        builder.code("500");
        try {
            Room room = roomMapper.selectOne(new Room(){{
                setRoomId(roomId);
            }});
            if (userCode.equals(room.getMasterCode())){
                room.setRoomType(2);
                room.setRoomPeo(room.getRoomPeo()-1);
                roomMapper.updateByPrimaryKey(room);
            }
            UserInfo userInfo = userInfoMapper.selectOne(new UserInfo(){{
                setUserCode(userCode);
            }});
            userInfo.setRoomId(0);
            userInfoMapper.updateByPrimaryKey(userInfo);
            RoomInfo roomInfo = roomInfoMapper.selectOne(new RoomInfo(){{
                setUserCode(userCode);
            }});
            roomInfoMapper.delete(roomInfo);
            builder.code("200");
            builder.msg("退出成功！");
            builder.success(true);
        }catch (Exception e){
            builder.msg("服务器异常");
            e.printStackTrace();
        }
        return builder.build();
    }

}
