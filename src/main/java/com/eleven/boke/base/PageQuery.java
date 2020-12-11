package com.eleven.boke.base;

import java.io.Serializable;

public class PageQuery implements Serializable {
    private Integer pageNum = 1;
    private Integer pageSize = 10;

    public PageQuery() { }

    public Integer getPageNum() {
        return this.pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return this.pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
