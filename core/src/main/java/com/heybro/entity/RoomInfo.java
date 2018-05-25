package com.heybro.entity;

import java.io.Serializable;
import javax.persistence.*;

@Table(name = "room_info")
public class RoomInfo implements Serializable {
    /**
     * 房间信息表id
     */
    @Id
    @Column(name = "room_info_id")
    private Integer roomInfoId;

    /**
     * 房间id
     */
    @Column(name = "room_id")
    private Integer roomId;

    /**
     * 用户编码
     */
    @Column(name = "user_code")
    private String userCode;

    /**
     * 用户队伍
     */
    private String team;

    /**
     * 用户位置
     */
    private String position;

    /**
     * 胜负结果
     */
    private String result;

    private static final long serialVersionUID = 1L;

    /**
     * 获取房间信息表id
     *
     * @return room_info_id - 房间信息表id
     */
    public Integer getRoomInfoId() {
        return roomInfoId;
    }

    /**
     * 设置房间信息表id
     *
     * @param roomInfoId 房间信息表id
     */
    public void setRoomInfoId(Integer roomInfoId) {
        this.roomInfoId = roomInfoId;
    }

    /**
     * 获取房间id
     *
     * @return room_id - 房间id
     */
    public Integer getRoomId() {
        return roomId;
    }

    /**
     * 设置房间id
     *
     * @param roomId 房间id
     */
    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }

    /**
     * 获取用户编码
     *
     * @return user_code - 用户编码
     */
    public String getUserCode() {
        return userCode;
    }

    /**
     * 设置用户编码
     *
     * @param userCode 用户编码
     */
    public void setUserCode(String userCode) {
        this.userCode = userCode == null ? null : userCode.trim();
    }

    /**
     * 获取用户队伍
     *
     * @return team - 用户队伍
     */
    public String getTeam() {
        return team;
    }

    /**
     * 设置用户队伍
     *
     * @param team 用户队伍
     */
    public void setTeam(String team) {
        this.team = team == null ? null : team.trim();
    }

    /**
     * 获取用户位置
     *
     * @return position - 用户位置
     */
    public String getPosition() {
        return position;
    }

    /**
     * 设置用户位置
     *
     * @param position 用户位置
     */
    public void setPosition(String position) {
        this.position = position == null ? null : position.trim();
    }

    /**
     * 获取胜负结果
     *
     * @return result - 胜负结果
     */
    public String getResult() {
        return result;
    }

    /**
     * 设置胜负结果
     *
     * @param result 胜负结果
     */
    public void setResult(String result) {
        this.result = result == null ? null : result.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", roomInfoId=").append(roomInfoId);
        sb.append(", roomId=").append(roomId);
        sb.append(", userCode=").append(userCode);
        sb.append(", team=").append(team);
        sb.append(", position=").append(position);
        sb.append(", result=").append(result);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}