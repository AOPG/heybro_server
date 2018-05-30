package com.heybro.entity;

import java.io.Serializable;
import javax.persistence.*;

public class Comment implements Serializable {
    /**
     * 动态评论详情表id
     */
    @Id
    @Column(name = "comment_Id")
    private Integer commentId;

    /**
     * 动态详情表id
     */
    @Column(name = "dyn_id")
    private Integer dynId;

    /**
     * 点赞数
     */
    private Integer like;

    /**
     * 评论内容
     */
    private String content;

    private static final long serialVersionUID = 1L;

    /**
     * 获取动态评论详情表id
     *
     * @return comment_Id - 动态评论详情表id
     */
    public Integer getCommentId() {
        return commentId;
    }

    /**
     * 设置动态评论详情表id
     *
     * @param commentId 动态评论详情表id
     */
    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    /**
     * 获取动态详情表id
     *
     * @return dyn_id - 动态详情表id
     */
    public Integer getDynId() {
        return dynId;
    }

    /**
     * 设置动态详情表id
     *
     * @param dynId 动态详情表id
     */
    public void setDynId(Integer dynId) {
        this.dynId = dynId;
    }

    /**
     * 获取点赞数
     *
     * @return like - 点赞数
     */
    public Integer getLike() {
        return like;
    }

    /**
     * 设置点赞数
     *
     * @param like 点赞数
     */
    public void setLike(Integer like) {
        this.like = like;
    }

    /**
     * 获取评论内容
     *
     * @return content - 评论内容
     */
    public String getContent() {
        return content;
    }

    /**
     * 设置评论内容
     *
     * @param content 评论内容
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", commentId=").append(commentId);
        sb.append(", dynId=").append(dynId);
        sb.append(", like=").append(like);
        sb.append(", content=").append(content);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}