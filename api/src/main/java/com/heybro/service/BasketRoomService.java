package com.heybro.service;

import com.alibaba.fastjson.JSONObject;
import com.heybro.domain.BusinessMessage;
import com.heybro.domain.BusinessMessageBuilder;
import com.heybro.entity.Room;
import com.heybro.mapper.RoomMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by 壑过忘川 on 2018/6/19.
 * 创建房间
 */
@Service
@Slf4j
public class BasketRoomService {
    @Autowired
    RoomMapper roomMapper;

    /**
     * 创建房间
     */
    public BusinessMessage<JSONObject> createBasketRoom(String roomName,int type,String mode,String rate,int num,String password,String userCode) {
        BusinessMessageBuilder<JSONObject> builder = new BusinessMessageBuilder<>();
        builder.success(false);
        try{
            Room basketRoom = new Room();
            basketRoom.setRoomName(roomName);
            basketRoom.setRoomType(type);
            basketRoom.setRoomMode(mode);
            basketRoom.setRoomRate(rate);
            basketRoom.setRoomNum(num);
            if(password != null){
                basketRoom.setRoomPass(password);
                basketRoom.setRoomPassSet(1);
            }else{
                basketRoom.setRoomPassSet(0);
            }
            basketRoom.setMasterCode(userCode);
            roomMapper.insert(basketRoom);
            if (basketRoom != null){
                JSONObject json = new JSONObject();
                json.put("room",basketRoom);
                builder.data(json);
                builder.success(true);
                builder.msg("创建成功！");
            }else {
                builder.msg("创建失败！");
            }
        }catch (Exception e){
            e.printStackTrace();
            builder.msg("服务器异常！");
        }
        return builder.build();
    }
}
