package com.eleven.boke.pojo.vo;

public class AddOrUpdateVo {

    private Long id;

    /**
     * 文章名
     */
    private String title;

    /**
     * 文章描述（默认100个汉字以内）
     */
    private String summary;

    /**
     * 置顶 （文章是否置顶，0为否，1为是）
     */
    private Long isTop;

    /**
     * 图片
     */
    private String picture;

    /**
     * 分类
     */
    private Long sortId;

    /**
     * 内容
     */
    private String content;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIsTop() {
        return isTop;
    }

    public void setIsTop(Long isTop) {
        this.isTop = isTop;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }


    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }
    public Long getSortId() {
        return sortId;
    }

    public void setSortId(Long sortId) {
        this.sortId = sortId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
