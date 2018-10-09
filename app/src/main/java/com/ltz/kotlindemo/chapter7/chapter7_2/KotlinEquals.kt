package com.ltz.kotlindemo.chapter7.chapter7_2

/**
 * Created by xiaowei on 2018/10/9
 * 重载一元运算符
 * a == b  -->  a?.equals(b)?:(b == null)
 *
 * === 比较是否是同一个对象 运算符不能被重载
 * equals 不能实现为扩展函数，因为继承自 Any 类的实现始终优先于扩展函数
 */

fun print7_2_1() {
    val p: Point1? = null
    println(Point1(10, 20) === Point1(10, 20))//false
    println(Point1(10, 20) == Point1(10, 20))//true 将会调用equals方法比较
    println(Point1(11, 20) != Point1(10, 20))//true 将自动调用equals方法然后取反
    println(p == Point1(1, 2))//false
}

class Point1(val x: Int, val y: Int) {
    override fun equals(other: Any?): Boolean {
        if (other === this) return true
        if (other !is Point1) return false
        return other.x == x && other.y == y
    }
}