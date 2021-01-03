package com.eleven.boke.mapper;

import com.eleven.boke.pojo.Do.BokeCommentListDo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author : eleven
 * @description: TODO
 * @date : 2020/12/29 18:08
 */
public interface BokeCommentListDoMapper {

    int insert(BokeCommentListDo record);

    List<BokeCommentListDo> selectParentbyArticleId(@Param("articleId") Long articleId);

    List<BokeCommentListDo> selectNomalListbyArticleId(@Param("articleId") Long articleId, @Param("parentCommentId") Long parentCommentId);

}
