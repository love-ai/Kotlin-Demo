package com.ltz.kotlindemo.chapter6.chapter6_1

import com.ltz.kotlindemo.chapter5.chapter5_1.Person
import com.ltz.kotlindemo.chapter5.chapter5_1.sendEmail

/**
 * Created by xiaowei on 2018/9/21
 * 可空类型的扩展
 */

fun print6_1_9() {
    verifyUserInput(null)
    verifyUserInput(" ")
    verifyUserInput("abc")

    person?.let { sendEmail(it, it.name) }//这里还是会自动判断null加上?.安全调用
}


fun verifyUserInput(input: String?) {
    if (input.isNullOrBlank()) { //不需要安全调用就可以访问可空类型的扩展
        println("Please fill in the required fields")
    }
    if (input.isNullOrBlank1()) {
        println("Please fill in the required fields1")
    }
}

//可空类型定义拓展函数
fun String?.isNullOrBlank1(): Boolean =
        this == null || this.isBlank()

val person: Person? = null

