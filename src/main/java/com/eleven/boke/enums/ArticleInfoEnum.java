package com.eleven.boke.enums;

import com.eleven.boke.base.BaseEnum;

public enum ArticleInfoEnum implements BaseEnum {
    ARTICLE_PARAMS_NULL(10001, "缺少参数");

    private int code;
    private String message;
    ArticleInfoEnum(int code, String message) {
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
