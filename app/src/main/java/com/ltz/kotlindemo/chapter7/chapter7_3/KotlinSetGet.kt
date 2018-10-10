package com.ltz.kotlindemo.chapter7.chapter7_3

import com.ltz.kotlindemo.chapter7.chapter7_1.Point
import java.lang.IndexOutOfBoundsException

/**
 * Created by xiaowei on 2018/10/10
 * 通过下标来访问元素
 * x[a,b]  -->  x.get(a,b)
 * x[a]=b  --> x.set(a,b)
 * x[a,b]=c  -->  x.set(a,b,c)
 */

fun print7_3_1() {
    val p = Point(10, 20)
    println(p[0])
    println(p.get(1))//同样可以实现

    var p1 = MutablePoint(24, 12)
    p1[0] = 11
    println(p1)
//    p1[2]=3 //java.lang.IndexOutOfBoundsException: Invalid coordinate 2
}

operator fun Point.get(index: Int): Int {
    //switch
    return when (index) {
        0 -> x
        1 -> y
        else ->
            throw IndexOutOfBoundsException("Invalid coordinate $index")
    }
}

data class MutablePoint(var x: Int, var y: Int)

operator fun MutablePoint.set(index: Int, value: Int) {
    when (index) {
        0 -> x = value
        1 -> y = value
        else ->
            throw IndexOutOfBoundsException("Invalid coordinate $index")
    }
}