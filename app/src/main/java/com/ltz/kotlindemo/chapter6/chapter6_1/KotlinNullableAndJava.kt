package com.ltz.kotlindemo.chapter6.chapter6_1

import com.ltz.kotlindemo.JavaCode.Person
import com.ltz.kotlindemo.JavaCode.StringProcessor

/**
 * Created by xiaowei on 2018/9/25
 * kotlin和java的可空性 平台类型
 */

fun print6_1_11() {
    yellAt(Person(null))
    val person = Person("xiaowei")
    val s: String? = person.name //平台类型 被解释为可空的
    val s1: String = person.name //平台类型 被解释为非空的

    val stringprinter = StringPrinter()
    stringprinter.process("xiaowei")

    val nullableStringProcessor = NullableStringProcessor()
    nullableStringProcessor.process(null)
}

fun yellAt(person: Person) {
    println((person.name ?: "AnyOne").toUpperCase())
//    println(person.name.toUpperCase())
}


class StringPrinter : StringProcessor {
    override fun process(value: String) {
        println(value)
    }
}

class NullableStringProcessor : StringProcessor {
    override fun process(value: String?) {
        println(value ?: "null")
    }
}