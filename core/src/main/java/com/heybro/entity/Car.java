package com.heybro.entity;

import java.io.Serializable;
import javax.persistence.*;

public class Car implements Serializable {
    /**
     * 购物车表id
     */
    @Id
    @Column(name = "car_id")
    private Integer carId;

    /**
     * 用户编码
     */
    @Column(name = "user_code")
    private String userCode;

    private static final long serialVersionUID = 1L;

    /**
     * 获取购物车表id
     *
     * @return car_id - 购物车表id
     */
    public Integer getCarId() {
        return carId;
    }

    /**
     * 设置购物车表id
     *
     * @param carId 购物车表id
     */
    public void setCarId(Integer carId) {
        this.carId = carId;
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", carId=").append(carId);
        sb.append(", userCode=").append(userCode);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}