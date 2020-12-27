package com.eleven.boke.service;

import com.eleven.boke.pojo.Do.BokeArticleMessageDo;
import com.eleven.boke.pojo.entity.ResultEntity;
import com.eleven.boke.pojo.query.AddMessageQuery;
import com.eleven.boke.pojo.query.BokeThumbsQuery;
import com.eleven.boke.pojo.vo.BokeThumbsVo;
import org.springframework.stereotype.Service;

public interface BokeThumbsService {
    ResultEntity<BokeThumbsVo> addThumbsArticle(BokeThumbsQuery bokeThumbsQuery);
}




