package com.eleven.boke.service;

import com.eleven.boke.pojo.Do.BokeArticleMessageDo;
import com.eleven.boke.pojo.entity.ResultEntity;
import com.eleven.boke.pojo.query.AddMessageQuery;

/**
 * @author : eleven
 * @description: TODO
 * @date : 2020/12/12 01:20
 */
public interface MessageService {
    ResultEntity<BokeArticleMessageDo> addMessage(AddMessageQuery addMessageQuery);

    ResultEntity<BokeArticleMessageDo> getMessageList();
}
