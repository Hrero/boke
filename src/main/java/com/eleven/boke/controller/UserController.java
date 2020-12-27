package com.eleven.boke.controller;

import com.eleven.boke.pojo.Do.BokeSysViewDo;
import com.eleven.boke.pojo.entity.ResultEntity;
import com.eleven.boke.pojo.query.UserQuery;
import com.eleven.boke.pojo.query.UserViewQuery;
import com.eleven.boke.pojo.vo.UserViewListVo;
import com.eleven.boke.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author : eleven
 * @description: TODO
 * @date : 2020/12/12 00:04
 */
@RestController
@RequestMapping("/user")
public class UserController {

    private final static Logger logger = LoggerFactory.getLogger(ArticleController.class);

    @Autowired
    private UserService userService;

    @PostMapping(value = "/addUserView")
    public ResultEntity<BokeSysViewDo> addUserView(@RequestBody UserQuery userQuery) {
        return userService.addUserView(userQuery);
    }

    @PostMapping(value = "/getUserView")
    public ResultEntity<List<UserViewListVo>> getUserView(@RequestBody UserViewQuery userViewQuery) {
        return userService.getUserView(userViewQuery);
    }

}
