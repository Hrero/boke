package com.eleven.boke.mapper;

import com.eleven.boke.pojo.Do.BokeSysViewDo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import java.util.Date;
import java.util.List;

public interface BokeSysViewDoMapper {

    int deleteByPrimaryKey(String ip);

    int insert(BokeSysViewDo record);

    BokeSysViewDo selectByPrimaryKey(String ip);

    List<BokeSysViewDo> selectAll();

    List<BokeSysViewDo> selectAllLimit();

    int updateByPrimaryKey(BokeSysViewDo record);

    @Select("SELECT * FROM boke_sys_view WHERE gmt_created > DATE_SUB(now(),INTERVAL 20 MINUTE) and ip = #{ip}")
    @ResultMap("BaseResultMap")
    List<BokeSysViewDo> selectTimeReadyIn(@Param("ip") String ip);
}
