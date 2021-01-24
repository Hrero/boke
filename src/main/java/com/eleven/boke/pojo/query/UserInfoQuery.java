package com.eleven.boke.pojo.query;

import java.io.Serializable;
import java.util.Date;

/**
 * @author : eleven
 * @description: TODO
 * @date : 2020/12/29 13:46
 */
public class UserInfoQuery implements Serializable {

    private Long userid;

    private String email;
    private String phone;

    private String nickname;
    private String agent;

    private String headPicture;

    private Date gmt_created;
    private Date gmt_modified;

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


    public String getHeadPicture() {
        return headPicture;
    }

    public void setHeadPicture(String headPicture) {
        this.headPicture = headPicture;
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

    public Date getGmt_created() {
        return gmt_created;
    }

    public void setGmt_created(Date gmt_created) {
        this.gmt_created = gmt_created;
    }

    public Date getGmt_modified() {
        return gmt_modified;
    }

    public void setGmt_modified(Date gmt_modified) {
        this.gmt_modified = gmt_modified;
    }


}
