package com.ltz.kotlindemo.chapter3.chapter3_3

import com.ltz.kotlindemo.util.lastChar

/**
 * Created by xiaowei on 2018/7/31
 */
val list = listOf(1, 2, 3)

fun print3_3() {
    println(list.joinToString(separator = ";"))
    //重载函数调用的时候调用的是真实类型的函数
    val view: View = Button()
    view.click()
    view.showOff()

    val view1 = View()
    view1.click()

    val button = Button()
    button.showOff()

    val sb = StringBuilder("Kotlin-a")
    sb.lastChar = '!'
    println("Kotlin".lastChar)
    println(sb.lastChar)

}

fun <T> Collection<T>.joinToString(
        separator: String = ",",
        prefix: String = "",
        postfix: String = ""
): String {
    val result = StringBuilder(prefix)
    // 这里其实是对map的key value进行解构声明 类似于Pair
    for ((index, element) in this.withIndex()) {//其实调用者就是this，就是第一个参数 也就是接受者对象
        if (index > 0) result.append(separator)
        result.append(element)
    }
    result.append(postfix)
    return result.toString()
}


