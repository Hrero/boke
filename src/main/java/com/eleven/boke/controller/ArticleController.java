package com.eleven.boke.controller;

import com.eleven.boke.base.PageResult;
import com.eleven.boke.pojo.entity.ResultEntity;
import com.eleven.boke.pojo.query.ArticleListQuery;
import com.eleven.boke.pojo.query.BokeThumbsQuery;
import com.eleven.boke.pojo.vo.BokeThumbsVo;
import com.eleven.boke.pojo.vo.GetArticleInfoVo;
import com.eleven.boke.pojo.vo.ArticleVo;
import com.eleven.boke.pojo.vo.UserArticleThumbsVo;
import com.eleven.boke.service.ArticleService;
import com.eleven.boke.service.BokeThumbsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/article")
public class ArticleController {

    private final static Logger logger = LoggerFactory.getLogger(ArticleController.class);


    @Value("${spring.profiles.active}")
    private String env;

    @Value("${spring.datasource.url}")
    private String url;


    @Autowired
    private ArticleService articleService;

    @Autowired
    private BokeThumbsService bokeThumbsService;

    @PostMapping(value = "/addOrUpdate")
    public ResultEntity<ArticleVo> getUserByName(@RequestBody ArticleVo articleVo) {
        return articleService.addOrUpdate(articleVo);
    }

    @PostMapping(value = "/getArticleInfo")
    public ResultEntity<ArticleVo> getArticleInfo(@RequestBody GetArticleInfoVo getArticleInfoVo) {
        return articleService.getArticleInfo(getArticleInfoVo);
    }

    @PostMapping(value = "/getArticleList")
    public ResultEntity<PageResult<ArticleVo>> getArticleList(@RequestBody ArticleListQuery articleListQuery) {
        System.out.println(env);
        System.out.println(url);
        return articleService.getArticleList(articleListQuery);
    }

    @PostMapping(value = "/addThumbsArticle")
    public ResultEntity<BokeThumbsVo> addThumbsArticle(@RequestBody BokeThumbsQuery bokeThumbsQuery) {
        return bokeThumbsService.addThumbsArticle(bokeThumbsQuery);
    }

    @PostMapping(value = "/getHotArticle")
    public ResultEntity<ArticleVo> getHotArticle() {
        return articleService.getHotArticle();
    }

    @PostMapping(value = "/getUserArticeleThumbs")
    public ResultEntity<List<UserArticleThumbsVo>> getUserArticeleThumbs(@RequestBody BokeThumbsQuery bokeThumbsQuery) {
        return bokeThumbsService.getUserArticeleThumbs(bokeThumbsQuery);
    }

}

