package com.eleven.boke.service;

import com.eleven.boke.pojo.Do.BokeSysViewDo;
import com.eleven.boke.pojo.entity.ResultEntity;
import com.eleven.boke.pojo.query.UserQuery;

/**
 * @author : eleven
 * @description: TODO
 * @date : 2020/12/12 00:06
 */
public interface UserService {
    ResultEntity<BokeSysViewDo> addUserView(UserQuery userQuery);
}
