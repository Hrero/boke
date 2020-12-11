package com.eleven.boke.controller;

import com.eleven.boke.pojo.entity.ResultEntity;
import com.eleven.boke.pojo.vo.AddOrUpdateVo;
import com.eleven.boke.service.ArticleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/article")
public class ArticleController {

    private final static Logger logger = LoggerFactory.getLogger(ArticleController.class);

    @Autowired
    private ArticleService articleService;

    @PostMapping(value = "/addOrUpdate")
    public ResultEntity<AddOrUpdateVo> getUserByName(@RequestBody AddOrUpdateVo addOrUpdateVo) {
        return articleService.addOrUpdate(addOrUpdateVo);
    }
}

