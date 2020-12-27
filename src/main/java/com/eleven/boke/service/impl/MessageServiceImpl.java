package com.eleven.boke.service.impl;

import com.eleven.boke.base.ResultUtil;
import com.eleven.boke.controller.ArticleController;
import com.eleven.boke.enums.MessageEnum;
import com.eleven.boke.mapper.BokeArticleMessageDoMapper;
import com.eleven.boke.pojo.Do.BokeArticleMessageDo;
import com.eleven.boke.pojo.entity.ResultEntity;
import com.eleven.boke.pojo.query.AddMessageQuery;
import com.eleven.boke.service.MessageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
        return ResultUtil.success(bokeArticleMessageDo);
    }

    @Override
    public ResultEntity<BokeArticleMessageDo> getMessageList() {
        List<Object> messageList = new ArrayList<>();
        for (BokeArticleMessageDo in:
        bokeArticleMessageDoMapper.selectAll()) {
            messageList.add(in);
        };
        return ResultUtil.success(messageList);
    }

}
