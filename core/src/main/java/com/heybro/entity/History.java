package com.heybro.entity;

import java.io.Serializable;
import javax.persistence.*;

public class History implements Serializable {
    /**
     * 历史记录表id
     */
    @Id
    @Column(name = "history_Id")
    private Integer historyId;

    /**
     * 用户编码
     */
    @Column(name = "user_code")
    private String userCode;

    /**
     * 观看类型(直播0，资讯1，动态2)
     */
    private Integer type;

    /**
     * 观看资讯id
     */
    @Column(name = "watch_id")
    private Integer watchId;

    private static final long serialVersionUID = 1L;

    /**
     * 获取历史记录表id
     *
     * @return history_Id - 历史记录表id
     */
    public Integer getHistoryId() {
        return historyId;
    }

    /**
     * 设置历史记录表id
     *
     * @param historyId 历史记录表id
     */
    public void setHistoryId(Integer historyId) {
        this.historyId = historyId;
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
     * 获取观看类型(直播0，资讯1，动态2)
     *
     * @return type - 观看类型(直播0，资讯1，动态2)
     */
    public Integer getType() {
        return type;
    }

    /**
     * 设置观看类型(直播0，资讯1，动态2)
     *
     * @param type 观看类型(直播0，资讯1，动态2)
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * 获取观看资讯id
     *
     * @return watch_id - 观看资讯id
     */
    public Integer getWatchId() {
        return watchId;
    }

    /**
     * 设置观看资讯id
     *
     * @param watchId 观看资讯id
     */
    public void setWatchId(Integer watchId) {
        this.watchId = watchId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", historyId=").append(historyId);
        sb.append(", userCode=").append(userCode);
        sb.append(", type=").append(type);
        sb.append(", watchId=").append(watchId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}