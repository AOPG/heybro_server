package com.heybro.entity;

import java.io.Serializable;
import javax.persistence.*;

public class Business implements Serializable {
    /**
     * 商家表id
     */
    @Id
    @Column(name = "bus_id")
    private Integer busId;

    /**
     * 商家编码
     */
    @Column(name = "bus_code")
    private String busCode;

    /**
     * 商家名称
     */
    @Column(name = "bus_name")
    private String busName;

    private static final long serialVersionUID = 1L;

    /**
     * 获取商家表id
     *
     * @return bus_id - 商家表id
     */
    public Integer getBusId() {
        return busId;
    }

    /**
     * 设置商家表id
     *
     * @param busId 商家表id
     */
    public void setBusId(Integer busId) {
        this.busId = busId;
    }

    /**
     * 获取商家编码
     *
     * @return bus_code - 商家编码
     */
    public String getBusCode() {
        return busCode;
    }

    /**
     * 设置商家编码
     *
     * @param busCode 商家编码
     */
    public void setBusCode(String busCode) {
        this.busCode = busCode == null ? null : busCode.trim();
    }

    /**
     * 获取商家名称
     *
     * @return bus_name - 商家名称
     */
    public String getBusName() {
        return busName;
    }

    /**
     * 设置商家名称
     *
     * @param busName 商家名称
     */
    public void setBusName(String busName) {
        this.busName = busName == null ? null : busName.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", busId=").append(busId);
        sb.append(", busCode=").append(busCode);
        sb.append(", busName=").append(busName);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}