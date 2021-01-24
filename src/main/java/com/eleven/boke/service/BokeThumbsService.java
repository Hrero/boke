package com.eleven.boke.service;

import com.eleven.boke.pojo.Do.BokeArticleMessageDo;
import com.eleven.boke.pojo.entity.ResultEntity;
import com.eleven.boke.pojo.query.AddMessageQuery;
import com.eleven.boke.pojo.query.BokeThumbsQuery;
import com.eleven.boke.pojo.vo.BokeThumbsVo;
import com.eleven.boke.pojo.vo.UserArticleThumbsVo;
import org.springframework.stereotype.Service;

import java.util.List;

public interface BokeThumbsService {
    ResultEntity<BokeThumbsVo> addThumbsArticle(BokeThumbsQuery bokeThumbsQuery);

    ResultEntity<List<UserArticleThumbsVo>> getUserArticeleThumbs(BokeThumbsQuery bokeThumbsQuery);
}




