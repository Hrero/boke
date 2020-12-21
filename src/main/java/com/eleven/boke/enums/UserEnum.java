package com.eleven.boke.enums;

import com.eleven.boke.base.BaseEnum;

public enum UserEnum implements BaseEnum {
    SORT_DEVELOPMENT(20001, "继续浏览")
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
