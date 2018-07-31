package com.ltz.kotlindemo.chapter3.chapter3_4

/**
 * Created by xiaowei on 2018/7/31
 */

fun print3_4() {
    println(strings.last())
    println(linenumber.max())
    println(map[5])
    val (number, name) = 1 to "one"
}

fun main(args: Array<String>) {
    //展开运算符、展开数组内容 不加*号也可以
    val list = listOf("arg", *args)

    val (number, name) = 1 to "one"

    println(list)
}

val strings = listOf("first", "second", "fourteenth")
val linenumber = listOf(2, 3, 5, 7, 11, 13, 17, 19, 23, 27, 31)


//to 一种特殊的函数调用 中缀调用
val map = mapOf(1 to "one", 2 to "two", 3 to "three", 4 to "four", Pair(5, "five"))//可以直接传入pair

//中缀函数 to 声明
//infix fun Any.to(other: Any) = Pair(this, other)

//解构声明 只能声明再函数中
//val (number, name) = 1 to "one"