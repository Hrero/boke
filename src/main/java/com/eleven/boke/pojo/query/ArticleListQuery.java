package com.eleven.boke.pojo.query;

import com.eleven.boke.base.PageQuery;
import com.eleven.boke.enums.ArticleSortEnum;

/**
 * @author : eleven
 * @description: TODO
 * @date : 2020/12/12 17:27
 */
public class ArticleListQuery extends PageQuery {

    private Integer sortId;

    private String ip;

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Integer getSortId() {
        return sortId;
    }

    public void setSortId(Integer sortId) {
        this.sortId = sortId;
    }
}
