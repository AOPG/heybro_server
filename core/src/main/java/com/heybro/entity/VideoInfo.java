package com.heybro.entity;

import java.io.Serializable;
import javax.persistence.*;

@Table(name = "video_info")
public class VideoInfo implements Serializable {
    /**
     * 视频详情表id
     */
    @Id
    @Column(name = "video_info_id")
    private Integer videoInfoId;

    /**
     * 视频合作方id
     */
    @Column(name = "video_coop_id")
    private Integer videoCoopId;

    /**
     * 视屏编码
     */
    @Column(name = "video_code")
    private String videoCode;

    private static final long serialVersionUID = 1L;

    /**
     * 获取视频详情表id
     *
     * @return video_info_id - 视频详情表id
     */
    public Integer getVideoInfoId() {
        return videoInfoId;
    }

    /**
     * 设置视频详情表id
     *
     * @param videoInfoId 视频详情表id
     */
    public void setVideoInfoId(Integer videoInfoId) {
        this.videoInfoId = videoInfoId;
    }

    /**
     * 获取视频合作方id
     *
     * @return video_coop_id - 视频合作方id
     */
    public Integer getVideoCoopId() {
        return videoCoopId;
    }

    /**
     * 设置视频合作方id
     *
     * @param videoCoopId 视频合作方id
     */
    public void setVideoCoopId(Integer videoCoopId) {
        this.videoCoopId = videoCoopId;
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", videoInfoId=").append(videoInfoId);
        sb.append(", videoCoopId=").append(videoCoopId);
        sb.append(", videoCode=").append(videoCode);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}