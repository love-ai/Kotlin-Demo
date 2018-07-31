package com.ltz.kotlindemo.chapter3.chapter3_2

import com.ltz.kotlindemo.util.joinToStringUtil

/**
 * Created by xiaowei on 2018/7/31
 */

val list = listOf(1, 2, 3)

//[1,2,3]
fun printOriginList() {
//    println(list)
//    println(joinToString(list,";","(",")"))
    //默认参数可以省略
    println(joinToStringWithDefaultParams(list))
    //为指定参数名只能按照顺序，且只能省略后面的参数
    println(joinToStringWithDefaultParams(list, ";"))
    //指定参数名后可以随意顺序
    println(joinToStringWithDefaultParams(list, postfix = "]", prefix = "["))

    //倒入函数名，直接调用join.kt中的函数
    joinToStringUtil(list)
}

fun <T> joinToString(
        collection: Collection<T>,
        separator: String,
        prefix: String,
        postfix: String
): String {
    val result = StringBuilder(prefix)

    for ((index, element) in collection.withIndex()) {
        if (index > 0) result.append(separator)
        result.append(element)
    }
    result.append(postfix)
    return result.toString()
}

fun <T> joinToStringWithDefaultParams(
        collection: Collection<T>,
        separator: String = ",",
        prefix: String = "",
        postfix: String = ""
): String {
    val result = StringBuilder(prefix)

    for ((index, element) in collection.withIndex()) {
        if (index > 0) result.append(separator)
        result.append(element)
    }
    result.append(postfix)
    return result.toString()
}




