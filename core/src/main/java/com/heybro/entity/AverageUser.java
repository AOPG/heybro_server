package com.heybro.entity;

import java.io.Serializable;
import javax.persistence.*;

@Table(name = "average_user")
public class AverageUser implements Serializable {
    /**
     * 普通用户id
     */
    @Id
    @Column(name = "user_id")
    private Integer userId;

    /**
     * 用户编码
     */
    @Column(name = "user_code")
    private String userCode;

    /**
     * 用户名（账号）
     */
    @Column(name = "user_name")
    private String userName;

    /**
     * 用户登录密码
     */
    @Column(name = "user_pass")
    private String userPass;

    /**
     * 性别
     */
    @Column(name = "user_sex")
    private String userSex;

    /**
     * 手机号
     */
    @Column(name = "user_phone")
    private String userPhone;

    /**
     * 邮箱
     */
    @Column(name = "user_mail")
    private String userMail;

    /**
     * 用户简介
     */
    @Column(name = "`user_ Intro`")
    private String userIntro;

    /**
     * 用户头像
     */
    @Column(name = "`user_ portrait`")
    private String userPortrait;

    /**
     * 个性签名
     */
    @Column(name = "`user_ signature`")
    private String userSignature;

    /**
     * 个人主页背景
     */
    @Column(name = "homepage_back")
    private String homepageBack;

    /**
     * 用户等级
     */
    @Column(name = "user_grade")
    private Integer userGrade;

    /**
     * 用户经度
     */
    @Column(name = "user_lng")
    private String userLng;

    /**
     * 用户维度
     */
    @Column(name = "user_lat")
    private String userLat;

    /**
     * 用户所在城市
     */
    @Column(name = "user_city")
    private String userCity;

    /**
     * 用户所在市
     */
    @Column(name = "user_province")
    private String userProvince;

    /**
     * 用户所在区
     */
    @Column(name = "user_area")
    private String userArea;

    private static final long serialVersionUID = 1L;

    /**
     * 获取普通用户id
     *
     * @return user_id - 普通用户id
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * 设置普通用户id
     *
     * @param userId 普通用户id
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
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
     * 获取用户名（账号）
     *
     * @return user_name - 用户名（账号）
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 设置用户名（账号）
     *
     * @param userName 用户名（账号）
     */
    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    /**
     * 获取用户登录密码
     *
     * @return user_pass - 用户登录密码
     */
    public String getUserPass() {
        return userPass;
    }

    /**
     * 设置用户登录密码
     *
     * @param userPass 用户登录密码
     */
    public void setUserPass(String userPass) {
        this.userPass = userPass == null ? null : userPass.trim();
    }

    /**
     * 获取性别
     *
     * @return user_sex - 性别
     */
    public String getUserSex() {
        return userSex;
    }

    /**
     * 设置性别
     *
     * @param userSex 性别
     */
    public void setUserSex(String userSex) {
        this.userSex = userSex == null ? null : userSex.trim();
    }

    /**
     * 获取手机号
     *
     * @return user_phone - 手机号
     */
    public String getUserPhone() {
        return userPhone;
    }

