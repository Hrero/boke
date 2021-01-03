package com.eleven.boke.pojo.Do;

import java.util.Date;

/**
 * @author : eleven
 * @description: TODO
 * @date : 2020/12/29 14:52
 */
public class BokeCommentListDo {
    private Long id;

    /**
     * @author: eleven
     * @description: 评论人id
     */
    private Long userid;
    /**
     * @author: eleven
     * @description: 文章id
     */
    private Long articleId;

    /**
     * @author: eleven
     * @description: 父评论id
     */
    private Long parentCommentId;

    /**
     * @author: eleven
     * @description: 父评论的userid
     */
    private Long parentCommentUserId;

    /**
     * @author: eleven
     * @description: 被回复的id
     */
    private Long replyCommentId;

    /**
     * @author: eleven
     * @description: 被回复的用户id
     */
    private Long replyCommentUserId;

    /**
     * @author: eleven
     * @description: 几级评论 1, 2
     */
    private Integer commentLevel;

    /**
     * @author: eleven
     * @description: 内容
     */
    private String content;

    /**
     * @author: eleven
     * @description: 状态 (1 有效，0 逻辑删除)
     */
    private Integer status;

    /**
     * @author: eleven
     * @description: 置顶状态[ 1 置顶，0 不置顶 默认 ]
     */
    private Integer topStatus;

    private Date gmtCreated;
    private Date gmtModified;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public Long getArticleId() {
        return articleId;
    }

    public void setArticleId(Long articleId) {
        this.articleId = articleId;
    }

    public Long getParentCommentId() {
        return parentCommentId;
    }

    public void setParentCommentId(Long parentCommentId) {
        this.parentCommentId = parentCommentId;
    }

    public Long getParentCommentUserId() {
        return parentCommentUserId;
    }

    public void setParentCommentUserId(Long parentCommentUserId) {
        this.parentCommentUserId = parentCommentUserId;
    }

    public Long getReplyCommentId() {
        return replyCommentId;
    }

    public void setReplyCommentId(Long replyCommentId) {
        this.replyCommentId = replyCommentId;
    }

    public Long getReplyCommentUserId() {
        return replyCommentUserId;
    }

    public void setReplyCommentUserId(Long replyCommentUserId) {
        this.replyCommentUserId = replyCommentUserId;
    }

    public Integer getCommentLevel() {
        return commentLevel;
    }

    public void setCommentLevel(Integer commentLevel) {
        this.commentLevel = commentLevel;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getTopStatus() {
        return topStatus;
    }

    public void setTopStatus(Integer topStatus) {
        this.topStatus = topStatus;
    }

    public Date getGmtCreated() {
        return gmtCreated;
    }

    public void setGmtCreated(Date gmtCreated) {
        this.gmtCreated = gmtCreated;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

}
