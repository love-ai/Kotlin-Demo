package com.ltz.kotlindemo.chapter5.chapter5_2

/**
 * Created by xiaowei on 2018/8/10
 * 集合的Filter和Map的用法
 */
data class Person(val name: String, val age: Int, val address: String="")

val people = listOf(Person("xiaohong", 23, "hubei"),
        Person("xiaohua", 23, "shanghai"),
        Person("xiaoming", 15, "beijing"))

fun print5_2_1() {
    val list = listOf(0, 1, 2, 3, 4, 5, 6, 7, 8, 9)
    println(list.filter { it % 2 == 0 })
    println(list.dropWhile { it / 2 == 0 })


    //过滤年龄大于18岁的人
    println(people.filter { it.age > 18 })

    //只有单个元素，对该元素进行变换
    println(list.map { it * it })

    //这个目前只能保留一个字段
    println(people.map { it.name })
    //成员引用版本
    println(people.map(Person::name))

    //打印年龄超过20岁的人的名字
    println(people.filter { it.age > 20 }.map { it.name })

    //找到所有年龄最大的人的名字
    val maxAge = people.maxBy { it.age }?.age//这个地方可能为null
    println(people.filter { it.age == maxAge })
    println(people.map { it.name.toUpperCase() })


    val numbers = mapOf(1 to "one", 2 to "two")
    println(numbers.mapValues { it.value.toUpperCase() })
    println(numbers.mapKeys { it.key + 1 })
    println(numbers.filterValues { it in "one" })
    println(numbers.filterKeys { it > 1 })

}