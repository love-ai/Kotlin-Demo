package com.ltz.kotlindemo.chapter6.chapter6_3

import java.io.BufferedReader
import java.io.StringReader

/**
 * Created by xiaowei on 2018/9/28
 * 可空性和集合 list<Int?> List<Int>?  List<Int?>? 三种的区别
 *
 */
fun print6_3_1() {
    val reader = BufferedReader(StringReader("1\nabc\n42"))
    val numbers = readNumbers(reader)
    addValidNumbers(numbers)
    addValidNumbers1(numbers)

}


fun readNumbers(reader: BufferedReader): List<Int?> {
    val result = ArrayList<Int?>()
    for (line in reader.lineSequence()) {
        try {
            val number = line.toInt()
            result.add(number)
        } catch (e: NumberFormatException) {
            result.add(null)
        }
    }
    return result
}


fun addValidNumbers(numbers: List<Int?>) {
    var sumOfValidNumbers = 0
    var invalidNumber = 0
    for (number in numbers) {
        if (number != null) {
            sumOfValidNumbers += number
        } else {
            invalidNumber++
        }
    }

    println("sum of valid number : $sumOfValidNumbers")
    println("invalid numbers : $invalidNumber")

}


fun addValidNumbers1(numbers: List<Int?>) {
    val number = numbers.filterNotNull()
    println("--sum of valid number : ${number.sum()}")
    println("--invalid numbers : ${numbers.size - number.size}")
}


