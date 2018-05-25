package com.heybro.entity;

import java.io.Serializable;
import javax.persistence.*;

@Table(name = "user_room_info")
public class UserRoomInfo implements Serializable {
    /**
     * 用户房间信息表id
     */
    @Id
    @Column(name = "user_room_info_id")
    private Integer userRoomInfoId;

    /**
     * 用户编码
     */
    @Column(name = "user_code")
    private String userCode;

    /**
     * 黑名单房间id
     */
    private Integer blacklist;

    private static final long serialVersionUID = 1L;

    /**
     * 获取用户房间信息表id
     *
     * @return user_room_info_id - 用户房间信息表id
     */
    public Integer getUserRoomInfoId() {
        return userRoomInfoId;
    }

    /**
     * 设置用户房间信息表id
     *
     * @param userRoomInfoId 用户房间信息表id
     */
    public void setUserRoomInfoId(Integer userRoomInfoId) {
        this.userRoomInfoId = userRoomInfoId;
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
     * 获取黑名单房间id
     *
     * @return blacklist - 黑名单房间id
     */
    public Integer getBlacklist() {
        return blacklist;
    }

    /**
     * 设置黑名单房间id
     *
     * @param blacklist 黑名单房间id
     */
    public void setBlacklist(Integer blacklist) {
        this.blacklist = blacklist;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", userRoomInfoId=").append(userRoomInfoId);
        sb.append(", userCode=").append(userCode);
        sb.append(", blacklist=").append(blacklist);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}