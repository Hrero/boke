package com.eleven.boke.pojo.query;

import java.io.Serializable;

/**
 * @author : eleven
 * @description: TODO
 * @date : 2020/12/11 23:57
 */
public class UserQuery implements Serializable {
    /**
     * @author: eleven
     * @description: 用户ip唯一标识
     */
    private String ip;

    /**
     * @author: eleven
     * @description: 文章id
     */
    private Long articleId;


    private Long userid;


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

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }


}
