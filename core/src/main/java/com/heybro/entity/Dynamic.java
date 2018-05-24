package com.heybro.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

public class Dynamic implements Serializable {
    /**
     * 动态详情表id
     */
    @Id
    @Column(name = "dyn_Id")
    private Integer dynId;

    /**
     * 用户编码
     */
    @Column(name = "user_code")
    private String userCode;

    /**
     * 视频id
     */
    @Column(name = "vido_id")
    private Integer vidoId;

    /**
     * 发表日期
     */
    @Column(name = "dyn_date")
    private Date dynDate;

    /**
     * 有无图片（有1,无0）
     */
    @Column(name = "img_have")
    private Integer imgHave;

    /**
     * 动态内容
     */
    private String content;

    private static final long serialVersionUID = 1L;

    /**
     * 获取动态详情表id
     *
     * @return dyn_Id - 动态详情表id
     */
    public Integer getDynId() {
        return dynId;
    }

    /**
     * 设置动态详情表id
     *
     * @param dynId 动态详情表id
     */
    public void setDynId(Integer dynId) {
        this.dynId = dynId;
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
     * 获取视频id
     *
     * @return vido_id - 视频id
     */
    public Integer getVidoId() {
        return vidoId;
    }

    /**
     * 设置视频id
     *
     * @param vidoId 视频id
     */
    public void setVidoId(Integer vidoId) {
        this.vidoId = vidoId;
    }

    /**
     * 获取发表日期
     *
     * @return dyn_date - 发表日期
     */
    public Date getDynDate() {
        return dynDate;
    }

    /**
     * 设置发表日期
     *
     * @param dynDate 发表日期
     */
    public void setDynDate(Date dynDate) {
        this.dynDate = dynDate;
    }

    /**
     * 获取有无图片（有1,无0）
     *
     * @return img_have - 有无图片（有1,无0）
     */
    public Integer getImgHave() {
        return imgHave;
    }

    /**
     * 设置有无图片（有1,无0）
     *
     * @param imgHave 有无图片（有1,无0）
     */
    public void setImgHave(Integer imgHave) {
        this.imgHave = imgHave;
    }

    /**
     * 获取动态内容
     *
     * @return content - 动态内容
     */
    public String getContent() {
        return content;
    }

    /**
     * 设置动态内容
     *
     * @param content 动态内容
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", dynId=").append(dynId);
        sb.append(", userCode=").append(userCode);
        sb.append(", vidoId=").append(vidoId);
        sb.append(", dynDate=").append(dynDate);
        sb.append(", imgHave=").append(imgHave);
        sb.append(", content=").append(content);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}