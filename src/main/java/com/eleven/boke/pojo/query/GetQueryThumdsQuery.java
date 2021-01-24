package com.eleven.boke.pojo.query;

import lombok.Data;

import java.io.Serializable;

/**
 * @author : eleven
 * @description: TODO
 * @date : 2021/1/23 15:10
 */

@Data
public class GetQueryThumdsQuery implements Serializable {
    private Long userid;

    private Long articleId;

}
