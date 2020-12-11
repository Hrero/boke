package com.eleven.boke.controller;

import com.eleven.boke.pojo.Do.BokeArticleMessageDo;
import com.eleven.boke.pojo.Do.BokeSysViewDo;
import com.eleven.boke.pojo.entity.ResultEntity;
import com.eleven.boke.pojo.query.AddMessageQuery;
import com.eleven.boke.service.MessageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author : eleven
 * @description: TODO
 * @date : 2020/12/12 01:16
 */
@RestController
@RequestMapping("/message")
public class MessageController {

    private final static Logger logger = LoggerFactory.getLogger(ArticleController.class);

    @Autowired
    private MessageService messageService;

    @PostMapping(value = "/addMessage")
    public ResultEntity<BokeArticleMessageDo> addMessage(@RequestBody AddMessageQuery addMessageQuery) {
        return messageService.addMessage(addMessageQuery);
    }

    @GetMapping(value = "/getMessageList")
    public ResultEntity<BokeArticleMessageDo> getMessageList() {
        return messageService.getMessageList();
    }
}
