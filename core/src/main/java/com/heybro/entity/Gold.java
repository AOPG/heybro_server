package com.heybro.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

public class Gold implements Serializable {
    /**
     * 金币兑换表id
     */
    @Id
    @Column(name = "gold_id")
    private Integer goldId;

    /**
     * 金币数量
     */
    private Integer amount;

    /**
     * 折扣
     */
    private Double discount;

    /**
     * 兑换日期
     */
    private Date date;

    private static final long serialVersionUID = 1L;

    /**
     * 获取金币兑换表id
     *
     * @return gold_id - 金币兑换表id
     */
    public Integer getGoldId() {
        return goldId;
    }

    /**
     * 设置金币兑换表id
     *
     * @param goldId 金币兑换表id
     */
    public void setGoldId(Integer goldId) {
        this.goldId = goldId;
    }

    /**
     * 获取金币数量
     *
     * @return amount - 金币数量
     */
    public Integer getAmount() {
        return amount;
    }

    /**
     * 设置金币数量
     *
     * @param amount 金币数量
     */
    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    /**
     * 获取折扣
     *
     * @return discount - 折扣
     */
    public Double getDiscount() {
        return discount;
    }

    /**
     * 设置折扣
     *
     * @param discount 折扣
     */
    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    /**
     * 获取兑换日期
     *
     * @return date - 兑换日期
     */
    public Date getDate() {
        return date;
    }

    /**
     * 设置兑换日期
     *
     * @param date 兑换日期
     */
    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", goldId=").append(goldId);
        sb.append(", amount=").append(amount);
        sb.append(", discount=").append(discount);
        sb.append(", date=").append(date);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}