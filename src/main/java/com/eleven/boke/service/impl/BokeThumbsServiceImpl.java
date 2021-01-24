package com.eleven.boke.service.impl;

import com.eleven.boke.base.PageResult;
import com.eleven.boke.base.ResultUtil;
import com.eleven.boke.mapper.BokeThumbsListDoMapper;
import com.eleven.boke.pojo.Do.BokeArticleMessageDo;
import com.eleven.boke.pojo.Do.BokeThumbsListDo;
import com.eleven.boke.pojo.Dto.ArticleUserThumdsDto;
import com.eleven.boke.pojo.entity.ResultEntity;
import com.eleven.boke.pojo.query.BokeThumbsQuery;
import com.eleven.boke.pojo.vo.BokeThumbsVo;
import com.eleven.boke.pojo.vo.UserArticleThumbsVo;
import com.eleven.boke.service.BokeThumbsService;
import com.eleven.boke.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author : eleven
 * @description: TODO
 * @date : 2020/12/27 13:47
 */
@Service
public class BokeThumbsServiceImpl implements BokeThumbsService {

    @Autowired
    BokeThumbsListDoMapper bokeThumbsListDoMapper;

    @Autowired
    MessageService messageService;


    @Override
    public ResultEntity<BokeThumbsVo> addThumbsArticle(BokeThumbsQuery bokeThumbsQuery) {
        BokeThumbsVo bokeThumbsVo = new BokeThumbsVo();

        bokeThumbsVo.setUserid(bokeThumbsQuery.getUserid());
        bokeThumbsVo.setStatus(bokeThumbsQuery.getStatus());
        bokeThumbsVo.setArticleId(bokeThumbsQuery.getArticleId());
        System.out.println();
        try {
            List<BokeThumbsListDo> bokeThumbsListDoList = bokeThumbsListDoMapper.selectIdArticleId(bokeThumbsQuery.getUserid(), bokeThumbsQuery.getArticleId());
            if (bokeThumbsListDoList.size() == 0) {
                bokeThumbsListDoMapper.insert(bokeThumbsVo);
            } else {
                bokeThumbsVo.setId(bokeThumbsListDoList.get(0).getId());
                bokeThumbsListDoMapper.updateByPrimaryKey(bokeThumbsVo);
            }
        } finally {
            return ResultUtil.success(bokeThumbsVo);
        }
    }

    @Override
    public ResultEntity<List<UserArticleThumbsVo>> getUserArticeleThumbs(BokeThumbsQuery bokeThumbsQuery) {


        List<ArticleUserThumdsDto> articleUserThumdsDtos = bokeThumbsListDoMapper.selectIdArticleUser(bokeThumbsQuery.getUserid());

        List<UserArticleThumbsVo> userArticleThumbsVos = new ArrayList<>();

        for (ArticleUserThumdsDto in:
                articleUserThumdsDtos) {

//            Map<String, Object> userArticleThumbsVo = new HashMap<>();
//            userArticleThumbsVo.put("articleId", in.getArticleId());
//            userArticleThumbsVo.put("thumdsStatus", in.getThumdsStatus());
            UserArticleThumbsVo userArticleThumbsVo = new UserArticleThumbsVo();
            userArticleThumbsVo.setArticleId(in.getArticleId());
            userArticleThumbsVo.setThumdsStatus(in.getThumdsStatus());

            userArticleThumbsVos.add(userArticleThumbsVo);

        }

//        messageService.getCommentThumds();

//        List<BokeThumbsListDo> bokeThumbsListDos = bokeThumbsListDoMapper.selectIdArticleId(getQueryThumdsQuery.getUserid(), getQueryThumdsQuery.getArticleId());


        return ResultUtil.success(userArticleThumbsVos);
    }
}
