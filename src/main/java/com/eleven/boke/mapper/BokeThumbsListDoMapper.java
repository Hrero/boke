package com.eleven.boke.mapper;


import com.eleven.boke.pojo.Do.BokeSysViewDo;
import com.eleven.boke.pojo.Do.BokeThumbsListDo;
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

    @Select("SELECT * FROM boke_thumbs_list WHERE ip = #{ip} and article_id = #{articleId}")
    List<BokeThumbsListDo> selectIdArticleId(@Param("ip") String ip, @Param("articleId") Long articleId);


    @Select("SELECT * FROM boke_thumbs_list WHERE ip = #{ip} and article_id = #{articleId} and status = #{status}")
    List<BokeThumbsListDo> selectIdArticleStatus(@Param("ip") String ip, @Param("articleId") Long articleId, @Param("status") Long status);

    @Select("SELECT * FROM boke_thumbs_list WHERE article_id = #{articleId} and status = #{status}")
    List<BokeThumbsListDo> selectIdArticleList(@Param("articleId") Long articleId, @Param("status") Long status);

    int updateByPrimaryKey(BokeThumbsVo record);
}
