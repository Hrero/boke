package com.eleven.boke.pojo.vo;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;
import java.util.List;

/**
 * @author : eleven
 * @description: TODO
 * @date : 2021/1/2 14:09
 */
public class BokeClassTreeVo implements Serializable {
    private Long id;

    private String label;

    private Long value;

    private String name;
    private Long pid;
    private String path;
    private Integer status;

    private Integer articleNum;

    public Integer getArticleNum() {
        return articleNum;
    }

    public void setArticleNum(Integer articleNum) {
        this.articleNum = articleNum;
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Boolean isLeaf;


    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Long getValue() {
        return value;
    }

    public void setValue(Long value) {
        this.value = value;
    }


    public Boolean getIsLeaf() {
        return isLeaf;
    }

    public void setIsLeaf(Boolean leaf) {
        isLeaf = leaf;
    }

//    public void removeIsLeaf(String leaf) {
//        BokeClassTreeVo.;
//    }



    private List<BokeClassTreeVo> children;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public List<BokeClassTreeVo> getChildren() {
        return children;
    }

    public void setChildren(List<BokeClassTreeVo> children) {
        this.children = children;
    }

}
