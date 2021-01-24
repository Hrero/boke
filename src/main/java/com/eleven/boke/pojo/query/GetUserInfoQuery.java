package com.eleven.boke.pojo.query;

import lombok.Data;

import java.io.Serializable;

/**
 * @author : eleven
 * @description: TODO
 * @date : 2020/12/30 11:09
 */
@Data
public class GetUserInfoQuery implements Serializable {

    private String nickname;

}
