package com.eleven.boke.mapper;

import com.eleven.boke.pojo.Do.BokeUserInfoDo;
import com.eleven.boke.pojo.vo.UserInfoVo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author : eleven
 * @description: TODO
 * @date : 2020/12/29 14:14
 */
public interface BokeUserInfoDoMapper {

    int insert(UserInfoVo record);

    @Select("SELECT * FROM boke_user_info WHERE nickname = #{nickname}")
    List<BokeUserInfoDo> selectNickName(@Param("nickname") String nickname);


    @Select("SELECT * FROM boke_user_info WHERE userid = #{userid} and agent = #{agent}")
    BokeUserInfoDo selectByAgentIp(@Param("userid") String userid, @Param("agent") String agent);

    BokeUserInfoDo selectById(@Param("id") Long id);


}
