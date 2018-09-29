package com.ltz.kotlindemo.JavaCode;

import java.util.List;

/**
 * Created by xiaowei on 2018/9/28
 */
public class CollectionUtils {
    public static List<String> uppercaseAll(List<String> items) {
        for (int i = 0; i < items.size(); i++) {
            items.set(i, items.get(i).toUpperCase());
        }
        return items;
    }


}

