package com.heybro.entity;

import java.io.Serializable;
import javax.persistence.*;

@Table(name = "car_info")
public class CarInfo implements Serializable {
    /**
     * 购物车详情表id
     */
    @Id
    @Column(name = "car_info_id")
    private Integer carInfoId;

    /**
     * 购物车表id
     */
    @Column(name = "car_id")
    private Integer carId;

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
     * 获取购物车详情表id
     *
     * @return car_info_id - 购物车详情表id
     */
    public Integer getCarInfoId() {
        return carInfoId;
    }

    /**
     * 设置购物车详情表id
     *
     * @param carInfoId 购物车详情表id
     */
    public void setCarInfoId(Integer carInfoId) {
        this.carInfoId = carInfoId;
    }

    /**
     * 获取购物车表id
     *
     * @return car_id - 购物车表id
     */
    public Integer getCarId() {
        return carId;
    }

    /**
     * 设置购物车表id
     *
     * @param carId 购物车表id
     */
    public void setCarId(Integer carId) {
        this.carId = carId;
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
        sb.append(", carInfoId=").append(carInfoId);
        sb.append(", carId=").append(carId);
        sb.append(", goodsCode=").append(goodsCode);
        sb.append(", number=").append(number);
        sb.append(", amount=").append(amount);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}