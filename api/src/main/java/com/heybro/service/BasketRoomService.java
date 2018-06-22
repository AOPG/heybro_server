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
            userInfo.setRoomId(Integer.parseInt(roomId));

            basketRoom.setRoomId(Integer.parseInt(roomId));
            basketRoom.setRoomName(roomName);
            basketRoom.setRoomType(type);
            basketRoom.setRoomMode(mode);
            basketRoom.setRoomRateLow(rateLow);
            basketRoom.setRoomRateHigh(rateHigh);
            basketRoom.setRoomNum(num);
            if(password != null){
                basketRoom.setRoomPass(password);
                basketRoom.setRoomPassSet(1);
            }else{
                basketRoom.setRoomPassSet(0);
            }
            basketRoom.setMasterCode(userCode);

            roomInfo.setUserCode(userCode);
            roomInfo.setRoomId(Integer.parseInt(roomId));
            userInfoMapper.updateByPrimaryKey(userInfo);
            roomMapper.insert(basketRoom);
            roomInfoMapper.insert(roomInfo);
            if (basketRoom != null){
                JSONObject json = new JSONObject();
                json.put("room",basketRoom);
                json.put("roominfo",roomInfo);
                json.put("master",userInfo);
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
