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

    private Long userid;

    private String email;
    private String nickname;

    private String phone;

    private String ip;

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }


    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

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

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

}
