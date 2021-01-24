package com.eleven.boke.pojo.vo;

import java.io.Serializable;

/**
 * @author : eleven
 * @description: TODO
 * @date : 2020/12/23 21:21
 */
public class GetArticleInfoVo implements Serializable {
    private Long id;

    private Long userid;

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
