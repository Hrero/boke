package com.eleven.boke.mapper;

import com.eleven.boke.pojo.Do.BokeArticleInfoDo;
import com.eleven.boke.pojo.Do.BokeClassTreeDo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author : eleven
 * @description: TODO
 * @date : 2021/1/2 14:07
 */
public interface BokeClassTreeDoMapper {

    List<BokeClassTreeDo> selectAll();

    List<BokeClassTreeDo> selectMenuList();

    List<BokeClassTreeDo> selectPathList(@Param("path") String path);


    List<BokeClassTreeDo> selectByPidId(@Param("pid") Long pid);


}
