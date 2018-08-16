package com.ltz.kotlindemo.chapter6.chapter6_1

/**
 * Created by xiaowei on 2018/8/16
 * kotlin 可空类型的判断
 */

fun print6_1_1() {
//    strLen(null) 不能给一个不接收null的函数
    println(strLenCanBeNull(null))
    println(strLenCanBeNull("abc"))
}

//s不能为null
fun strLen(s: String) = s.length

//如果s可为null 则后面不能调用s的方法和属性 也不能赋值给非空类型的变量
fun strLenCanBeNull(s: String?) = if (s == null) 0 else s.length // if else 三元表达式
