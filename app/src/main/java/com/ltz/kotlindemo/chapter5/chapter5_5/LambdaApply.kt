package com.ltz.kotlindemo.chapter5.chapter5_5

import android.content.Context
import android.widget.TextView

/**
 * Created by xiaowei on 2018/8/14
 * 带接收者对象的Lambda函数 Apply
 */

fun print5_5_2() {
    println(alphabetApply())
}

//apply 作为作为实参传递给它的对象， 即接收者对象
fun alphabetApply() = StringBuffer().apply {
    for (letter in 'A'..'Z') {
        append(letter)
    }
    append("\nNow I konw the alphabet")
}.toString()

//安卓创建textview用法
fun createViewWithCustemAttribute(context: Context) = TextView(context).apply {
    text = "sample text"
    textSize = 20.0f
    setPadding(10, 0, 0, 0)
}

//使用buildString 创建字母表
fun alphabetBuildString() = buildString {
    for (letter in 'A'..'Z') {
        append(letter)
    }
    append("\nNow I know the alphabet")
}