package com.eleven.boke.service.impl;

import com.eleven.boke.base.ResultUtil;
import com.eleven.boke.controller.ArticleController;
import com.eleven.boke.enums.ArticleInfoEnum;
import com.eleven.boke.mapper.BokeSysViewDoMapper;
import com.eleven.boke.pojo.Do.BokeSysViewDo;
import com.eleven.boke.pojo.entity.ResultEntity;
import com.eleven.boke.pojo.query.UserQuery;
import com.eleven.boke.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author : eleven
 * @description: TODO
 * @date : 2020/12/12 00:08
 */
@Service
public class UserServiceImpl implements UserService {

    private final static Logger logger = LoggerFactory.getLogger(ArticleController.class);

    @Autowired
    private BokeSysViewDoMapper bokeSysViewDoMapper;

    @Override
    public ResultEntity<BokeSysViewDo> addUserView(UserQuery userQuery) {
        BokeSysViewDo bokeSysViewDo = new BokeSysViewDo();
        bokeSysViewDo.setIp(userQuery.getIp());

        List<BokeSysViewDo> isIn = bokeSysViewDoMapper.selectTimeReadyIn(userQuery.getIp());
        if (isIn.size() == 0) {
            bokeSysViewDoMapper.insert(bokeSysViewDo);
        }
        return ResultUtil.success(bokeSysViewDo);
    }

    @Override
    public ResultEntity<List<BokeSysViewDo>> getUserView() {
        List<BokeSysViewDo> bokeSysViewDos = bokeSysViewDoMapper.selectAllLimit();
        return ResultUtil.success(bokeSysViewDos);
    }
}












