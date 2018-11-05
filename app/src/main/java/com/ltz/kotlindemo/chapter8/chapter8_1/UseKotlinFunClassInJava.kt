package com.ltz.kotlindemo.chapter8.chapter8_1

import com.ltz.kotlindemo.JavaCode.UseKotlinFunClass

/**
 * Created by xiaowei on 2018/11/5
 * 在Java中使用函数类
 */

fun print8_1_3() {
    //调用java方法
    UseKotlinFunClass.Test()
}


fun processTheAnswer(f: (Int) -> Int) {
    println(f(42))
}