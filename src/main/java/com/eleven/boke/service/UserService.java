package com.eleven.boke.service;

import com.eleven.boke.base.ResultUtil;
import com.eleven.boke.pojo.Do.BokeSysViewDo;
import com.eleven.boke.pojo.entity.ResultEntity;
import com.eleven.boke.pojo.query.GetUserInfoQuery;
import com.eleven.boke.pojo.query.UserInfoQuery;
import com.eleven.boke.pojo.query.UserQuery;
import com.eleven.boke.pojo.query.UserViewQuery;
import com.eleven.boke.pojo.vo.UserInfoVo;
import com.eleven.boke.pojo.vo.UserViewListVo;

import java.util.List;

/**
 * @author : eleven
 * @description: TODO
 * @date : 2020/12/12 00:06
 */
public interface UserService {
    /**
     * @author: eleven
     * @description: 添加用户访问
     */
    ResultEntity<BokeSysViewDo> addUserView(UserQuery userQuery);

    /**
     * @author: eleven
     * @description: 获取用户访问
     */
    ResultEntity<List<UserViewListVo>> getUserView(UserViewQuery userViewQuery);

    ResultEntity<UserInfoVo> addUser(UserInfoQuery userInfoQuery);

    ResultEntity<UserInfoVo> getUserInfo(GetUserInfoQuery getUserInfoQuery);

}
