package com.ltz.kotlindemo.chapter5.chapter5_3

import com.ltz.kotlindemo.chapter5.chapter5_2.Person

/**
 * Created by xiaowei on 2018/8/13
 * 惰性集合操作  序列 避免创建临时列表
 */

val people = listOf(Person("xiaohong", 23),
        Person("xiaohua", 23),
        Person("jiaming", 15))
val people1 = listOf(Person("Alice", 29),
        Person("Bob", 31),
        Person("Charles", 31),
        Person("Dan", 21))

fun print5_3_1() {
    //会创建两个集合 及早执行
    people.map(Person::name).filter { it.startsWith("x") }

    //转换成序列
    println(people.asSequence()
            .map(Person::name)
            .filter { it.startsWith("x") }
            .toList())//如何不加tolist 则打印的是sequences对象 map filter操作不会执行，所以是惰性集合操作

    //map和filter将不会执行 没有打印
    listOf(1, 2, 3, 4).asSequence()
            .map { println("map $it");it * it }
            .filter { println("filter $it");it % 2 == 0 }


    //针对每个元素执行
    listOf(1, 2, 3, 4).asSequence()
            .map { println("map $it");it * it }//lambda 表达式中多个表达式用分号隔开
            .filter { println("filter $it");it % 2 == 0 }
            .toList()

    //集合 及早求值  所有元素都会进行map操作
    println(listOf(1, 2, 3, 4).map { it * it }.find { it > 3 })
    //序列 惰性求值 3，4不会执行map操作
    println(listOf(1, 2, 3, 4).asSequence().map { it * it }.find { it > 3 })


    //集合上操作的顺序也会影响执行的次数
    println(people1.asSequence().map(Person::name).filter { it.length < 4 }.toList())
    //先filter再map，filter过滤了的元素就不会进行map操作了
    println(people1.asSequence().filter { it.name.length < 4 }.map(Person::name).toList())

}