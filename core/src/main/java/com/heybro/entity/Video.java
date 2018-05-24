package com.heybro.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

public class Video implements Serializable {
    /**
     * 视频表表id
     */
    @Id
    @Column(name = "video_id")
    private Integer videoId;

    /**
     * 视屏编码
     */
    @Column(name = "video_code")
    private String videoCode;

    /**
     * 视屏名称
     */
    @Column(name = "video_name")
    private String videoName;

    /**
     * 视频时长
     */
    @Column(name = "video_time")
    private Date videoTime;

    private static final long serialVersionUID = 1L;

    /**
     * 获取视频表表id
     *
     * @return video_id - 视频表表id
     */
    public Integer getVideoId() {
        return videoId;
    }

    /**
     * 设置视频表表id
     *
     * @param videoId 视频表表id
     */
    public void setVideoId(Integer videoId) {
        this.videoId = videoId;
    }

    /**
     * 获取视屏编码
     *
     * @return video_code - 视屏编码
     */
    public String getVideoCode() {
        return videoCode;
    }

    /**
     * 设置视屏编码
     *
     * @param videoCode 视屏编码
     */
    public void setVideoCode(String videoCode) {
        this.videoCode = videoCode == null ? null : videoCode.trim();
    }

    /**
     * 获取视屏名称
     *
     * @return video_name - 视屏名称
     */
    public String getVideoName() {
        return videoName;
    }

    /**
     * 设置视屏名称
     *
     * @param videoName 视屏名称
     */
    public void setVideoName(String videoName) {
        this.videoName = videoName == null ? null : videoName.trim();
    }

    /**
     * 获取视频时长
     *
     * @return video_time - 视频时长
     */
    public Date getVideoTime() {
        return videoTime;
    }

    /**
     * 设置视频时长
     *
     * @param videoTime 视频时长
     */
    public void setVideoTime(Date videoTime) {
        this.videoTime = videoTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", videoId=").append(videoId);
        sb.append(", videoCode=").append(videoCode);
        sb.append(", videoName=").append(videoName);
        sb.append(", videoTime=").append(videoTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}