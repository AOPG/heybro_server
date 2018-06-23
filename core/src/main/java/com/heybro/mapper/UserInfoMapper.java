package com.heybro.mapper;

import com.heybro.entity.UserInfo;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

public interface UserInfoMapper extends Mapper<UserInfo> {

    /**
     *
     * 用户进入房间添加房间信息
     *
     * */
    void updateRoomByUsercode(@Param("Usercode") String id,
                              @Param("RoomId") Integer roomId);
}