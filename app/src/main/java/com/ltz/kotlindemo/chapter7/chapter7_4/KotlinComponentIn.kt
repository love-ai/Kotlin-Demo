package com.ltz.kotlindemo.chapter7.chapter7_4

/**
 * Created by xiaowei on 2018/10/11
 * 解构声明和循环
 */

fun print7_4_1() {
    val map = mapOf("xiaowei" to "a", "xiaohong" to "b")

    printEntries(map)
}

fun printEntries(map: Map<String, String>) {
    for ((key, value) in map) {
        println("$key -> $value")
    }

    //上面其实调用的是
    for (entry in map.entries) {
        val key = entry.component1()
        val value = entry.component2()
    }

}

