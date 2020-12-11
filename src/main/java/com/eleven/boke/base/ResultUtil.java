package com.eleven.boke.base;

import com.eleven.boke.pojo.entity.ResultEntity;

/**
 * @author : eleven
 * @description: TODO res封装
 * @date : 2020/11/18 14:11
 */
public class ResultUtil {

    public static ResultEntity success(Object object) {
        ResultEntity result = new ResultEntity();
        result.setCode(0);
        result.setMsg("成功");
        result.setData(object);
        return result;
    }

    public static ResultEntity success() {
        return success(null);
    }

    public static ResultEntity error(BaseEnum baseEnum) {
        ResultEntity resultEntity = new ResultEntity();
        resultEntity.setCode(baseEnum.getCode());
        resultEntity.setMsg(baseEnum.getMessage());
        return resultEntity;
    }

}
