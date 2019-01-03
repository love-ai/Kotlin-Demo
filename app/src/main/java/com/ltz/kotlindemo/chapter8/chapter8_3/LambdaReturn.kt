package com.ltz.kotlindemo.chapter8.chapter8_3

/**
 * Created by xiaowei on 2019/1/3
 * lambda 中的返回语句:从一个封闭的函数返回
 */

fun print8_3_1() {
    val people = listOf(Person("Carl", 12), Person("xiaoming", 18))
//    lookForCarl(people)
    lookForCarlUseForEach(people)
}

fun lookForCarl(people: List<Person>) {
    for (person in people) {
        if (person.name.equals("Carl")) {
            println("found")
            return
        }
    }
    println("Carl is not found")
}

//它会从调用 lambda 的函数中返回， 并不只是从 lambda中返回

//只有在以 lambda 作为参数的函数是 **内联函数** 的时候才能从更外层的函数返回。

//在一个非内联 函数的 lambda 中使用 return 表达式是不允许的。
fun lookForCarlUseForEach(people: List<Person>) {
    people.forEach {
        if (it.name.equals("Carl")) {
            println("found")
            return
        }
    }
    println("Carl is not found")
}


data class Person(val name: String, val age: Int)