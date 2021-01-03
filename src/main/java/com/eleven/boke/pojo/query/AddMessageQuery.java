package com.eleven.boke.pojo.query;

import java.io.Serializable;

/**
 * @author : eleven
 * @description: TODO
 * @date : 2020/12/12 01:18
 */
public class AddMessageQuery implements Serializable {
    private String content;
    private String agent;

    private String headPicture;

    private String email;
    private String name;
    private String ip;


    public String getAgent() {
        return agent;
    }


    public String getHeadPicture() {
        return headPicture;
    }

    public void setHeadPicture(String headPicture) {
        this.headPicture = headPicture;
    }

    public void setAgent(String agent) {
        this.agent = agent;
    }


    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

}
