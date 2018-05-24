package com.heybro.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

public class Massage implements Serializable {
    /**
     * 用户消息表id
     */
    @Id
    @Column(name = "msg_Id")
    private Integer msgId;

    /**
     * 接收方编码
     */
    @Column(name = "user_code")
    private String userCode;

    /**
     * 发送方编码
     */
    @Column(name = "send_user_code")
    private String sendUserCode;

    /**
     * 消息内容
     */
    private String content;

    /**
     * 发送时间
     */
    @Column(name = "msg_date")
    private Date msgDate;

    private static final long serialVersionUID = 1L;

    /**
     * 获取用户消息表id
     *
     * @return msg_Id - 用户消息表id
     */
    public Integer getMsgId() {
        return msgId;
    }

    /**
     * 设置用户消息表id
     *
     * @param msgId 用户消息表id
     */
    public void setMsgId(Integer msgId) {
        this.msgId = msgId;
    }

    /**
     * 获取接收方编码
     *
     * @return user_code - 接收方编码
     */
    public String getUserCode() {
        return userCode;
    }

    /**
     * 设置接收方编码
     *
     * @param userCode 接收方编码
     */
    public void setUserCode(String userCode) {
        this.userCode = userCode == null ? null : userCode.trim();
    }

    /**
     * 获取发送方编码
     *
     * @return send_user_code - 发送方编码
     */
    public String getSendUserCode() {
        return sendUserCode;
    }

    /**
     * 设置发送方编码
     *
     * @param sendUserCode 发送方编码
     */
    public void setSendUserCode(String sendUserCode) {
        this.sendUserCode = sendUserCode == null ? null : sendUserCode.trim();
    }

    /**
     * 获取消息内容
     *
     * @return content - 消息内容
     */
    public String getContent() {
        return content;
    }

    /**
     * 设置消息内容
     *
     * @param content 消息内容
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    /**
     * 获取发送时间
     *
     * @return msg_date - 发送时间
     */
    public Date getMsgDate() {
        return msgDate;
    }

    /**
     * 设置发送时间
     *
     * @param msgDate 发送时间
     */
    public void setMsgDate(Date msgDate) {
        this.msgDate = msgDate;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", msgId=").append(msgId);
        sb.append(", userCode=").append(userCode);
        sb.append(", sendUserCode=").append(sendUserCode);
        sb.append(", content=").append(content);
        sb.append(", msgDate=").append(msgDate);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}