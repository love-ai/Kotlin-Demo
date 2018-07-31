package com.ltz.kotlindemo.chapter2.chapter2_3

/**
 * Created by xiaowei on 2018/7/27
 */

enum class Color {
    RED, ORANGE, YELLOW, GREEN, BLUE, INDIGO, VILOET
}

//枚举类型中定义函数
enum class MyColor(var r: Int, var g: Int, var b: Int) {
    RED(255, 0, 0), GREEN(0, 255, 0), BLUE(0, 0, 255),
    INDIGO(75, 0, 130), VILOET(238, 130, 238);

    fun rgb() = (r * 256 + g) * 256 + b
}

