package com.eleven.boke.service.impl;

import com.eleven.boke.base.PageResult;
import com.eleven.boke.base.ResultUtil;
import com.eleven.boke.mapper.BokeThumbsListDoMapper;
import com.eleven.boke.pojo.Do.BokeArticleMessageDo;
import com.eleven.boke.pojo.Do.BokeThumbsListDo;
import com.eleven.boke.pojo.entity.ResultEntity;
import com.eleven.boke.pojo.query.BokeThumbsQuery;
import com.eleven.boke.pojo.vo.BokeThumbsVo;
import com.eleven.boke.service.BokeThumbsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author : eleven
 * @description: TODO
 * @date : 2020/12/27 13:47
 */
@Service
public class BokeThumbsServiceImpl implements BokeThumbsService {

    @Autowired
    BokeThumbsListDoMapper bokeThumbsListDoMapper;

    @Override
    public ResultEntity<BokeThumbsVo> addThumbsArticle(BokeThumbsQuery bokeThumbsQuery) {
        BokeThumbsVo bokeThumbsVo = new BokeThumbsVo();
        bokeThumbsVo.setIp(bokeThumbsQuery.getIp());
        bokeThumbsVo.setStatus(bokeThumbsQuery.getStatus());
        bokeThumbsVo.setArticleId(bokeThumbsQuery.getArticleId());

        try {
            List<BokeThumbsListDo> bokeThumbsListDoList = bokeThumbsListDoMapper.selectIdArticleId(bokeThumbsQuery.getIp(), bokeThumbsQuery.getArticleId());
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
}
