package com.heybro.mapper;

import com.heybro.entity.Room;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;
import java.util.HashMap;
import java.util.List;

public interface RoomMapper extends Mapper<Room> {

    /**
     * 查询打球房间信息
     */
    List<HashMap> RoomInfoList();

    /**
     * 查询打球房间信息
     */
    List<HashMap> BasketBallRoomInfoList();


    /**
     * 查询房间信息详情
     */
    List<HashMap> RoomDetailInfoList(@Param("roomId") Integer roomId);

    /**
     * 房间人数加一
     */
    void updateRoomNumByRoomId(@Param("RoomId") Integer roomId);

    /**
     * 匹配房间
     */
    List<HashMap> selectByTerm(@Param("mode") String mode,@Param("userRate") Integer userRate,@Param("type") Integer type);


}