package com.eleven.boke.pojo.Dto;

/**
 * @author : eleven
 * @description: TODO
 * @date : 2021/1/3 11:49
 */
public class ArticleHotDto {
    private Long id;
    private Long hot;
    private String title;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getHot() {
        return hot;
    }

    public void setHot(Long hot) {
        this.hot = hot;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
