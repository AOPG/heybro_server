package com.heybro.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

public class Remark implements Serializable {
    /**
     * 备注信息表id
     */
    @Id
    @Column(name = "remark_id")
    private Integer remarkId;

    /**
     * 用户编码
     */
    @Column(name = "user_code")
    private String userCode;

    /**
     * 备注日期
     */
    @Column(name = "remark_date")
    private Date remarkDate;

    /**
     * 备注信息
     */
    @Column(name = "remark_info")
    private String remarkInfo;

    private static final long serialVersionUID = 1L;

    /**
     * 获取备注信息表id
     *
     * @return remark_id - 备注信息表id
     */
    public Integer getRemarkId() {
        return remarkId;
    }

    /**
     * 设置备注信息表id
     *
     * @param remarkId 备注信息表id
     */
    public void setRemarkId(Integer remarkId) {
        this.remarkId = remarkId;
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
     * 获取备注日期
     *
     * @return remark_date - 备注日期
     */
    public Date getRemarkDate() {
        return remarkDate;
    }

    /**
     * 设置备注日期
     *
     * @param remarkDate 备注日期
     */
    public void setRemarkDate(Date remarkDate) {
        this.remarkDate = remarkDate;
    }

    /**
     * 获取备注信息
     *
     * @return remark_info - 备注信息
     */
    public String getRemarkInfo() {
        return remarkInfo;
    }

    /**
     * 设置备注信息
     *
     * @param remarkInfo 备注信息
     */
    public void setRemarkInfo(String remarkInfo) {
        this.remarkInfo = remarkInfo == null ? null : remarkInfo.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", remarkId=").append(remarkId);
        sb.append(", userCode=").append(userCode);
        sb.append(", remarkDate=").append(remarkDate);
        sb.append(", remarkInfo=").append(remarkInfo);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}