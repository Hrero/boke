package com.eleven.boke.service.impl;

import com.eleven.boke.base.PageResult;
import com.eleven.boke.base.ResultUtil;
import com.eleven.boke.controller.ArticleController;
import com.eleven.boke.enums.ArticleInfoEnum;
import com.eleven.boke.enums.ArticleSortEnum;
import com.eleven.boke.handle.BaseEnumTypeHandler;
import com.eleven.boke.mapper.BokeArticleInfoDoMapper;
import com.eleven.boke.pojo.Do.BokeArticleInfoDo;
import com.eleven.boke.util.BeanUtils;
import com.github.pagehelper.PageInfo;
import com.eleven.boke.pojo.entity.ResultEntity;
import com.eleven.boke.pojo.query.ArticleListQuery;
import com.eleven.boke.pojo.vo.ArticleVo;
import com.eleven.boke.service.ArticleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author : eleven
 * @description: 文章
 * @date : 2020/11/16 16:37
 */
@Service
public class ArticleServiceImpl implements ArticleService {
    private final static Logger logger = LoggerFactory.getLogger(ArticleController.class);

    @Autowired
    private BokeArticleInfoDoMapper bokeArticleInfoDoMapper;
    private ResultUtil resultUtil = new ResultUtil();

    /**
     * @author: eleven
     * @description: 增加或者更新
     * @date: 2020/11/16 17:06
     * @param articleVo
     * @return
     */

    @Transactional
    @Override
    public ResultEntity<ArticleVo> addOrUpdate(ArticleVo articleVo) {
        if (articleVo.getTitle() == null || articleVo.getContent() == null || articleVo.getSummary() == null
        || articleVo.getIsTop() == null || articleVo.getSortId() == null) {
            return resultUtil.error(ArticleInfoEnum.ARTICLE_PARAMS_NULL);
        }
        BokeArticleInfoDo bokeArticleInfoDo = new BokeArticleInfoDo();
        bokeArticleInfoDo.setTitle(articleVo.getTitle());
        bokeArticleInfoDo.setSummary(articleVo.getSummary());
        bokeArticleInfoDo.setIsTop(articleVo.getIsTop());
        bokeArticleInfoDo.setPicture(articleVo.getPicture());

        ArticleSortEnum articleSortEnum = BaseEnumTypeHandler.getByCode(new Long(articleVo.getSortId()).intValue(), ArticleSortEnum.class);

        bokeArticleInfoDo.setSortId(new BigDecimal(articleSortEnum.getCode()).longValue());
        bokeArticleInfoDo.setContent(articleVo.getContent());
        if (articleVo.getId() != null) {
            bokeArticleInfoDo.setId(articleVo.getId());
            bokeArticleInfoDoMapper.updateByPrimaryKey(bokeArticleInfoDo);
        } else {
            bokeArticleInfoDoMapper.insert(bokeArticleInfoDo);
        }
        return resultUtil.success(bokeArticleInfoDo);
    }

    /**
     * @author: eleven
     * @description: 分类
     */
    @Override
    public ResultEntity<ArticleSortEnum> getSortList() {
        List<Object> sortList = new ArrayList<>();
        for (ArticleSortEnum in: ArticleSortEnum.values()) {
            Map<String, Object> map = new HashMap<>();
            map.put("name", in.getMessage());
            map.put("value", in.getCode());
            sortList.add(map);
        }
        return resultUtil.success(sortList);
    }

    /**
     * @author: eleven
     * @description: 类表分页
     */
    @Override
    public ResultEntity<PageResult<ArticleVo>> getArticleList(ArticleListQuery articleListQuery) {

        List<BokeArticleInfoDo> articleList = bokeArticleInfoDoMapper.pageQuery(articleListQuery);
        PageInfo page = new PageInfo(articleList);
//        List<ArticleVo> customerVOS = BeanUtils.copyCollection(articleList, ArticleVo.class);
        return resultUtil.success(page);
    }
}
