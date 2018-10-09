package com.ltz.kotlindemo.chapter7.chapter7_1

/**
 * Created by xiaowei on 2018/10/8
 * 重载二元算数运算
 *
 * 同一个文件中内部函数优先级大于扩展函数
 * a * b times
 * a / b div
 * a % b mod
 * a + b plus
 * a - b minus
 * （* / % 优先级高）
 * shl 带符号左移
 * shr 带符号右移
 * ushr 无符号右移
 * and 按位与
 * or 按位或
 * xor 按位异或
 * inv 按位取反
 */

fun print7_1_1() {
    val p1 = Point(2, 3)
    val p2 = Point(4, 1)
    println(p1 + p2)
    println(p1 + 3)
    println(p1.plus(p2))
    println(p1 * 3.5)

    println('c' * 4)

    println(0x0F and 0XF0)
    println(0x0F or 0XF0)
    println(0x01 shl 4)

}

data class Point(val x: Int, val y: Int) {
    //该方法将被调用
    operator fun plus(other: Point): Point {
        return Point(x + other.x + 100, y + other.y + 100)
    }

}

//扩展函数版本 同时存在时不会被调用
operator fun Point.plus(k: Int): Point {
    return Point(x + k, y + k)
}

//运算数类型可以不同
operator fun Point.times(scale: Double): Point {
    return Point((x * scale).toInt(), (y * scale).toInt())
}


//返回值类型可以不同
operator fun Char.times(cout: Int): String {
    return toString().repeat(cout)
}
