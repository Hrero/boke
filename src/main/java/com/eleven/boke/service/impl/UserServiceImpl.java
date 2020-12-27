package com.eleven.boke.service.impl;

import com.eleven.boke.base.ResultUtil;
import com.eleven.boke.controller.ArticleController;
import com.eleven.boke.enums.ArticleInfoEnum;
import com.eleven.boke.enums.ArticleSortEnum;
import com.eleven.boke.mapper.BokeArticleInfoDoMapper;
import com.eleven.boke.mapper.BokeSysViewDoMapper;
import com.eleven.boke.pojo.Do.BokeArticleInfoDo;
import com.eleven.boke.pojo.Do.BokeSysViewDo;
import com.eleven.boke.pojo.entity.ResultEntity;
import com.eleven.boke.pojo.query.UserQuery;
import com.eleven.boke.pojo.query.UserViewQuery;
import com.eleven.boke.pojo.vo.UserViewListVo;
import com.eleven.boke.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author : eleven
 * @description: TODO
 * @date : 2020/12/12 00:08
 */
@Service
public class UserServiceImpl implements UserService {

    private final static Logger logger = LoggerFactory.getLogger(ArticleController.class);

    @Autowired
    private BokeSysViewDoMapper bokeSysViewDoMapper;

    @Autowired
    private BokeArticleInfoDoMapper bokeArticleInfoDoMapper;

    @Override
    public ResultEntity<BokeSysViewDo> addUserView(UserQuery userQuery) {
        BokeSysViewDo bokeSysViewDo = new BokeSysViewDo();
        bokeSysViewDo.setIp(userQuery.getIp());
        bokeSysViewDo.setArticleId(userQuery.getArticleId());
        BokeArticleInfoDo bokeArticleInfoDo = bokeArticleInfoDoMapper.selectByPrimaryKey(userQuery.getArticleId());
        bokeSysViewDo.setSortId(bokeArticleInfoDo.getSortId());

        List<BokeSysViewDo> isIn = bokeSysViewDoMapper.selectTimeReadyIn(userQuery.getIp(), userQuery.getArticleId());
        if (isIn.size() == 0) {
            bokeSysViewDoMapper.insert(bokeSysViewDo);
        }
        return ResultUtil.success(bokeSysViewDo);
    }

    @Override
    public ResultEntity<List<UserViewListVo>> getUserView(UserViewQuery userViewQuery) {
        List<BokeSysViewDo> bokeSysViewDos = bokeSysViewDoMapper.selectArticleLimit(userViewQuery.getArticleId(), userViewQuery.getSortId());
        List<UserViewListVo> userViewListVos = new ArrayList<>();
        for (BokeSysViewDo in:
        bokeSysViewDos) {
            UserViewListVo userViewListVo = new UserViewListVo();
            userViewListVo.setId(in.getId());
            userViewListVo.setIp(in.getIp());
            if (in.getSortId() != null) {
                userViewListVo.setSortId(in.getSortId().toString());
            }
            String time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(in.getGmtCreated());
            userViewListVo.setGmtCreated(time);
            userViewListVos.add(userViewListVo);
        }
        return ResultUtil.success(userViewListVos);
    }
}












