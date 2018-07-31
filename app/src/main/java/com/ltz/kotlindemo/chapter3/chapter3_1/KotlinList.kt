package com.ltz.kotlindemo.chapter3.chapter3_1

/**
 * Created by xiaowei on 2018/7/30
 */

val set = hashSetOf(1,7,23)
val list = arrayListOf(1,8,24)
val map = hashMapOf(1 to "one",7 to "seven",53 to "fifty-three")

fun printJavaClass(){
    println(set.javaClass)
    println(list.javaClass)
    println(map.javaClass)
    println(set.last())
    println(set.max())
    println(set.first())
    println(set.average())
}