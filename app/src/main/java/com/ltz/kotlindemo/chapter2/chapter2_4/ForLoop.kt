package com.ltz.kotlindemo.chapter2.chapter2_4

import java.util.*

/**
 * Created by xiaowei on 2018/7/27
 */

fun fizzBuzz(i: Int) = when {
    i % 15 == 0 -> "FizzBuzz"
    i % 5 == 0 -> "Buzz"
    i % 3 == 0 -> "Fizz"
    else -> i
}


fun printFizzBuzz() {
//包含结束值
//    for (i in 1..100) {
//        println("${fizzBuzz(i)}")
//    }

    //会自动提示转换
    val size = 100
    for (i in 1..size - 1) {
        println("${fizzBuzz(i)}")
    }
    //等价于size-1
    for (i in 1 until size) {
        println("${fizzBuzz(i)}")
    }

}

//step 每次的步长

fun printFizzBuzzStepDown() {
    var result = ""
    for (i in 100 downTo 1 step 2) {
        result += "${fizzBuzz(i)}  "
    }
    println(result)
}

//遍历map
fun printTreeMap() {
    val binaryReps = TreeMap<Char, String>()
    for (c in 'A'..'F') {//这里in 后面可以是字符或者数字，这里不可以是String
        val binary = Integer.toBinaryString(c.toInt())
        binaryReps[c] = binary
    }
    for ((key, value) in binaryReps) {
        println("$key = $value")
    }
}

//自动创建index 的遍历
fun printList() {
    val list = arrayListOf("10", "11", "1001")//kotlin方法自动识别类型
    for ((index, element) in list.withIndex()) {
        println("$index = $element")
    }
}

//关于in 检查集合和区间的成员
fun isLetter(c: Char) = c in 'a'..'z' || c in 'A'..'Z'

fun isNotDigital(c: Char) = c !in '0'..'9'

//in 同样适用与kotlin表达式
fun recognize(c: Char) = when (c) {
    in 'a'..'z', in 'A'..'Z' -> {
        println("Kotlin" in "Java".."Scala")
        println("Kotlin" in setOf("Java", "Scala"))
        "is letter"
    }
    in '0'..'9' -> "is digital"
    else -> "I don't know"
}