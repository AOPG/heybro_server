package com.heybro.entity;

import java.io.Serializable;
import javax.persistence.*;

public class Goods implements Serializable {
    /**
     * 商品表id
     */
    @Id
    @Column(name = "goods_id")
    private Integer goodsId;

    /**
     * 商品编码
     */
    @Column(name = "goods_code")
    private String goodsCode;

    /**
     * 商品名称
     */
    @Column(name = "goods_name")
    private String goodsName;

    private static final long serialVersionUID = 1L;

    /**
     * 获取商品表id
     *
     * @return goods_id - 商品表id
     */
    public Integer getGoodsId() {
        return goodsId;
    }

    /**
     * 设置商品表id
     *
     * @param goodsId 商品表id
     */
    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
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
     * 获取商品名称
     *
     * @return goods_name - 商品名称
     */
    public String getGoodsName() {
        return goodsName;
    }

    /**
     * 设置商品名称
     *
     * @param goodsName 商品名称
     */
    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName == null ? null : goodsName.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", goodsId=").append(goodsId);
        sb.append(", goodsCode=").append(goodsCode);
        sb.append(", goodsName=").append(goodsName);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}