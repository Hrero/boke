package com.eleven.boke.enums;

import com.eleven.boke.base.BaseEnum;


/**
 * @Date 2020/11/16 13:59 上午
 * @Author eleven
 */
public enum ArticleSortList implements BaseEnum {

    Development_Manual(1, "开发者手册");

    private int code;
    private String message;
    ArticleSortList(int code, String message) {
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
