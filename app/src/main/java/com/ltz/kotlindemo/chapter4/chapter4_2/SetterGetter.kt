package com.ltz.kotlindemo.chapter4.chapter4_2

/**
 * Created by xiaowei on 2018/8/2
 */

class AliUer(val name: String) {
    var address: String = "undefined"
        set(value: String) {
            println("""
                Address was changed form $name :
                "$field" -> "$value".""".trimIndent())
            field = value
        }
}

//修改setter getter的可见行

class LengthCounter {
    var counter: Int = 0
        private set

    fun addWord(word: String) {
        counter += word.length
    }

    fun printAllLength() = println("all length : $counter")
}