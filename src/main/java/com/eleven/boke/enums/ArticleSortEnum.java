package com.eleven.boke.enums;

import com.eleven.boke.base.BaseEnum;

public enum ArticleSortEnum implements BaseEnum {
    SORT_DEVELOPMENT(1, "开发者手册"),
    SORT_JAVA(2, "JAVA"),
    SORT_JS(3, "JAVA"),
    SORT_MUSIC(4, "音乐");

    private int code;
    private String message;
    ArticleSortEnum(int code, String message) {
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
