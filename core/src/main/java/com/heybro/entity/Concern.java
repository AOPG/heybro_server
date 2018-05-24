package com.heybro.entity;

import java.io.Serializable;
import javax.persistence.*;

public class Concern implements Serializable {
    /**
     * 关注表id
     */
    @Id
    @Column(name = "concern_Id")
    private Integer concernId;

    /**
     * 用户编码
     */
    @Column(name = "user_code")
    private String userCode;

    /**
     * 我的关注编码
     */
    @Column(name = "user_concern_code")
    private String userConcernCode;

    private static final long serialVersionUID = 1L;

    /**
     * 获取关注表id
     *
     * @return concern_Id - 关注表id
     */
    public Integer getConcernId() {
        return concernId;
    }

    /**
     * 设置关注表id
     *
     * @param concernId 关注表id
     */
    public void setConcernId(Integer concernId) {
        this.concernId = concernId;
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
     * 获取我的关注编码
     *
     * @return user_concern_code - 我的关注编码
     */
    public String getUserConcernCode() {
        return userConcernCode;
    }

    /**
     * 设置我的关注编码
     *
     * @param userConcernCode 我的关注编码
     */
    public void setUserConcernCode(String userConcernCode) {
        this.userConcernCode = userConcernCode == null ? null : userConcernCode.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", concernId=").append(concernId);
        sb.append(", userCode=").append(userCode);
        sb.append(", userConcernCode=").append(userConcernCode);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}