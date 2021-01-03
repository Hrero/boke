package com.eleven.boke.controller;

import com.eleven.boke.enums.ArticleSortEnum;
import com.eleven.boke.pojo.entity.ResultEntity;
import com.eleven.boke.pojo.vo.BokeClassTreeVo;
import com.eleven.boke.service.ArticleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author : eleven
 * @description: TODO
 * @date : 2020/12/11 23:19
 */
@RestController
@RequestMapping("/sort")
public class SortListController {
    private final static Logger logger = LoggerFactory.getLogger(ArticleController.class);

    @Autowired
    private ArticleService articleService;

    @GetMapping(value = "/getSortList")
    public ResultEntity<ArticleSortEnum> getSortList() {
        return articleService.getSortList();
    }

    @GetMapping(value = "/getClassList")
    public ResultEntity<BokeClassTreeVo> getClassList() {
        return articleService.getClassList();
    }

}
