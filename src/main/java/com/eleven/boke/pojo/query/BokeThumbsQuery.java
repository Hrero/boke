package com.eleven.boke.pojo.query;

import java.io.Serializable;

/**
 * @author : eleven
 * @description: TODO
 * @date : 2020/12/27 13:44
 */
public class BokeThumbsQuery implements Serializable {
    private Long articleId;
    private Long userid;

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    /**
     * @author: eleven
     * @description: 1 点赞 0 取消点赞
     */
    private Long status;

    public Long getStatus() {
        return status;
    }

    public void setStatus(Long status) {
        this.status = status;
    }

    public Long getArticleId() {
        return articleId;
    }

    public void setArticleId(Long articleId) {
        this.articleId = articleId;
    }


}
