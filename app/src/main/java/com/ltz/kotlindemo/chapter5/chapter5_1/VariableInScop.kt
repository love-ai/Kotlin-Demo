package com.ltz.kotlindemo.chapter5.chapter5_1

/**
 * Created by xiaowei on 2018/8/9
 * 作用域中访问变量
 */

fun print5_1_4() {
    val errors = listOf("403 Forbidden", "404 Not Found")
    println(printMessageWithPrefix(errors, "Error"))

    val response = listOf("200 OK", "418 I'm a teapot", "403 Forbidden", "404 Not Found",
            "505 Http version do not support", "500 Internal Server Error")
    printProblemsCount(response)
}


fun printMessageWithPrefix(message: Collection<String>, prefix: String) {
    message.forEach {
        println("$prefix $it")
    }
}

fun printProblemsCount(message: Collection<String>) {
    //
    var clientCount = 0
    var serverCount = 0
    message.forEach {
        if (it.startsWith("4")) {
            clientCount++
        } else if (it.startsWith("5")) {
            serverCount++
        }
    }
    println("ClientError count is: $clientCount ServerError Count is $serverCount")
}
