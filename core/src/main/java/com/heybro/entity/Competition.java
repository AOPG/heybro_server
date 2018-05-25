package com.heybro.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

public class Competition implements Serializable {
    /**
     * 篮球赛事表id
     */
    @Id
    @Column(name = "comp_Id")
    private Integer compId;

    /**
     * 赛事名称
     */
    @Column(name = "comp_name")
    private String compName;

    /**
     * 获胜队伍
     */
    @Column(name = "win_team")
    private String winTeam;

    /**
     * 赛事日期
     */
    @Column(name = "comp_date")
    private Date compDate;

    /**
     * 赛事备注
     */
    @Column(name = "comp_remark")
    private String compRemark;

    private static final long serialVersionUID = 1L;

    /**
     * 获取篮球赛事表id
     *
     * @return comp_Id - 篮球赛事表id
     */
    public Integer getCompId() {
        return compId;
    }

    /**
     * 设置篮球赛事表id
     *
     * @param compId 篮球赛事表id
     */
    public void setCompId(Integer compId) {
        this.compId = compId;
    }

    /**
     * 获取赛事名称
     *
     * @return comp_name - 赛事名称
     */
    public String getCompName() {
        return compName;
    }

    /**
     * 设置赛事名称
     *
     * @param compName 赛事名称
     */
    public void setCompName(String compName) {
        this.compName = compName == null ? null : compName.trim();
    }

    /**
     * 获取获胜队伍
     *
     * @return win_team - 获胜队伍
     */
    public String getWinTeam() {
        return winTeam;
    }

    /**
     * 设置获胜队伍
     *
     * @param winTeam 获胜队伍
     */
    public void setWinTeam(String winTeam) {
        this.winTeam = winTeam == null ? null : winTeam.trim();
    }

    /**
     * 获取赛事日期
     *
     * @return comp_date - 赛事日期
     */
    public Date getCompDate() {
        return compDate;
    }

    /**
     * 设置赛事日期
     *
     * @param compDate 赛事日期
     */
    public void setCompDate(Date compDate) {
        this.compDate = compDate;
    }

    /**
     * 获取赛事备注
     *
     * @return comp_remark - 赛事备注
     */
    public String getCompRemark() {
        return compRemark;
    }

    /**
     * 设置赛事备注
     *
     * @param compRemark 赛事备注
     */
    public void setCompRemark(String compRemark) {
        this.compRemark = compRemark == null ? null : compRemark.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", compId=").append(compId);
        sb.append(", compName=").append(compName);
        sb.append(", winTeam=").append(winTeam);
        sb.append(", compDate=").append(compDate);
        sb.append(", compRemark=").append(compRemark);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}