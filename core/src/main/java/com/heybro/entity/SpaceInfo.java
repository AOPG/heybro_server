package com.heybro.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "space_info")
public class SpaceInfo implements Serializable {
    /**
     * 场地详情表id
     */
    @Id
    @Column(name = "space_info_id")
    private Integer spaceInfoId;

    /**
     * 合作方表id
     */
    @Column(name = "coop_id")
    private Integer coopId;

    /**
     * 场地编码
     */
    @Column(name = "space_code")
    private String spaceCode;

    /**
     * 日期
     */
    @Column(name = "space_date")
    private Date spaceDate;

    private static final long serialVersionUID = 1L;

    /**
     * 获取场地详情表id
     *
     * @return space_info_id - 场地详情表id
     */
    public Integer getSpaceInfoId() {
        return spaceInfoId;
    }

    /**
     * 设置场地详情表id
     *
     * @param spaceInfoId 场地详情表id
     */
    public void setSpaceInfoId(Integer spaceInfoId) {
        this.spaceInfoId = spaceInfoId;
    }

    /**
     * 获取合作方表id
     *
     * @return coop_id - 合作方表id
     */
    public Integer getCoopId() {
        return coopId;
    }

    /**
     * 设置合作方表id
     *
     * @param coopId 合作方表id
     */
    public void setCoopId(Integer coopId) {
        this.coopId = coopId;
    }

    /**
     * 获取场地编码
     *
     * @return space_code - 场地编码
     */
    public String getSpaceCode() {
        return spaceCode;
    }

    /**
     * 设置场地编码
     *
     * @param spaceCode 场地编码
     */
    public void setSpaceCode(String spaceCode) {
        this.spaceCode = spaceCode == null ? null : spaceCode.trim();
    }

    /**
     * 获取日期
     *
     * @return space_date - 日期
     */
    public Date getSpaceDate() {
        return spaceDate;
    }

    /**
     * 设置日期
     *
     * @param spaceDate 日期
     */
    public void setSpaceDate(Date spaceDate) {
        this.spaceDate = spaceDate;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", spaceInfoId=").append(spaceInfoId);
        sb.append(", coopId=").append(coopId);
        sb.append(", spaceCode=").append(spaceCode);
        sb.append(", spaceDate=").append(spaceDate);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}