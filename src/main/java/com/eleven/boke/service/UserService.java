package com.eleven.boke.service;

import com.eleven.boke.pojo.Do.BokeSysViewDo;
import com.eleven.boke.pojo.entity.ResultEntity;
import com.eleven.boke.pojo.query.UserQuery;

import java.util.List;

/**
 * @author : eleven
 * @description: TODO
 * @date : 2020/12/12 00:06
 */
public interface UserService {
    ResultEntity<BokeSysViewDo> addUserView(UserQuery userQuery);
    ResultEntity<List<BokeSysViewDo>> getUserView();
}
