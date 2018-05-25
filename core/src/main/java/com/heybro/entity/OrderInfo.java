package com.heybro.entity;

import java.io.Serializable;
import javax.persistence.*;

@Table(name = "order_info")
public class OrderInfo implements Serializable {
    /**
     * 订单详情表id
     */
    @Id
    @Column(name = "order_info_id")
    private Integer orderInfoId;

    /**
     * 订单表id
     */
    @Column(name = "order_id")
    private Integer orderId;

    /**
     * 商品编码
     */
    @Column(name = "goods_code")
    private String goodsCode;

    /**
     * 商品数量
     */
    private Integer number;

    /**
     * 商品总价
     */
    private Double amount;

    private static final long serialVersionUID = 1L;

    /**
     * 获取订单详情表id
     *
     * @return order_info_id - 订单详情表id
     */
    public Integer getOrderInfoId() {
        return orderInfoId;
    }

    /**
     * 设置订单详情表id
     *
     * @param orderInfoId 订单详情表id
     */
    public void setOrderInfoId(Integer orderInfoId) {
        this.orderInfoId = orderInfoId;
    }

    /**
     * 获取订单表id
     *
     * @return order_id - 订单表id
     */
    public Integer getOrderId() {
        return orderId;
    }

    /**
     * 设置订单表id
     *
     * @param orderId 订单表id
     */
    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
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
     * 获取商品数量
     *
     * @return number - 商品数量
     */
    public Integer getNumber() {
        return number;
    }

    /**
     * 设置商品数量
     *
     * @param number 商品数量
     */
    public void setNumber(Integer number) {
        this.number = number;
    }

    /**
     * 获取商品总价
     *
     * @return amount - 商品总价
     */
    public Double getAmount() {
        return amount;
    }

    /**
     * 设置商品总价
     *
     * @param amount 商品总价
     */
    public void setAmount(Double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", orderInfoId=").append(orderInfoId);
        sb.append(", orderId=").append(orderId);
        sb.append(", goodsCode=").append(goodsCode);
        sb.append(", number=").append(number);
        sb.append(", amount=").append(amount);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}