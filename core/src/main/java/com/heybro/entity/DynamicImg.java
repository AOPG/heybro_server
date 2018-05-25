package com.heybro.entity;

import java.io.Serializable;
import javax.persistence.*;

@Table(name = "dynamic_img")
public class DynamicImg implements Serializable {
    /**
     * 动态图片详情表id
     */
    @Id
    @Column(name = "dyn_img_Id")
    private Integer dynImgId;

    /**
     * 动态详情表id
     */
    @Column(name = "dyn_id")
    private Integer dynId;

    /**
     * 图片路径
     */
    private String path;

    private static final long serialVersionUID = 1L;

    /**
     * 获取动态图片详情表id
     *
     * @return dyn_img_Id - 动态图片详情表id
     */
    public Integer getDynImgId() {
        return dynImgId;
    }

    /**
     * 设置动态图片详情表id
     *
     * @param dynImgId 动态图片详情表id
     */
    public void setDynImgId(Integer dynImgId) {
        this.dynImgId = dynImgId;
    }

    /**
     * 获取动态详情表id
     *
     * @return dyn_id - 动态详情表id
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
     * 获取图片路径
     *
     * @return path - 图片路径
     */
    public String getPath() {
        return path;
    }

    /**
     * 设置图片路径
     *
     * @param path 图片路径
     */
    public void setPath(String path) {
        this.path = path == null ? null : path.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", dynImgId=").append(dynImgId);
        sb.append(", dynId=").append(dynId);
        sb.append(", path=").append(path);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}