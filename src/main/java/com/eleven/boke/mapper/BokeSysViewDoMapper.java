package com.eleven.boke.mapper;

import com.eleven.boke.pojo.Do.BokeSysViewDo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface BokeSysViewDoMapper {

    int deleteByPrimaryKey(String ip);

    int insert(BokeSysViewDo record);

    List<BokeSysViewDo> selectByArticleId(Long articleId);

    BokeSysViewDo selectByIp(String ip);

    List<BokeSysViewDo> selectAll();

    List<BokeSysViewDo> selectArticleLimit(@Param("articleId") Long articleId, @Param("sortId") Long sortId);

    int updateByPrimaryKey(BokeSysViewDo record);

    @Select("SELECT * FROM boke_sys_view WHERE gmt_created > DATE_SUB(now(),INTERVAL 20 MINUTE) and userid = #{userid} and article_id = #{articleId}")
    @ResultMap("BaseResultMap")
    List<BokeSysViewDo> selectTimeReadyIn(@Param("userid") Long userid, @Param("articleId") Long articleId);
}
