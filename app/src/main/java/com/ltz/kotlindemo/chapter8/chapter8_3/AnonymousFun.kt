package com.ltz.kotlindemo.chapter8.chapter8_3

/**
 * Created by xiaowei on 2019/1/3
 * 匿名函数 默认局部返回
 *
 * return从最近的使用 fun关键字声明的函数返回。 lambda表达式没有使用fun关键字，所以lambda中的return从最外层的函数返回。
 */

fun print8_3_3() {
    val people = listOf(Person("xxx", 11), Person("Carl", 12), Person("xiaoming", 18), Person("huawei", 18))

//    lookForHuaWei(people)

//    println(people.filter(fun(person): Boolean {
//        return person.age < 15
//    }))

    println(people.filter(fun(person) = person.age >  15))
}

fun lookForHuaWei(people: List<Person>) {
    people.forEach(fun(person) {
        if (person.name == "huawei") return
        println("${person.name} is not HuaWei")
    })
}