    /**
     * 设置手机号
     *
     * @param userPhone 手机号
     */
    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone == null ? null : userPhone.trim();
    }

    /**
     * 获取邮箱
     *
     * @return user_mail - 邮箱
     */
    public String getUserMail() {
        return userMail;
    }

    /**
     * 设置邮箱
     *
     * @param userMail 邮箱
     */
    public void setUserMail(String userMail) {
        this.userMail = userMail == null ? null : userMail.trim();
    }

    /**
     * 获取用户简介
     *
     * @return user_ Intro - 用户简介
     */
    public String getUserIntro() {
        return userIntro;
    }

    /**
     * 设置用户简介
     *
     * @param userIntro 用户简介
     */
    public void setUserIntro(String userIntro) {
        this.userIntro = userIntro == null ? null : userIntro.trim();
    }

    /**
     * 获取用户头像
     *
     * @return user_ portrait - 用户头像
     */
    public String getUserPortrait() {
        return userPortrait;
    }

    /**
     * 设置用户头像
     *
     * @param userPortrait 用户头像
     */
    public void setUserPortrait(String userPortrait) {
        this.userPortrait = userPortrait == null ? null : userPortrait.trim();
    }

    /**
     * 获取个性签名
     *
     * @return user_ signature - 个性签名
     */
    public String getUserSignature() {
        return userSignature;
    }

    /**
     * 设置个性签名
     *
     * @param userSignature 个性签名
     */
    public void setUserSignature(String userSignature) {
        this.userSignature = userSignature == null ? null : userSignature.trim();
    }

    /**
     * 获取个人主页背景
     *
     * @return homepage_back - 个人主页背景
     */
    public String getHomepageBack() {
        return homepageBack;
    }

    /**
     * 设置个人主页背景
     *
     * @param homepageBack 个人主页背景
     */
    public void setHomepageBack(String homepageBack) {
        this.homepageBack = homepageBack == null ? null : homepageBack.trim();
    }

    /**
     * 获取用户等级
     *
     * @return user_grade - 用户等级
     */
    public Integer getUserGrade() {
        return userGrade;
    }

    /**
     * 设置用户等级
     *
     * @param userGrade 用户等级
     */
    public void setUserGrade(Integer userGrade) {
        this.userGrade = userGrade;
    }

    /**
     * 获取用户经度
     *
     * @return user_lng - 用户经度
     */
    public String getUserLng() {
        return userLng;
    }

    /**
     * 设置用户经度
     *
     * @param userLng 用户经度
     */
    public void setUserLng(String userLng) {
        this.userLng = userLng == null ? null : userLng.trim();
    }

    /**
     * 获取用户维度
     *
     * @return user_lat - 用户维度
     */
    public String getUserLat() {
        return userLat;
    }

    /**
     * 设置用户维度
     *
     * @param userLat 用户维度
     */
    public void setUserLat(String userLat) {
        this.userLat = userLat == null ? null : userLat.trim();
    }

    /**
     * 获取用户所在城市
     *
     * @return user_city - 用户所在城市
     */
    public String getUserCity() {
        return userCity;
    }

    /**
     * 设置用户所在城市
     *
     * @param userCity 用户所在城市
     */
    public void setUserCity(String userCity) {
        this.userCity = userCity == null ? null : userCity.trim();
    }

    /**
     * 获取用户所在市
     *
     * @return user_province - 用户所在市
     */
    public String getUserProvince() {
        return userProvince;
    }

    /**
     * 设置用户所在市
     *
     * @param userProvince 用户所在市
     */
    public void setUserProvince(String userProvince) {
        this.userProvince = userProvince == null ? null : userProvince.trim();
    }

    /**
     * 获取用户所在区
     *
     * @return user_area - 用户所在区
     */
    public String getUserArea() {
        return userArea;
    }

    /**
     * 设置用户所在区
     *
     * @param userArea 用户所在区
     */
    public void setUserArea(String userArea) {
        this.userArea = userArea == null ? null : userArea.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", userId=").append(userId);
        sb.append(", userCode=").append(userCode);
        sb.append(", userName=").append(userName);
        sb.append(", userPass=").append(userPass);
        sb.append(", userSex=").append(userSex);
        sb.append(", userPhone=").append(userPhone);
        sb.append(", userMail=").append(userMail);
        sb.append(", userIntro=").append(userIntro);
        sb.append(", userPortrait=").append(userPortrait);
        sb.append(", userSignature=").append(userSignature);
        sb.append(", homepageBack=").append(homepageBack);
        sb.append(", userGrade=").append(userGrade);
        sb.append(", userLng=").append(userLng);
        sb.append(", userLat=").append(userLat);
        sb.append(", userCity=").append(userCity);
        sb.append(", userProvince=").append(userProvince);
        sb.append(", userArea=").append(userArea);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}