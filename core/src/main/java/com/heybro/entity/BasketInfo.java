package com.heybro.entity;

import java.io.Serializable;
import javax.persistence.*;

@Table(name = "basket_info")
public class BasketInfo implements Serializable {
    /**
     * 篮球资讯表id
     */
    @Id
    @Column(name = "basket_info_Id")
    private Integer basketInfoId;

    /**
     * 资讯名称
     */
    @Column(name = "info_name")
    private String infoName;

    /**
     * 咨询详情
     */
    @Column(name = "info_content")
    private String infoContent;

    private static final long serialVersionUID = 1L;

    /**
     * 获取篮球资讯表id
     *
     * @return basket_info_Id - 篮球资讯表id
     */
    public Integer getBasketInfoId() {
        return basketInfoId;
    }

    /**
     * 设置篮球资讯表id
     *
     * @param basketInfoId 篮球资讯表id
     */
    public void setBasketInfoId(Integer basketInfoId) {
        this.basketInfoId = basketInfoId;
    }

    /**
     * 获取资讯名称
     *
     * @return info_name - 资讯名称
     */
    public String getInfoName() {
        return infoName;
    }

    /**
     * 设置资讯名称
     *
     * @param infoName 资讯名称
     */
    public void setInfoName(String infoName) {
        this.infoName = infoName == null ? null : infoName.trim();
    }

    /**
     * 获取咨询详情
     *
     * @return info_content - 咨询详情
     */
    public String getInfoContent() {
        return infoContent;
    }

    /**
     * 设置咨询详情
     *
     * @param infoContent 咨询详情
     */
    public void setInfoContent(String infoContent) {
        this.infoContent = infoContent == null ? null : infoContent.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", basketInfoId=").append(basketInfoId);
        sb.append(", infoName=").append(infoName);
        sb.append(", infoContent=").append(infoContent);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}