package com.heybro.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

public class Order implements Serializable {
    /**
     * 订单id
     */
    @Id
    @Column(name = "order_id")
    private Integer orderId;

    /**
     * 用户编码
     */
    @Column(name = "user_code")
    private String userCode;

    /**
     * 下单日期
     */
    @Column(name = "order_date")
    private Date orderDate;

    /**
     * 支付情况(待支付0，已支付1)
     */
    private Integer pay;

    /**
     * 支付日期
     */
    @Column(name = "pay_date")
    private Date payDate;

    private static final long serialVersionUID = 1L;

    /**
     * 获取订单id
     *
     * @return order_id - 订单id
     */
    public Integer getOrderId() {
        return orderId;
    }

    /**
     * 设置订单id
     *
     * @param orderId 订单id
     */
    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    /**
     * 获取用户编码
     *
     * @return user_code - 用户编码
     */
    public String getUserCode() {
        return userCode;
    }

    /**
     * 设置用户编码
     *
     * @param userCode 用户编码
     */
    public void setUserCode(String userCode) {
        this.userCode = userCode == null ? null : userCode.trim();
    }

    /**
     * 获取下单日期
     *
     * @return order_date - 下单日期
     */
    public Date getOrderDate() {
        return orderDate;
    }

    /**
     * 设置下单日期
     *
     * @param orderDate 下单日期
     */
    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    /**
     * 获取支付情况(待支付0，已支付1)
     *
     * @return pay - 支付情况(待支付0，已支付1)
     */
    public Integer getPay() {
        return pay;
    }

    /**
     * 设置支付情况(待支付0，已支付1)
     *
     * @param pay 支付情况(待支付0，已支付1)
     */
    public void setPay(Integer pay) {
        this.pay = pay;
    }

    /**
     * 获取支付日期
     *
     * @return pay_date - 支付日期
     */
    public Date getPayDate() {
        return payDate;
    }

    /**
     * 设置支付日期
     *
     * @param payDate 支付日期
     */
    public void setPayDate(Date payDate) {
        this.payDate = payDate;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", orderId=").append(orderId);
        sb.append(", userCode=").append(userCode);
        sb.append(", orderDate=").append(orderDate);
        sb.append(", pay=").append(pay);
        sb.append(", payDate=").append(payDate);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}