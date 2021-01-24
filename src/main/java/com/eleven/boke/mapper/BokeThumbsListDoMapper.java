package com.eleven.boke.mapper;


import com.eleven.boke.pojo.Do.BokeSysViewDo;
import com.eleven.boke.pojo.Do.BokeThumbsListDo;
import com.eleven.boke.pojo.Dto.ArticleHotDto;
import com.eleven.boke.pojo.Dto.ArticleUserThumdsDto;
import com.eleven.boke.pojo.query.BokeThumbsQuery;
import com.eleven.boke.pojo.vo.BokeThumbsVo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author : eleven
 * @description: TODO
 * @date : 2020/12/27 13:35
 */
public interface BokeThumbsListDoMapper {

    int insert(BokeThumbsVo record);

    @Select("SELECT * FROM boke_thumbs_list WHERE userid = #{userid} and article_id = #{articleId}")
    List<BokeThumbsListDo> selectIdArticleId(@Param("userid") Long userid, @Param("articleId") Long articleId);


    @Select("SELECT * FROM boke_thumbs_list WHERE userid = #{userid} and article_id = #{articleId} and status = #{status}")
    List<BokeThumbsListDo> selectIdArticleStatus(@Param("userid") Long userid, @Param("articleId") Long articleId, @Param("status") Long status);

    @Select("SELECT * FROM boke_thumbs_list WHERE article_id = #{articleId} and status = #{status}")
    List<BokeThumbsListDo> selectIdArticleList(@Param("articleId") Long articleId, @Param("status") Long status);

    int updateByPrimaryKey(BokeThumbsVo record);

    @Select("SELECT \n" +
            "article_id articleId,\n" +
            "status thumdsStatus\n" +
            "FROM boke_thumbs_list list \n" +
            "JOIN boke_article_info info on info.id = list.article_id\n" +
            "WHERE info.sort_id = 15 and userid = #{userid}")
    List<ArticleUserThumdsDto> selectIdArticleUser(@Param("userid") Long userid);


}
