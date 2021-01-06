package com.eleven.boke.service.impl;

import com.eleven.boke.base.ResultUtil;
import com.eleven.boke.controller.ArticleController;
import com.eleven.boke.enums.MessageEnum;
import com.eleven.boke.mapper.BokeArticleInfoDoMapper;
import com.eleven.boke.mapper.BokeArticleMessageDoMapper;
import com.eleven.boke.mapper.BokeCommentListDoMapper;
import com.eleven.boke.mapper.BokeUserInfoDoMapper;
import com.eleven.boke.pojo.Do.BokeArticleInfoDo;
import com.eleven.boke.pojo.Do.BokeArticleMessageDo;
import com.eleven.boke.pojo.Do.BokeCommentListDo;
import com.eleven.boke.pojo.Do.BokeUserInfoDo;
import com.eleven.boke.pojo.entity.ResultEntity;
import com.eleven.boke.pojo.query.AddCommentListQuery;
import com.eleven.boke.pojo.query.AddMessageQuery;
import com.eleven.boke.pojo.query.GetBokeCommentListQuery;
import com.eleven.boke.pojo.vo.ArticleVo;
import com.eleven.boke.pojo.vo.BokeCommentListVo;
import com.eleven.boke.pojo.vo.UserInfoVo;
import com.eleven.boke.service.MessageService;
import com.eleven.boke.util.BeanUtils;
import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIConversion;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author : eleven
 * @description: TODO
 * @date : 2020/12/12 01:22
 */
@Service
public class MessageServiceImpl implements MessageService {

    private final static Logger logger = LoggerFactory.getLogger(ArticleController.class);

    @Autowired
    private BokeArticleMessageDoMapper bokeArticleMessageDoMapper;

    @Autowired
    private BokeCommentListDoMapper bokeCommentListDoMapper;


    @Autowired
    private BokeArticleInfoDoMapper bokeArticleInfoDoMapper;

    @Autowired
    private BokeUserInfoDoMapper bokeUserInfoDoMapper;

    @Override
    public ResultEntity<BokeArticleMessageDo> addMessage(AddMessageQuery addMessageQuery) {
        if (addMessageQuery.getEmail() == null || addMessageQuery.getIp() == null
        || addMessageQuery.getName() == null) {
            ResultUtil.error(MessageEnum.MESSAGE_PARAMS_NULL);
        }
        BokeArticleMessageDo bokeArticleMessageDo = new BokeArticleMessageDo();
        bokeArticleMessageDo.setContent(addMessageQuery.getContent());
        bokeArticleMessageDo.setEmail(addMessageQuery.getEmail());
        bokeArticleMessageDo.setIp(addMessageQuery.getIp());
        bokeArticleMessageDo.setName(addMessageQuery.getName());
        bokeArticleMessageDo.setIsEffective(new BigDecimal(MessageEnum.MESSAGE_IS_EFFECTIVE.getCode()).longValue());
        bokeArticleMessageDoMapper.insert(bokeArticleMessageDo);

        UserInfoVo userInfoVo = new UserInfoVo();


        List<BokeUserInfoDo> bokeUserInfoDos = bokeUserInfoDoMapper.selectIdAgent(addMessageQuery.getIp(), addMessageQuery.getAgent());
        if (bokeUserInfoDos.size() == 0) {
            userInfoVo.setHeadPicture(addMessageQuery.getHeadPicture());
            userInfoVo.setAgent(addMessageQuery.getAgent());
            userInfoVo.setNickname(addMessageQuery.getName());
            userInfoVo.setEmail(addMessageQuery.getEmail());
            userInfoVo.setIp(addMessageQuery.getIp());

            bokeUserInfoDoMapper.insert(userInfoVo);
        }

        return ResultUtil.success(bokeArticleMessageDo);
    }

    @Override
    public ResultEntity<BokeArticleMessageDo> getMessageList() {
        List<Object> messageList = new ArrayList<>();
        for (BokeArticleMessageDo in:
        bokeArticleMessageDoMapper.selectAll()) {

            String authTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(in.getGmtCreated());
            in.setCreateTime(authTime);
            messageList.add(in);
        };
        return ResultUtil.success(messageList);
    }

