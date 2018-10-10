package com.ltz.kotlindemo.chapter7.chapter7_3

import com.ltz.kotlindemo.chapter7.chapter7_1.Point

/**
 * Created by xiaowei on 2018/10/10
 * Kotlin "in" 的约定
 * a in c  -->  c.contains(a)
 */

fun print7_3_2() {
    val rec = Rectangle(Point(0, 40), Point(40, 0))
    println(Point(5, 5) in rec)
    println(Point(39, 0) in rec)

}

data class Rectangle(val upperLeft: Point, val lowerRight: Point)


operator fun Rectangle.contains(p: Point): Boolean {
    //a in x..y  ---> a ∈ [x,y] 闭区间
    //a in x until y  --->  a ∈ [x,y) 所以矩形的顶部和右侧不属于矩形，书中有错误
    return p.x in upperLeft.x until lowerRight.x &&
            p.y in lowerRight.y until upperLeft.y
}