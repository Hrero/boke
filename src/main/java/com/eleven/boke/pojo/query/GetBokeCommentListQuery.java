package com.eleven.boke.pojo.query;

import lombok.Data;

import java.io.Serializable;

/**
 * @author : eleven
 * @description: TODO
 * @date : 2020/12/29 17:35
 */
@Data
public class GetBokeCommentListQuery implements Serializable {

    private Long articleId;

}
