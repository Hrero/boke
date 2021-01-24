package com.eleven.boke.pojo.vo;

import lombok.Data;


@Data
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

    private int messageNum;

    /**
     * @author: eleven
     * @description: 点赞数量
     */
    private Long thumdsSum;

}
