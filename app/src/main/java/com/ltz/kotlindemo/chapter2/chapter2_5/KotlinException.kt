package com.ltz.kotlindemo.chapter2.chapter2_5

import java.io.BufferedReader

/**
 * Created by xiaowei on 2018/7/27
 * kotlin 异常
 */

fun readNumber(reader: BufferedReader): Int? {//加？表示可为null
    try {
        val line = reader.readLine()
        return Integer.parseInt(line)
    } catch (e: NumberFormatException) {
        return null
    } finally {
        reader.close()
    }

}

//try 表达式
fun readNumber2(reader: BufferedReader) {
    val number = try {
        Integer.parseInt(reader.readLine())
    } catch (e: NumberFormatException) {
        null
    }
    println(number)
}