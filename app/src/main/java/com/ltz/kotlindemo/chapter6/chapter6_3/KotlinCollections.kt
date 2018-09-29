package com.ltz.kotlindemo.chapter6.chapter6_3

import com.ltz.kotlindemo.JavaCode.CollectionUtils

/**
 * Created by xiaowei on 2018/9/28
 * Kotlin 集合和Java
 */

fun print6_3_3() {
    val list = listOf("a", "b", "c")//这里需要定义成可变集合
    println(printInUppercase(list))

}

fun printInUppercase(list: List<String>) {
    //调用可以修改集合的java函数
    println(CollectionUtils.uppercaseAll(list))//这里需要我们认为的来确定java代码是否会修改集合的内容，kotlin编译器不能确定java代码是否会修改集合
    //list的值将被改变
    println(list.first())
}