package com.heybro.entity;

import java.io.Serializable;
import javax.persistence.*;

public class Cooperate implements Serializable {
    /**
     * 场地合作方表id
     */
    @Id
    @Column(name = "coop_id")
    private Integer coopId;

    /**
     * 合作方名称
     */
    @Column(name = "coop_name")
    private String coopName;

    private static final long serialVersionUID = 1L;

    /**
     * 获取场地合作方表id
     *
     * @return coop_id - 场地合作方表id
     */
    public Integer getCoopId() {
        return coopId;
    }

    /**
     * 设置场地合作方表id
     *
     * @param coopId 场地合作方表id
     */
    public void setCoopId(Integer coopId) {
        this.coopId = coopId;
    }

    /**
     * 获取合作方名称
     *
     * @return coop_name - 合作方名称
     */
    public String getCoopName() {
        return coopName;
    }

    /**
     * 设置合作方名称
     *
     * @param coopName 合作方名称
     */
    public void setCoopName(String coopName) {
        this.coopName = coopName == null ? null : coopName.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", coopId=").append(coopId);
        sb.append(", coopName=").append(coopName);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}