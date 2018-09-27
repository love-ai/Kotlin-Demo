package com.ltz.kotlindemo.chapter6.chapter6_2

/**
 * Created by xiaowei on 2018/9/26
 * kotlin基本数据类型
 */

fun print6_2_1() {
    val i: Int = 1
    val j: Int = 0 //这里需要初始化
    val list: List<Int> = listOf(1, 2, 3)
    println("j is $j")
    showProgress(120)

    val mByte = 1323
    val mShort: Short = 23422
    val mLong: Long = 2323232323230334212

    println("$mByte - $mShort - $mLong")

    println("Byte: ${Byte.MIN_VALUE}～${Byte.MAX_VALUE}")
    println("Short: ${Short.MIN_VALUE}～${Short.MAX_VALUE}")
    println("Int: ${Int.MIN_VALUE}～${Int.MAX_VALUE}")
    println("Long: ${Long.MIN_VALUE}～${Long.MAX_VALUE}")

    println("Float: ${Float.MIN_VALUE}～${Float.MAX_VALUE}")
    println("Double: ${Double.MIN_VALUE}～${Double.MAX_VALUE}")
}

fun showProgress(progress: Int) {
    val percent = progress.coerceIn(0, 100)//基本数据类型可以直接调用函数
    println("We're ${percent}% done!")
}