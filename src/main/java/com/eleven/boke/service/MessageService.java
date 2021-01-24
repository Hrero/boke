package com.eleven.boke.service;

import com.eleven.boke.pojo.Do.BokeArticleMessageDo;
import com.eleven.boke.pojo.Do.BokeCommentListDo;
import com.eleven.boke.pojo.entity.ResultEntity;
import com.eleven.boke.pojo.query.AddCommentListQuery;
import com.eleven.boke.pojo.query.AddMessageQuery;
import com.eleven.boke.pojo.query.GetBokeCommentListQuery;
import com.eleven.boke.pojo.query.GetQueryThumdsQuery;
import com.eleven.boke.pojo.vo.BokeCommentListVo;
import com.eleven.boke.pojo.vo.BokeCommentThumdsVo;

import java.util.List;

/**
 * @author : eleven
 * @description: TODO
 * @date : 2020/12/12 01:20
 */
public interface MessageService {
    ResultEntity<BokeArticleMessageDo> addMessage(AddMessageQuery addMessageQuery);

    ResultEntity<BokeArticleMessageDo> getMessageList();

    ResultEntity<BokeCommentListDo> addCommentList(AddCommentListQuery addCommentListQuery);

    ResultEntity<List<BokeCommentListVo>> getCommentList(GetBokeCommentListQuery getBokeCommentListQuery);

    ResultEntity<BokeCommentThumdsVo> getCommentThumds(GetQueryThumdsQuery getQueryThumdsQuery);
}
