package com.ltz.kotlindemo.chapter6.chapter6_2

/**
 * Created by xiaowei on 2018/9/27
 * Kotlin 数字转换
 */

fun print6_2_3() {
    val i = 1
    val j: Long = i.toLong()//转换函数
    val list = listOf(1L, 2L, 3L)
    //i in list kotlin 不支持隐式转换 就算支持也是false 类型不同
    println(j in list)//类型相同 编译器通过

    //基本数据类型字面值
    val mLong = 123L.toInt()//这里必须是L 这个时候一样可以调用转换函数
    val mDouble = 123.1//默认double类型
    val mFloat = 13.14F //float类型或者f
    val mHex = 0xbcd//十六进制
    val mByte = 0b001//代表二进制
    val mInt = '1'//字符字面值 '\t'  '\u0009' Unicode转义表示制表符
    println(mHex.javaClass)//int
    println(mByte.javaClass)//int


    val b: Byte = 1 //常量有正确的类型
    val l = b + 1L // + 可以进行字节类型好长整型类型参数的计算
    foo(42)//编译器认为42是一个长整型


    //字符串转换
    println("34".toInt())
    println("9".toDouble())
    println("130".toByte())//这里会出现NumberFormateException java.lang.NumberFormatException: Value out of range. Value:"130" Radix:10

}

fun foo(l: Long) = println(l)