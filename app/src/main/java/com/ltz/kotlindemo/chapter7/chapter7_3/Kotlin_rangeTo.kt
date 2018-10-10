package com.ltz.kotlindemo.chapter7.chapter7_3

import android.annotation.TargetApi
import android.os.Build
import java.time.LocalDate

/**
 * Created by xiaowei on 2018/10/10
 * rangeTo的约定
 * start..end  -->  start.rangeTo(end)
 *
 */
@TargetApi(Build.VERSION_CODES.O)
fun print7_3_3() {
    val now = LocalDate.now()
    val vacation = now..(now.plusDays(10))
//    now.rangeTo(now.plusDays(10))
    println(now.plusWeeks(1) in vacation)

    val n = 9
    //rangeTo 运算符的优先级低于算术运算符，但是最好把参数括起来以免混淆:
    println(0..(n + 1))//也可以写成 0..n+1 但括起来更清晰

    //只能把区间表达式括起来才能调用其方法
    (1..5).forEach { println(it) }//这里类型需要是Int


}

