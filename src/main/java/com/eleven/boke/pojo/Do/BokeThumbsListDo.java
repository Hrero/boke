package com.eleven.boke.pojo.Do;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author : eleven
 * @description: TODO
 * @date : 2020/12/27 13:36
 */
@Data
public class BokeThumbsListDo {
    private Long id;
    private Long articleId;
    private Date gmtCreated;
    private Date gmtModified;
    private Long status;
    private Long userid;

}
