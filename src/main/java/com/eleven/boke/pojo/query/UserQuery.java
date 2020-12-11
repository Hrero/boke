package com.eleven.boke.pojo.query;

import java.io.Serializable;

/**
 * @author : eleven
 * @description: TODO
 * @date : 2020/12/11 23:57
 */
public class UserQuery implements Serializable {
    /**
     * @author: eleven
     * @description: 用户ip唯一标识
     */
    private String ip;


    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }


}
