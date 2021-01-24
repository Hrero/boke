package com.eleven.boke.pojo.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * @author : eleven
 * @description: TODO
 * @date : 2020/12/27 13:42
 */
public class BokeThumbsVo implements Serializable {

    private Long id;
    private String ip;
    private Long status;
    private Long articleId;
    private Long userid;

    private Date gmtCreated;
    private Date gmtModified;

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public Long getStatus() {
        return status;
    }

    public void setStatus(Long status) {
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Long getArticleId() {
        return articleId;
    }

    public void setArticleId(Long articleId) {
        this.articleId = articleId;
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
