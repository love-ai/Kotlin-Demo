package com.ltz.kotlindemo.chapter6.chapter6_2

/**
 * Created by xiaowei on 2018/9/26
 * kotlin 基本的可空数据类型
 */

fun print6_2_2() {
    println(Person("sam", 34).isOlderThan(Person("xia", 20)))
    println(Person("sam", 34).isOlderThan(Person("xia")))
    //Integer包装类的列表 而不是基本数据类型 这样效率就不会很高
    //假如你要高效地存储基本数据类型元素的大型集合，要么使用支持这种集合的第三 方库(如 Trove4J)，要么使用数组来存储
    val listOfInts = listOf(1, 3, 2)
}


data class Person(val name: String, val age: Int? = null) {
    fun isOlderThan(other: Person): Boolean? {
        if (age == null || other.age == null) {
            return null
        }
        return age > other.age//这里必须检查不为null之后才可以比较
    }
}
