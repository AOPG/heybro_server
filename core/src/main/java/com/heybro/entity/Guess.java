package com.heybro.entity;

import java.io.Serializable;
import javax.persistence.*;

public class Guess implements Serializable {
    /**
     * 竞猜表id
     */
    @Id
    @Column(name = "guess_Id")
    private Integer guessId;

    /**
     * 赛事id
     */
    @Column(name = "comp_id")
    private Integer compId;

    /**
     * 用户编码
     */
    @Column(name = "user_code")
    private String userCode;

    /**
     * 竞猜内容
     */
    @Column(name = "guess_info")
    private String guessInfo;

    /**
     * 竞猜结果(对1，错0)
     */
    private Integer result;

    /**
     * 奖品（球币数）
     */
    private Integer prize;

    private static final long serialVersionUID = 1L;

    /**
     * 获取竞猜表id
     *
     * @return guess_Id - 竞猜表id
     */
    public Integer getGuessId() {
        return guessId;
    }

    /**
     * 设置竞猜表id
     *
     * @param guessId 竞猜表id
     */
    public void setGuessId(Integer guessId) {
        this.guessId = guessId;
    }

    /**
     * 获取赛事id
     *
     * @return comp_id - 赛事id
     */
    public Integer getCompId() {
        return compId;
    }

    /**
     * 设置赛事id
     *
     * @param compId 赛事id
     */
    public void setCompId(Integer compId) {
        this.compId = compId;
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
     * 获取竞猜内容
     *
     * @return guess_info - 竞猜内容
     */
    public String getGuessInfo() {
        return guessInfo;
    }

    /**
     * 设置竞猜内容
     *
     * @param guessInfo 竞猜内容
     */
    public void setGuessInfo(String guessInfo) {
        this.guessInfo = guessInfo == null ? null : guessInfo.trim();
    }

    /**
     * 获取竞猜结果(对1，错0)
     *
     * @return result - 竞猜结果(对1，错0)
     */
    public Integer getResult() {
        return result;
    }

    /**
     * 设置竞猜结果(对1，错0)
     *
     * @param result 竞猜结果(对1，错0)
     */
    public void setResult(Integer result) {
        this.result = result;
    }

    /**
     * 获取奖品（球币数）
     *
     * @return prize - 奖品（球币数）
     */
    public Integer getPrize() {
        return prize;
    }

    /**
     * 设置奖品（球币数）
     *
     * @param prize 奖品（球币数）
     */
    public void setPrize(Integer prize) {
        this.prize = prize;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", guessId=").append(guessId);
        sb.append(", compId=").append(compId);
        sb.append(", userCode=").append(userCode);
        sb.append(", guessInfo=").append(guessInfo);
        sb.append(", result=").append(result);
        sb.append(", prize=").append(prize);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}