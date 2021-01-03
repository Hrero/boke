package com.eleven.boke.enums;

import com.eleven.boke.base.BaseEnum;

public enum UserEnum implements BaseEnum {
    SORT_DEVELOPMENT(20001, "继续浏览"),
    USER_NULL_INFO(20002, "缺少信息"),
    USER_READY_IN_USER_VIEW(20003, "已存在"),
    USER_NAME_AGAIN(20004, "名字重复"),
    USER_NULL_INFO_VIEW(20005, "无此用户"),
    ;

    private int code;
    private String message;
    UserEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public int getCode() {
        return this.code;
    }

    @Override
    public String getMessage() {
        return this.message;
    }
}
