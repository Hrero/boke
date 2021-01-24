package com.eleven.boke.service.impl;

import com.eleven.boke.base.ResultUtil;
import com.eleven.boke.controller.ArticleController;
import com.eleven.boke.enums.ArticleInfoEnum;
import com.eleven.boke.enums.ArticleSortEnum;
import com.eleven.boke.enums.UserEnum;
import com.eleven.boke.mapper.BokeArticleInfoDoMapper;
import com.eleven.boke.mapper.BokeSysViewDoMapper;
import com.eleven.boke.mapper.BokeUserInfoDoMapper;
import com.eleven.boke.pojo.Do.BokeArticleInfoDo;
import com.eleven.boke.pojo.Do.BokeSysViewDo;
import com.eleven.boke.pojo.Do.BokeUserInfoDo;
import com.eleven.boke.pojo.entity.ResultEntity;
import com.eleven.boke.pojo.query.GetUserInfoQuery;
import com.eleven.boke.pojo.query.UserInfoQuery;
import com.eleven.boke.pojo.query.UserQuery;
import com.eleven.boke.pojo.query.UserViewQuery;
import com.eleven.boke.pojo.vo.BokeCommentListVo;
import com.eleven.boke.pojo.vo.UserInfoVo;
import com.eleven.boke.pojo.vo.UserViewListVo;
import com.eleven.boke.service.UserService;
import com.eleven.boke.util.BeanUtils;
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

    @Autowired
    private BokeUserInfoDoMapper bokeUserInfoDoMapper;

    @Autowired
    private UserService userService;

    @Override
    public ResultEntity<BokeSysViewDo> addUserView(UserQuery userQuery) {
        BokeSysViewDo bokeSysViewDo = new BokeSysViewDo();
        bokeSysViewDo.setUserid(userQuery.getUserid());
        bokeSysViewDo.setArticleId(userQuery.getArticleId());
        BokeArticleInfoDo bokeArticleInfoDo = bokeArticleInfoDoMapper.selectByPrimaryKey(userQuery.getArticleId());
        bokeSysViewDo.setSortId(bokeArticleInfoDo.getSortId());

        bokeSysViewDo.setUserid(userQuery.getUserid());

        List<BokeSysViewDo> isIn = bokeSysViewDoMapper.selectTimeReadyIn(userQuery.getUserid(), userQuery.getArticleId());
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
            if (in.getSortId() != null) {
                userViewListVo.setSortId(in.getSortId().toString());
            }
            String time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(in.getGmtCreated());
            userViewListVo.setGmtCreated(time);
            BokeUserInfoDo bokeUserInfoDo = new BokeUserInfoDo();
            if (in.getUserid() != null) {
                bokeUserInfoDo = bokeUserInfoDoMapper.selectById(in.getUserid());
            }

            if (bokeUserInfoDo != null) {
                userViewListVo.setNickname(bokeUserInfoDo.getNickname());
            }
            userViewListVos.add(userViewListVo);
        }
        return ResultUtil.success(userViewListVos);
    }

    @Override
    public ResultEntity<UserInfoVo> addUser(UserInfoQuery userInfoQuery) {
        if (userInfoQuery.getAgent() == null || userInfoQuery.getEmail() == null || userInfoQuery.getNickname() == null) {
            return ResultUtil.error(UserEnum.USER_NULL_INFO);
        }

        List<BokeUserInfoDo> bokeUserInfoDo = bokeUserInfoDoMapper.selectNickName(userInfoQuery.getNickname());
        if (bokeUserInfoDo.size() == 0) {
            UserInfoVo userInfoVo = new UserInfoVo();
            if (userInfoQuery.getAgent() != null) {
                userInfoVo.setAgent(userInfoQuery.getAgent());
            }
            if (userInfoQuery.getEmail() != null) {
                userInfoVo.setEmail(userInfoQuery.getEmail());
            }
            if (userInfoQuery.getNickname() != null) {
                userInfoVo.setNickname(userInfoQuery.getNickname());
            }
            if (userInfoQuery.getHeadPicture() != null) {
                userInfoVo.setHeadPicture(userInfoQuery.getHeadPicture());
            }
            if (userInfoQuery.getPhone() != null) {
                userInfoVo.setPhone(userInfoQuery.getPhone());
            }
            bokeUserInfoDoMapper.insert(userInfoVo);
            userInfoVo.setId(userInfoVo.getId());
            return ResultUtil.success(userInfoVo);
        } else {
            GetUserInfoQuery getUserInfoQuery = new GetUserInfoQuery();
            getUserInfoQuery.setNickname(userInfoQuery.getNickname());
            return userService.getUserInfo(getUserInfoQuery);
        }
    }

    @Override
    public ResultEntity<UserInfoVo> getUserInfo(GetUserInfoQuery getUserInfoQuery) {
        List<BokeUserInfoDo> bokeUserInfoDo = bokeUserInfoDoMapper.selectNickName(getUserInfoQuery.getNickname());
        if (bokeUserInfoDo.size() > 0) {
            UserInfoVo userInfoVo = new UserInfoVo();
            userInfoVo.setNickname(bokeUserInfoDo.get(0).getNickname());
            userInfoVo.setId(bokeUserInfoDo.get(0).getId());
            userInfoVo.setPhone(bokeUserInfoDo.get(0).getPhone());
            userInfoVo.setAgent(bokeUserInfoDo.get(0).getAgent());
            userInfoVo.setEmail(bokeUserInfoDo.get(0).getEmail());
            userInfoVo.setHeadPicture(bokeUserInfoDo.get(0).getHead_picture());
            return ResultUtil.success(userInfoVo);
        } else {
            UserInfoVo userInfoVo = new UserInfoVo();
            return ResultUtil.error(UserEnum.USER_NULL_INFO_VIEW);
        }
    }

}












