package com.ltz.kotlindemo.chapter2.chapter2_2

import java.util.*

/**
 * Created by xiaowei on 2018/7/27
 */
class Rectangle(val height: Int, val width: Int) {
    val isSquare: Boolean
        get() = height == width
}

fun createRandomRectangle(): Rectangle {
    val random = Random()
    return Rectangle(random.nextInt(), random.nextInt())
}

