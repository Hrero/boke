package com.eleven.boke.util;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollectionUtil;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author : eleven
 * @description: TODO
 * @date : 2020/12/12 21:33
 */
public class BeanUtils extends BeanUtil{
    public BeanUtils() {
    }

    public static <T> List<T> copyCollection(List source, Class<T> target) {
        List<T> rs = new ArrayList();
        if (CollectionUtil.isNotEmpty(source)) {
            source.stream().forEach((s) -> {
                try {
                    T o = target.newInstance();
                    copyProperties(s, o, new String[0]);
                    rs.add(o);
                } catch (InstantiationException var4) {
                    var4.printStackTrace();
                } catch (IllegalAccessException var5) {
                    var5.printStackTrace();
                }

            });
        }

        return rs;
    }

    public static <T> Set<T> copyCollection(Set source, Class<T> target) {
        Set<T> rs = new HashSet();
        if (CollectionUtil.isNotEmpty(source)) {
            source.stream().forEach((s) -> {
                try {
                    T o = target.newInstance();
                    copyProperties(s, o, new String[0]);
                    rs.add(o);
                } catch (InstantiationException var4) {
                    var4.printStackTrace();
                } catch (IllegalAccessException var5) {
                    var5.printStackTrace();
                }

            });
        }

        return rs;
    }
}
