package com.ltz.kotlindemo.chapter8.chapter8_2

/**
 * Created by xiaowei on 2018/12/25
 * 内联集合操作
 */

fun print8_2_3() {
    val people = listOf(Person("xiaohong", 22), Person("xiaowei", 18))
    //这只在处理大量数据的集合时有用，小的集合可以用 普通的集合操作处理。
    println(people.filter { it.age > 20 }.map { it.name })

    val result = mutableListOf<Person>()
    for (person in people) {
        if (person.age > 16) {
            result.add(person)
        }
    }
    println(result)
}

data class Person(val name: String, val age: Int)
