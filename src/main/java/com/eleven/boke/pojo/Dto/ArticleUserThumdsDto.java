package com.eleven.boke.pojo.Dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author : eleven
 * @description: TODO
 * @date : 2021/1/24 13:26
 */
@Data
public class ArticleUserThumdsDto implements Serializable {
    private Long articleId;

    private Integer thumdsStatus;
}