    @Override
    public ResultEntity<BokeCommentListDo> addCommentList(AddCommentListQuery addCommentListQuery) {
        if (addCommentListQuery.getArticleId() == null || addCommentListQuery.getUserid() == null || addCommentListQuery.getContent() == null) {
            ResultUtil.error(MessageEnum.MESSAGE_PARAMS_NULL);
        }
        BokeCommentListDo bokeCommentListDo = new BokeCommentListDo();
        if (addCommentListQuery.getArticleId() != null) {
            bokeCommentListDo.setArticleId(addCommentListQuery.getArticleId());
        }
        if (addCommentListQuery.getCommentLevel() != null) {
            bokeCommentListDo.setCommentLevel(addCommentListQuery.getCommentLevel());
        }
        if (addCommentListQuery.getContent() != null) {
            bokeCommentListDo.setContent(addCommentListQuery.getContent());
        }
        if (addCommentListQuery.getParentCommentId() != null) {
            bokeCommentListDo.setParentCommentId(addCommentListQuery.getParentCommentId());
        }
        if (addCommentListQuery.getParentCommentUserId() != null) {
            bokeCommentListDo.setParentCommentUserId(addCommentListQuery.getParentCommentUserId());
        }
        if (addCommentListQuery.getReplyCommentId() != null) {
            bokeCommentListDo.setReplyCommentId(addCommentListQuery.getReplyCommentId());
        }
        if (addCommentListQuery.getReplyCommentUserId() != null) {
            bokeCommentListDo.setReplyCommentUserId(addCommentListQuery.getReplyCommentUserId());
        }
        if (addCommentListQuery.getUserid() != null) {
            bokeCommentListDo.setUserid(addCommentListQuery.getUserid());
        }
        bokeCommentListDoMapper.insert(bokeCommentListDo);
        return ResultUtil.success(bokeCommentListDo);
    }


    @Override
    public ResultEntity<List<BokeCommentListVo>> getCommentList(GetBokeCommentListQuery getBokeCommentListQuery) {

        List<BokeCommentListDo> bokeCommentListDos = bokeCommentListDoMapper.selectParentbyArticleId(getBokeCommentListQuery.getArticleId());
        List<BokeCommentListVo> bokeCommentListVos = BeanUtils.copyCollection(bokeCommentListDos, BokeCommentListVo.class);
        if (bokeCommentListVos.size() > 0) {
            for (BokeCommentListVo in:
                    bokeCommentListVos) {

                BokeUserInfoDo bokeUserInfoDo = bokeUserInfoDoMapper.selectById(in.getUserid());
                if (bokeUserInfoDo != null) {
                    in.setUserInfo(bokeUserInfoDo);
                } else {
                    in.setChild(new ArrayList<>());
                    continue;
                }
                BokeArticleInfoDo bokeArticleInfoDo = bokeArticleInfoDoMapper.selectByPrimaryKey(getBokeCommentListQuery.getArticleId());
                if (bokeArticleInfoDo.getAuthor().equals(in.getUserInfo().getNickname())) {
                    in.setIsAuthor(1);
                } else {
                    in.setIsAuthor(0);
                }

                String time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(in.getGmtCreated());
                in.setCreateDate(time);

                List<BokeCommentListDo> bokeCoLiDos = bokeCommentListDoMapper.selectNomalListbyArticleId(getBokeCommentListQuery.getArticleId(), in.getId());
                List<BokeCommentListVo> bokeCoLiVos = BeanUtils.copyCollection(bokeCoLiDos, BokeCommentListVo.class);
                for (BokeCommentListVo at:
                bokeCoLiVos) {
                    BokeUserInfoDo bokeUsInDo = bokeUserInfoDoMapper.selectById(at.getUserid());
                    if (bokeUsInDo != null) {
                        at.setUserInfo(bokeUsInDo);
                    }

                    BokeUserInfoDo bokeParsInDo = bokeUserInfoDoMapper.selectById(at.getParentCommentUserId());
                    if (bokeParsInDo != null) {
                        at.setParentCommentNickName(bokeParsInDo.getNickname());
                    }

                    BokeArticleInfoDo bokeArtInDo = bokeArticleInfoDoMapper.selectByPrimaryKey(getBokeCommentListQuery.getArticleId());
                    if (at.getUserInfo().getNickname().equals(bokeArtInDo.getAuthor())) {
                        at.setIsAuthor(1);
                    } else {
                        at.setIsAuthor(0);
                    }

                    BokeUserInfoDo bokeReplyUserInDo = bokeUserInfoDoMapper.selectById(at.getReplyCommentUserId());
                    if (bokeReplyUserInDo != null) {
                        at.setReplyCommentNickName(bokeReplyUserInDo.getNickname());
                    }

                    String date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(at.getGmtCreated());
                    at.setCreateDate(date);
                }
                if (bokeCoLiVos.size() > 0) {
                    in.setChild(bokeCoLiVos);
                } else {
                    in.setChild(new ArrayList<>());
                }

            }
        }

        return ResultUtil.success(bokeCommentListVos);
    }
}
