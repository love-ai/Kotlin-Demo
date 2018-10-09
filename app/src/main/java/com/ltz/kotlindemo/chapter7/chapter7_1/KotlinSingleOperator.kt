package com.ltz.kotlindemo.chapter7.chapter7_1

import java.math.BigDecimal

/**
 * Created by xiaowei on 2018/10/9
 * 重载一元运算符
 * +a unaryPlus
 * -a unaryMinus
 * !a not
 * ++a a++ inc
 * --a a-- dec
 */

fun print7_1_3() {
    val p = Point(3, 4)
    println(-p)
    println(p.unaryMinus())

    var bd = BigDecimal.ZERO
    println(bd++)
    println(++bd)
}

operator fun Point.unaryMinus(): Point {//一元运算符没有参数
    return Point(-x, -y)
}

operator fun BigDecimal.inc() = this + BigDecimal.ONE