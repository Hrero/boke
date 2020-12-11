package com.eleven.boke.service;

import com.eleven.boke.enums.ArticleSortEnum;
import com.eleven.boke.pojo.entity.ResultEntity;
import com.eleven.boke.pojo.vo.AddOrUpdateVo;
import com.sun.istack.internal.NotNull;

public interface ArticleService {
    /**
     * @author: eleven
     * @description: 增加文章
     * @date: 2020/11/16 16:31
     * @param null
     * @return
     */
    ResultEntity<AddOrUpdateVo> addOrUpdate(@NotNull AddOrUpdateVo addOrUpdateVo);

    ResultEntity<ArticleSortEnum> getSortList();
}
