package com.ltz.kotlindemo.chapter8.chapter8_1

/**
 * Created by xiaowei on 2018/11/1
 *
 * 高阶函数：任何以 lambda 或者 函数引用 作为参数的函数，或者返回值为 lambda 或 函数引用 的函数，或者两者都满足的函数都是高阶函数 。
 *
 *   函数类型
 *
 *   参数类型       返回函数
 *   val/var :  (Int, String) -> Unit   //普通类型的函数返回值是Unit时可以省略，函数类型的声明不能省略
 *
 */

fun print8_1_1() {
    val list = listOf(1, 2, 3)
    //高阶函数
    println(list.filter { it > 1 })

    //将lambda表达式保存在变量中
    val sum = { x: Int, y: Int -> x + y }
    val action = { println("xiaowei") }

    //保存lambda表达式的对象的显示类型声明
    val sum1: (Int, Int) -> Int = { x, y -> x + y }
    val action1: () -> Unit = { println("...") }


    //函数类型的返回值也可以是可空类型
    val canReturnNull: (Int, Int) -> Int? = { _, _ -> null }

    //可空的函数类型变量
    var funOrNull: ((Int, Int) -> Int)? = null

    //定义一个高阶函数 指定 函数类型的参数 的参数名
    fun performRequest(
            url: String,
            callback: (code: Int, content: String) -> Unit) {
    }

    //调用高阶函数
    val url = "http://kot1.in"
    performRequest(url) { code, content ->
        /* ... */
    }
    performRequest(url) { code, page ->
        /* ... */ //可手动改变参数的名称
    }



}