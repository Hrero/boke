package com.eleven.boke.service.impl;

import com.eleven.boke.base.ResultUtil;
import com.eleven.boke.controller.ArticleController;
import com.eleven.boke.enums.ArticleInfoEnum;
import com.eleven.boke.enums.ArticleSortEnum;
import com.eleven.boke.handle.BaseEnumTypeHandler;
import com.eleven.boke.mapper.BokeArticleInfoDoMapper;
import com.eleven.boke.pojo.Do.BokeArticleInfoDo;
import com.eleven.boke.pojo.entity.ResultEntity;
import com.eleven.boke.pojo.vo.AddOrUpdateVo;
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
     * @param addOrUpdateVo
     * @return
     */

    @Transactional
    @Override
    public ResultEntity<AddOrUpdateVo> addOrUpdate(AddOrUpdateVo addOrUpdateVo) {
        if (addOrUpdateVo.getTitle() == null || addOrUpdateVo.getContent() == null || addOrUpdateVo.getSummary() == null
        || addOrUpdateVo.getIsTop() == null || addOrUpdateVo.getSortId() == null) {
            return resultUtil.error(ArticleInfoEnum.ARTICLE_PARAMS_NULL);
        }
        BokeArticleInfoDo bokeArticleInfoDo = new BokeArticleInfoDo();
        bokeArticleInfoDo.setTitle(addOrUpdateVo.getTitle());
        bokeArticleInfoDo.setSummary(addOrUpdateVo.getSummary());
        bokeArticleInfoDo.setIsTop(addOrUpdateVo.getIsTop());
        bokeArticleInfoDo.setPicture(addOrUpdateVo.getPicture());

        ArticleSortEnum articleSortEnum = BaseEnumTypeHandler.getByCode(new Long(addOrUpdateVo.getSortId()).intValue(), ArticleSortEnum.class);

        bokeArticleInfoDo.setSortId(new BigDecimal(articleSortEnum.getCode()).longValue());
        bokeArticleInfoDo.setContent(addOrUpdateVo.getContent());
        if (addOrUpdateVo.getId() != null) {
            bokeArticleInfoDo.setId(addOrUpdateVo.getId());
            bokeArticleInfoDoMapper.updateByPrimaryKey(bokeArticleInfoDo);
        } else {
            bokeArticleInfoDoMapper.insert(bokeArticleInfoDo);
        }
        return resultUtil.success(bokeArticleInfoDo);
    }

    @Override
    public ResultEntity<ArticleSortEnum> getSortList() {
        List<Object> sortList = new ArrayList<>();
        for (ArticleSortEnum in: ArticleSortEnum.values()) {
            Map<String, Object> map = new HashMap<>();
            map.put("key", in.getMessage());
            map.put("value", in.getCode());
            sortList.add(map);
        }
        return resultUtil.success(sortList);
    }
}
