package com.ltz.kotlindemo.JavaCode;

import java.util.List;

/**
 * Created by xiaowei on 2018/9/29
 */
public interface DataParser<T> {
    void parseData(String input,
                   List<T> output,
                   List<String> errors);
}