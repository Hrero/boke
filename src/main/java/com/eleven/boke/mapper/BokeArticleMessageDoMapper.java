package com.eleven.boke.mapper;

import com.eleven.boke.pojo.Do.BokeArticleMessageDo;
import java.util.List;

public interface BokeArticleMessageDoMapper {
    int deleteByPrimaryKey(Long id);

    int insert(BokeArticleMessageDo record);

    BokeArticleMessageDo selectByPrimaryKey(Long id);

    List<BokeArticleMessageDo> selectAll();

    int updateByPrimaryKey(BokeArticleMessageDo record);


}
