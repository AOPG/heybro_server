package com.heybro.entity;

import java.io.Serializable;
import javax.persistence.*;

@Table(name = "user_info")
public class UserInfo implements Serializable {
    /**
     * 用户详情id
     */
    @Id
    @Column(name = "user_info_Id")
    private Integer userInfoId;

    /**
     * 用户code
     */
    @Column(name = "user_code")
    private String userCode;

    /**
     * 用户昵称
     */
    @Column(name = "nick_name")
    private String nickName;

    /**
     * 用户球币
     */
    private Integer gold;

    /**
     * 总场次
     */
    @Column(name = "total_field")
    private Integer totalField;

    /**
     * 胜场
     */
    private Integer win;

    /**
     * 胜率
     */
    private Double winning;

    /**
     * 用户拥有房间id（无为0）
     */
    @Column(name = "room_id")
    private Integer roomId;

    /**
     * 擅长位置1
     */
    private String position1;

    /**
     * 擅长位置2
     */
    private String position2;

    /**
     * 用户地址
     */
    @Column(name = "user_address")
    private String userAddress;

    /**
     * 个人二维码
     */
    @Column(name = "qr_code")
    private String qrCode;

    private static final long serialVersionUID = 1L;

    /**
     * 获取用户详情id
     *
     * @return user_info_Id - 用户详情id
     */
    public Integer getUserInfoId() {
        return userInfoId;
    }

    /**
     * 设置用户详情id
     *
     * @param userInfoId 用户详情id
     */
    public void setUserInfoId(Integer userInfoId) {
        this.userInfoId = userInfoId;
    }

    /**
     * 获取用户code
     *
     * @return user_code - 用户code
     */
    public String getUserCode() {
        return userCode;
    }

    /**
     * 设置用户code
     *
     * @param userCode 用户code
     */
    public void setUserCode(String userCode) {
        this.userCode = userCode == null ? null : userCode.trim();
    }

    /**
     * 获取用户昵称
     *
     * @return nick_name - 用户昵称
     */
    public String getNickName() {
        return nickName;
    }

    /**
     * 设置用户昵称
     *
     * @param nickName 用户昵称
     */
    public void setNickName(String nickName) {
        this.nickName = nickName == null ? null : nickName.trim();
    }

    /**
     * 获取用户球币
     *
     * @return gold - 用户球币
     */
    public Integer getGold() {
        return gold;
    }

    /**
     * 设置用户球币
     *
     * @param gold 用户球币
     */
    public void setGold(Integer gold) {
        this.gold = gold;
    }

    /**
     * 获取总场次
     *
     * @return total_field - 总场次
     */
    public Integer getTotalField() {
        return totalField;
    }

    /**
     * 设置总场次
     *
     * @param totalField 总场次
     */
    public void setTotalField(Integer totalField) {
        this.totalField = totalField;
    }

    /**
     * 获取胜场
     *
     * @return win - 胜场
     */
    public Integer getWin() {
        return win;
    }

    /**
     * 设置胜场
     *
     * @param win 胜场
     */
    public void setWin(Integer win) {
        this.win = win;
    }

    /**
     * 获取胜率
     *
     * @return winning - 胜率
     */
    public Double getWinning() {
        return winning;
    }

    /**
     * 设置胜率
     *
     * @param winning 胜率
     */
    public void setWinning(Double winning) {
        this.winning = winning;
    }

    /**
     * 获取用户拥有房间id（无为0）
     *
     * @return room_id - 用户拥有房间id（无为0）
     */
    public Integer getRoomId() {
        return roomId;
    }

    /**
     * 设置用户拥有房间id（无为0）
     *
     * @param roomId 用户拥有房间id（无为0）
     */
    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }

    /**
     * 获取擅长位置1
     *
     * @return position1 - 擅长位置1
     */
    public String getPosition1() {
        return position1;
    }

    /**
     * 设置擅长位置1
     *
     * @param position1 擅长位置1
     */
    public void setPosition1(String position1) {
        this.position1 = position1 == null ? null : position1.trim();
    }

    /**
     * 获取擅长位置2
     *
     * @return position2 - 擅长位置2
     */
    public String getPosition2() {
        return position2;
    }

    /**
     * 设置擅长位置2
     *
     * @param position2 擅长位置2
     */
    public void setPosition2(String position2) {
        this.position2 = position2 == null ? null : position2.trim();
    }

    /**
     * 获取用户地址
     *
     * @return user_address - 用户地址
     */
    public String getUserAddress() {
        return userAddress;
    }

    /**
     * 设置用户地址
     *
     * @param userAddress 用户地址
     */
    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress == null ? null : userAddress.trim();
    }

    /**
     * 获取个人二维码
     *
     * @return qr_code - 个人二维码
     */
    public String getQrCode() {
        return qrCode;
    }

    /**
     * 设置个人二维码
     *
     * @param qrCode 个人二维码
     */
    public void setQrCode(String qrCode) {
        this.qrCode = qrCode == null ? null : qrCode.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", userInfoId=").append(userInfoId);
        sb.append(", userCode=").append(userCode);
        sb.append(", nickName=").append(nickName);
        sb.append(", gold=").append(gold);
        sb.append(", totalField=").append(totalField);
        sb.append(", win=").append(win);
        sb.append(", winning=").append(winning);
        sb.append(", roomId=").append(roomId);
        sb.append(", position1=").append(position1);
        sb.append(", position2=").append(position2);
        sb.append(", userAddress=").append(userAddress);
        sb.append(", qrCode=").append(qrCode);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}