package com.ltz.kotlindemo.chapter8.chapter8_1

import java.lang.StringBuilder

/**
 * Created by xiaowei on 2018/11/6
 * 函数类型的默认值和null值
 */

fun print8_1_4() {
    val stages = listOf("Low", "Middle", "Heigh")
    println(stages.joinToString())
    println(stages.joinToString { it.toUpperCase() })
    foo {}

    println(stages.joinToString1())

}

fun <T> Collection<T>.joinToString(
        separator: String = ",",
        prefix: String = "",
        postfix: String = "",
        transform: (T) -> String = { it.toString() }): String {
    val sb = StringBuilder(prefix)
    for ((index, element) in this.withIndex()) {
        if (index > 0) sb.append(separator)
//        sb.append(element) //默认调用toString()
        sb.append(transform(element))//将对象执行传入的操作
    }
    sb.append(postfix)
    return sb.toString()
}

fun <T> Collection<T>.joinToString1(
        separator: String = ",",
        prefix: String = "",
        postfix: String = "",
        transform: ((T) -> String)? = null): String { //表示可空类型
    val sb = StringBuilder(prefix)
    for ((index, element) in this.withIndex()) {
        if (index > 0) sb.append(separator)
//        sb.append(element) //默认调用toString()
        sb.append(transform?.invoke(element))//为null时调用invoke
    }
    sb.append(postfix)
    return sb.toString()
}


fun foo(callback: (() -> Unit)?) {
//    callback?.invoke()
    if (callback != null) {
        callback()
    }
}
