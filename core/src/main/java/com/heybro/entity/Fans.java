package com.heybro.entity;

import java.io.Serializable;
import javax.persistence.*;

public class Fans implements Serializable {
    /**
     * 粉丝表id
     */
    @Id
    @Column(name = "fans_Id")
    private Integer fansId;

    /**
     * 用户编码
     */
    @Column(name = "user_code")
    private String userCode;

    /**
     * 我的粉丝code
     */
    @Column(name = "user_fans_code")
    private String userFansCode;

    private static final long serialVersionUID = 1L;

    /**
     * 获取粉丝表id
     *
     * @return fans_Id - 粉丝表id
     */
    public Integer getFansId() {
        return fansId;
    }

    /**
     * 设置粉丝表id
     *
     * @param fansId 粉丝表id
     */
    public void setFansId(Integer fansId) {
        this.fansId = fansId;
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
     * 获取我的粉丝code
     *
     * @return user_fans_code - 我的粉丝code
     */
    public String getUserFansCode() {
        return userFansCode;
    }

    /**
     * 设置我的粉丝code
     *
     * @param userFansCode 我的粉丝code
     */
    public void setUserFansCode(String userFansCode) {
        this.userFansCode = userFansCode == null ? null : userFansCode.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", fansId=").append(fansId);
        sb.append(", userCode=").append(userCode);
        sb.append(", userFansCode=").append(userFansCode);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}