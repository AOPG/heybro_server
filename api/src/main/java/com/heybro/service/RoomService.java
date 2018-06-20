package com.heybro.service;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import com.heybro.domain.BusinessMessage;
import com.heybro.domain.BusinessMessageBuilder;
import com.heybro.mapper.RoomMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
     * 房间信息
     *
     */

    public BusinessMessage<com.alibaba.fastjson.JSONObject> roomInfo() {
        BusinessMessageBuilder<com.alibaba.fastjson.JSONObject> builder = new BusinessMessageBuilder<>();
        builder.success(false);
        try {

            List<HashMap> RoomList = roomMapper.RoomInfoList();
            if (null != RoomList && RoomList.size() > 0) {
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
                    jsonArray.add(item);
                }
                json.put("list", jsonArray);
                builder.data(json);
                builder.success(true);

            }
            else{
                builder.msg("加载房间信息失败！");
            }


        }catch (Exception e){
            builder.msg("服务器异常");
            e.printStackTrace();
        }
        return builder.build();
    }



}
