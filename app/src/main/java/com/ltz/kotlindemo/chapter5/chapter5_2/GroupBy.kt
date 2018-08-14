package com.ltz.kotlindemo.chapter5.chapter5_2

/**
 * Created by xiaowei on 2018/8/13'
 *  groupBy 将列表转换成分组的map
 */

fun print5_2_3() {
    val people = listOf(Person("xiaohong", 23),
            Person("xiaohua", 15),
            Person("xiaoming", 15))

    //执行之后类似Map<Int,List<Person>>
    println(people.groupBy { it.age })

    val list = listOf("a", "ab", "ba", "bc", "ca")

    //String::first是String的一个扩展 并不是其成员
    println(list.groupBy(String::first))


}