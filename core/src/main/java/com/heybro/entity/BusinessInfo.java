package com.heybro.entity;

import java.io.Serializable;
import javax.persistence.*;

@Table(name = "business_info")
public class BusinessInfo implements Serializable {
    /**
     * 商家信息表id
     */
    @Id
    @Column(name = "bus_info_id")
    private Integer busInfoId;

    /**
     * 商家编码
     */
    @Column(name = "bus_code")
    private String busCode;

    /**
     * 商品编码
     */
    @Column(name = "goods_code")
    private String goodsCode;

    /**
     * 销售数量
     */
    private Integer sell;

    /**
     * 好评数量
     */
    @Column(name = "high_option")
    private Integer highOption;

    private static final long serialVersionUID = 1L;

    /**
     * 获取商家信息表id
     *
     * @return bus_info_id - 商家信息表id
     */
    public Integer getBusInfoId() {
        return busInfoId;
    }

    /**
     * 设置商家信息表id
     *
     * @param busInfoId 商家信息表id
     */
    public void setBusInfoId(Integer busInfoId) {
        this.busInfoId = busInfoId;
    }

    /**
     * 获取商家编码
     *
     * @return bus_code - 商家编码
     */
    public String getBusCode() {
        return busCode;
    }

    /**
     * 设置商家编码
     *
     * @param busCode 商家编码
     */
    public void setBusCode(String busCode) {
        this.busCode = busCode == null ? null : busCode.trim();
    }

    /**
     * 获取商品编码
     *
     * @return goods_code - 商品编码
     */
    public String getGoodsCode() {
        return goodsCode;
    }

    /**
     * 设置商品编码
     *
     * @param goodsCode 商品编码
     */
    public void setGoodsCode(String goodsCode) {
        this.goodsCode = goodsCode == null ? null : goodsCode.trim();
    }

    /**
     * 获取销售数量
     *
     * @return sell - 销售数量
     */
    public Integer getSell() {
        return sell;
    }

    /**
     * 设置销售数量
     *
     * @param sell 销售数量
     */
    public void setSell(Integer sell) {
        this.sell = sell;
    }

    /**
     * 获取好评数量
     *
     * @return high_option - 好评数量
     */
    public Integer getHighOption() {
        return highOption;
    }

    /**
     * 设置好评数量
     *
     * @param highOption 好评数量
     */
    public void setHighOption(Integer highOption) {
        this.highOption = highOption;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", busInfoId=").append(busInfoId);
        sb.append(", busCode=").append(busCode);
        sb.append(", goodsCode=").append(goodsCode);
        sb.append(", sell=").append(sell);
        sb.append(", highOption=").append(highOption);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}