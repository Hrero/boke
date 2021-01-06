package com.eleven.boke.service.impl;

import com.eleven.boke.base.PageResult;
import com.eleven.boke.base.ResultUtil;
import com.eleven.boke.controller.ArticleController;
import com.eleven.boke.enums.ArticleInfoEnum;
import com.eleven.boke.enums.ArticleSortEnum;
import com.eleven.boke.handle.BaseEnumTypeHandler;
import com.eleven.boke.mapper.BokeArticleInfoDoMapper;
import com.eleven.boke.mapper.BokeClassTreeDoMapper;
import com.eleven.boke.mapper.BokeSysViewDoMapper;
import com.eleven.boke.mapper.BokeThumbsListDoMapper;
import com.eleven.boke.pojo.Do.BokeArticleInfoDo;
import com.eleven.boke.pojo.Do.BokeClassTreeDo;
import com.eleven.boke.pojo.Do.BokeSysViewDo;
import com.eleven.boke.pojo.Do.BokeThumbsListDo;
import com.eleven.boke.pojo.Dto.ArticleHotDto;
import com.eleven.boke.pojo.vo.BokeClassTreeVo;
import com.eleven.boke.pojo.vo.GetArticleInfoVo;
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
import java.text.SimpleDateFormat;
import java.util.*;

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


    @Autowired
    private BokeSysViewDoMapper bokeSysViewDoMapper;


    @Autowired
    private BokeThumbsListDoMapper bokeThumbsListDoMapper;

    @Autowired
    private BokeClassTreeDoMapper bokeClassTreeDoMapper;

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
        if (articleVo.getTitle() == null || articleVo.getSummary() == null
        || articleVo.getIsTop() == null || articleVo.getSortId() == null) {
            return resultUtil.error(ArticleInfoEnum.ARTICLE_PARAMS_NULL);
        }
        BokeArticleInfoDo bokeArticleInfoDo = new BokeArticleInfoDo();
        bokeArticleInfoDo.setTitle(articleVo.getTitle());
        bokeArticleInfoDo.setSummary(articleVo.getSummary());
        bokeArticleInfoDo.setIsTop(articleVo.getIsTop());
        bokeArticleInfoDo.setPicture(articleVo.getPicture());

        ArticleSortEnum articleSortEnum = BaseEnumTypeHandler.getByCode(new Long(articleVo.getSortId()).intValue(), ArticleSortEnum.class);

        bokeArticleInfoDo.setSortId(articleVo.getSortId());
        bokeArticleInfoDo.setContent(articleVo.getContent());
        bokeArticleInfoDo.setHtml(articleVo.getHtml());
        bokeArticleInfoDo.setHeadDescription(articleVo.getHeadDescription());
        bokeArticleInfoDo.setHeadKeywords(articleVo.getHeadKeywords());
        bokeArticleInfoDo.setHeadTitle(articleVo.getHeadTitle());
        bokeArticleInfoDo.setAuthor(articleVo.getAuthor());


        bokeArticleInfoDo.setPicture(articleVo.getPicture());

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

        List<ArticleVo> articleVos = BeanUtils.copyCollection(articleList, ArticleVo.class);

        for (ArticleVo in:
             articleVos) {
            if (articleListQuery.getIp() != null) {
                List<BokeThumbsListDo> bokeThumbsListDos = bokeThumbsListDoMapper.selectIdArticleStatus(articleListQuery.getIp(), in.getId(), 1l);
                if (bokeThumbsListDos.size() > 0) {
                    in.setThumdsStatus(bokeThumbsListDos.get(0).getStatus());
                }
            }
            List<BokeThumbsListDo> thumbsListDoList = bokeThumbsListDoMapper.selectIdArticleList(in.getId(), 1l);
            in.setThumdsSum(new Long(thumbsListDoList.size()));

            List<BokeSysViewDo> bokeSysViewDos = bokeSysViewDoMapper.selectByArticleId(in.getId());
            String lookNum = Integer.toString(bokeSysViewDos.size());
            in.setLookNum(Long.parseLong(lookNum));
        }
        PageInfo page = new PageInfo(articleVos);
        return resultUtil.success(page);
    }

    public ResultEntity<ArticleVo>  getArticleInfo(GetArticleInfoVo getArticleInfoVo) {
        BokeArticleInfoDo bokeArticleInfoDo = bokeArticleInfoDoMapper.selectByPrimaryKey(getArticleInfoVo.getId());
        ArticleVo articleVo = new ArticleVo();
        if (bokeArticleInfoDo.getId() != null) {
            articleVo.setId(bokeArticleInfoDo.getId());
        }
        if (bokeArticleInfoDo.getContent() != null) {
            articleVo.setContent(bokeArticleInfoDo.getContent());
        }
        if (bokeArticleInfoDo.getGmtCreated() != null) {
            String authTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(bokeArticleInfoDo.getGmtCreated());
            articleVo.setGmt_created(authTime);
        }
        if (bokeArticleInfoDo.getTitle() != null) {
            articleVo.setTitle(bokeArticleInfoDo.getTitle());
        }
        if (bokeArticleInfoDo.getHtml() != null) {
            articleVo.setHtml(bokeArticleInfoDo.getHtml());
        }
        if (bokeArticleInfoDo.getPicture() != null) {
            articleVo.setPicture(bokeArticleInfoDo.getPicture());
        }
        if (bokeArticleInfoDo.getSortId() != null) {
            articleVo.setSortId(bokeArticleInfoDo.getSortId());
        }
        if (bokeArticleInfoDo.getSummary() != null) {
            articleVo.setSummary(bokeArticleInfoDo.getSummary());
        }

        if (bokeArticleInfoDo.getHeadTitle() != null) {
            articleVo.setHeadTitle(bokeArticleInfoDo.getHeadTitle());
        }
        if (bokeArticleInfoDo.getHeadDescription() != null) {
            articleVo.setHeadDescription(bokeArticleInfoDo.getHeadDescription());
        }
        if (bokeArticleInfoDo.getHeadKeywords() != null) {
            articleVo.setHeadKeywords(bokeArticleInfoDo.getHeadKeywords());
        }
        if (bokeArticleInfoDo.getAuthor() != null) {
            articleVo.setAuthor(bokeArticleInfoDo.getAuthor());
        }
        if (getArticleInfoVo.getIp() != null) {
            List<BokeThumbsListDo> bokeThumbsListDos = bokeThumbsListDoMapper.selectIdArticleStatus(getArticleInfoVo.getIp(), bokeArticleInfoDo.getId(), 1l);
            if (bokeThumbsListDos.size() > 0) {
                articleVo.setThumdsStatus(bokeThumbsListDos.get(0).getStatus());
            }
        }
        List<BokeThumbsListDo> bokeThumbsListDos = bokeThumbsListDoMapper.selectIdArticleList(bokeArticleInfoDo.getId(), 1l);
        articleVo.setThumdsSum(new Long(bokeThumbsListDos.size()));

        List<BokeSysViewDo> bokeSysViewDos = bokeSysViewDoMapper.selectByArticleId(getArticleInfoVo.getId());
        String lookNum = Integer.toString(bokeSysViewDos.size());
        articleVo.setLookNum(Long.parseLong(lookNum));
        return resultUtil.success(articleVo);
    }

    public ResultEntity<BokeClassTreeVo> getClassList() {
        List<BokeClassTreeDo> bokeClassTreeDos = bokeClassTreeDoMapper.selectMenuList();
        List<BokeClassTreeVo> BokeClassTreeVos = BeanUtils.copyCollection(bokeClassTreeDos, BokeClassTreeVo.class);
        for (BokeClassTreeVo in:
                BokeClassTreeVos) {
            List<BokeClassTreeDo> bokeClassTreeDos1 = bokeClassTreeDoMapper.selectByPidId(in.getId());
            List<BokeClassTreeVo> BokeClassTreeVos1 = BeanUtils.copyCollection(bokeClassTreeDos1, BokeClassTreeVo.class);

            if (BokeClassTreeVos1.size() > 0) {
                in.setIsLeaf(false);
                in.setChildren(BokeClassTreeVos1);
                getClassChild(BokeClassTreeVos1);
            } else {
                in.setIsLeaf(true);
            }
            in.setLabel(in.getName());
            in.setValue(in.getId());
        }
        return resultUtil.success(BokeClassTreeVos);
    };
    public void getClassChild(List<BokeClassTreeVo> list) {
        for (BokeClassTreeVo in:
                list) {
            List<BokeClassTreeDo> bokeClassTreeDos1 = bokeClassTreeDoMapper.selectPathList(DEFAULT_DEPT_PATH_SPLIT + in.getId());
            List<BokeClassTreeVo> BokeClassTreeVos1 = BeanUtils.copyCollection(bokeClassTreeDos1, BokeClassTreeVo.class);

            if (BokeClassTreeVos1.size() > 0) {
                in.setChildren(BokeClassTreeVos1);
                getClassChild(BokeClassTreeVos1);
                in.setIsLeaf(false);
            } else {
                in.setIsLeaf(true);
            }
            in.setLabel(in.getName());
            in.setValue(in.getId());
        }
    }

    public ResultEntity<ArticleVo> getHotArticle() {
        List<ArticleHotDto> articleHotDto = bokeArticleInfoDoMapper.selectHotArticle();
        if (articleHotDto.size() > 0) {
            return resultUtil.success(articleHotDto);
        } else {
            return resultUtil.success(new ArrayList<>());
        }

    }
}
