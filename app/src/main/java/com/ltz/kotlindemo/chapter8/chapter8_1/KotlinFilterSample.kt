package com.ltz.kotlindemo.chapter8.chapter8_1

import java.lang.StringBuilder

/**
 * Created by xiaowei on 2018/11/5
 * 调用作为参数的函数
 *
 */

fun print8_1_2() {
    twoAndThree { a, b -> a + b }
    twoAndThree { i, j -> i * j }

    val name = "xiao3223wei123;;ka"
    println(name.filter { it in 'a'..'z' })

}

fun twoAndThree(operation: (Int, Int) -> Int) {
    val result = operation(2, 3)
    println("the result is $result")
}

fun String.filter(predicate: (Char) -> Boolean): String {
    val sb = StringBuilder()
    for (index in 0 until length) {
        val c = get(index)
        if (predicate(c)) sb.append(c)
    }
    return sb.toString()
}
