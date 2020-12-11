package com.eleven.boke.enums;

import com.eleven.boke.base.BaseEnum;

public enum MessageEnum implements BaseEnum {
    MESSAGE_PARAMS_NULL(10001, "缺少参数"),
    MESSAGE_IS_EFFECTIVE(1, "有效"),
    MESSAGE_NO_EFFECTIVE(0, "无效");

    private int code;
    private String message;
    MessageEnum(int code, String message) {
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
