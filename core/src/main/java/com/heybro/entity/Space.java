package com.heybro.entity;

import java.io.Serializable;
import javax.persistence.*;

public class Space implements Serializable {
    /**
     * 场地表id
     */
    @Id
    @Column(name = "space_id")
    private Integer spaceId;

    /**
     * 场地编码
     */
    @Column(name = "space_code")
    private String spaceCode;

    /**
     * 场地名称
     */
    @Column(name = "space_name")
    private String spaceName;

    private static final long serialVersionUID = 1L;

    /**
     * 获取场地表id
     *
     * @return space_id - 场地表id
     */
    public Integer getSpaceId() {
        return spaceId;
    }

    /**
     * 设置场地表id
     *
     * @param spaceId 场地表id
     */
    public void setSpaceId(Integer spaceId) {
        this.spaceId = spaceId;
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
     * 获取场地名称
     *
     * @return space_name - 场地名称
     */
    public String getSpaceName() {
        return spaceName;
    }

    /**
     * 设置场地名称
     *
     * @param spaceName 场地名称
     */
    public void setSpaceName(String spaceName) {
        this.spaceName = spaceName == null ? null : spaceName.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", spaceId=").append(spaceId);
        sb.append(", spaceCode=").append(spaceCode);
        sb.append(", spaceName=").append(spaceName);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}