package com.ltz.kotlindemo.chapter6.chapter6_3

/**
 * Created by xiaowei on 2018/9/28
 * 只读集合和可变集合 （只读集合并不是总是线程安全的）
 */

fun print6_3_2() {
    val source: Collection<Int> = arrayListOf(1, 3, 4)//只读集合（不一定是不可变的）
    val target: MutableCollection<Int> = arrayListOf(2)//可变集合
    copyElements(source, target)
    println(target)
}

fun <T> copyElements(source: Collection<T>, target: MutableCollection<T>) {
    for (item in source) {
        target.add(item)
    }
}