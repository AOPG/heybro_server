package com.heybro.entity;

import java.io.Serializable;
import javax.persistence.*;

@Table(name = "video_cooperate")
public class VideoCooperate implements Serializable {
    /**
     * 视频合作方id
     */
    @Id
    @Column(name = "video_coop_id")
    private Integer videoCoopId;

    /**
     * 合作方名称
     */
    @Column(name = "video_coop_name")
    private String videoCoopName;

    private static final long serialVersionUID = 1L;

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
     * 获取合作方名称
     *
     * @return video_coop_name - 合作方名称
     */
    public String getVideoCoopName() {
        return videoCoopName;
    }

    /**
     * 设置合作方名称
     *
     * @param videoCoopName 合作方名称
     */
    public void setVideoCoopName(String videoCoopName) {
        this.videoCoopName = videoCoopName == null ? null : videoCoopName.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", videoCoopId=").append(videoCoopId);
        sb.append(", videoCoopName=").append(videoCoopName);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}