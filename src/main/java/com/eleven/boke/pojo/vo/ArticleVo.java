package com.eleven.boke.pojo.vo;

import java.util.Date;

public class ArticleVo {

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


    private String html;

    private String headTitle;
    private String headKeywords;

    /**
     * @author: eleven
     * @description: 头部描述
     */
    private String headDescription;

    /**
     * @author: eleven
     * @description: 创建者
     * @return
     */
    private String author;

    private Long lookNum;

    private String gmt_created;

    private Long thumdsStatus;


    private Long thumdsSum;

    public Long getThumdsSum() {
        return thumdsSum;
    }

    public void setThumdsSum(Long thumdsSum) {
        this.thumdsSum = thumdsSum;
    }

    public Long getThumdsStatus() {
        return thumdsStatus;
    }

    public void setThumdsStatus(Long thumdsStatus) {
        this.thumdsStatus = thumdsStatus;
    }

    public Long getLookNum() {
        return lookNum;
    }

    public void setLookNum(Long lookNum) {
        this.lookNum = lookNum;
    }


    public String getHeadTitle() {
        return headTitle;
    }

    public void setHeadTitle(String headTitle) {
        this.headTitle = headTitle;
    }

    public String getHeadKeywords() {
        return headKeywords;
    }

    public void setHeadKeywords(String headKeywords) {
        this.headKeywords = headKeywords;
    }

    public String getHeadDescription() {
        return headDescription;
    }

    public void setHeadDescription(String headDescription) {
        this.headDescription = headDescription;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGmt_created() {
        return gmt_created;
    }

    public void setGmt_created(String gmt_created) {
        this.gmt_created = gmt_created;
    }

    public String getHtml() {
        return html;
    }

    public void setHtml(String html) {
        this.html = html;
    }
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
