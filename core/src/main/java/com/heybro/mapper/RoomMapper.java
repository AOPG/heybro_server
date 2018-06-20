package com.heybro.mapper;

import com.heybro.entity.Room;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.HashMap;
import java.util.List;

public interface RoomMapper extends Mapper<Room> {
    /**
     * 查询房间信息
     */
    List<HashMap> RoomInfoList();


    /**
     * 查询房间信息详情
     */
    List<HashMap> RoomDetailInfoList(@Param("roomId") Integer roomId);


     /**
      * 查询用户和房间详细信息
      * */
     List<HashMap> RoomUserAndRoomInfo(@Param("roomId") Integer roomId);
}