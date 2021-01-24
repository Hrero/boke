package com.eleven.boke.pojo.Do;

import java.util.Date;

/**
 * @author : eleven
 * @description: TODO
 * @date : 2020/12/29 14:10
 */
public class BokeUserInfoDo {
    private Long id;
    private String email;
    private String nickname;
    private String agent;
    private String phone;

    private String headPicture;
    private String head_picture;

    public String getHead_picture() {
        return head_picture;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setHead_picture(String head_picture) {
        this.head_picture = head_picture;
    }

    private Date gmtCreated;
    private Date gmtModified;


    public String getHeadPicture() {
        return headPicture;
    }

    public void setHeadPicture(String headPicture) {
        this.headPicture = headPicture;
    }
    public Date getGmtCreated() {
        return gmtCreated;
    }

    public void setGmtCreated(Date gmtCreated) {
        this.gmtCreated = gmtCreated;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public void setAgent(String agent) {
        this.agent = agent;
    }


}
