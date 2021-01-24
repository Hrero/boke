package com.eleven.boke.pojo.Do;

import lombok.Data;

import java.util.Date;

@Data
public class BokeArticleMessageDo {
    private Long id;

    private String content;

    private String email;

    private String nickname;

    private Long userid;

    private String CreateTime;

    private Long isEffective;

    private Date gmtCreated;

    private Date gmtModified;

}
