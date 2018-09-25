package com.ltz.kotlindemo.chapter6.chapter6_1

/**
 * Created by xiaowei on 2018/9/25
 * 类型参数的可空性
 */

fun print6_1_10() {
    printHashCode(null)
//    printHashCode1(null) //这里就会报错 null不是Any类型
}

fun <T> printHashCode(t: T) {//类型参数 T推导出的类型是可空类型 Any?
    println(t?.hashCode())
}

fun <T : Any> printHashCode1(t: T) {
    println(t.hashCode())
}