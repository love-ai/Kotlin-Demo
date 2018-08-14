package com.ltz.kotlindemo.chapter5.chapter5_5

/**
 * Created by xiaowei on 2018/8/14
 * 带接收者的lambda with
 */

fun print5_5_1() {
    println(alphabet())

    println(A().alphabetWithSimple())
}

fun alphabet(): String {
    val result = StringBuilder()
    for (letter in 'A'..'Z') {
        result.append(letter)
    }
    result.append("\nNow I know the Alphabet!")
    return result.toString()
}

fun alphabetWith(): String {
    val result = StringBuilder()
    return with(result) {
        for (letter in 'A'..'Z') {
            this.append(letter)
        }
        //这个地方可以省略this
        append("\nNow I know the Alphabet!")
        //最后一行就是返回值
        this.toString()
    }
}

class A {
    fun alphabetWithSimple() = with(StringBuilder()) {
        for (letter in 'A'..'Z') {
            append(letter)
        }
        append("\nNow I know the Alphabet!")
        //当遇到方法名冲突的时候调用外部类的方法
        println(this@A.toString())
        //可省略this
        toString()
    }


    override fun toString() = "123"
}


