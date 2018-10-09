package com.ltz.kotlindemo.chapter7.chapter7_2

/**
 * Created by xiaowei on 2018/10/9
 * 排序运算符 compareTo
 * a >= b  -->  a.compareTo(b) >= 0
 *
 */

fun print7_2_2() {
    val p1 = Person("Alice", "Smith")
    val p2 = Person("Bob", "Johnson")
    println(p1 < p2)
    println("abc" < "bac")//编译器可以直接判断出结果
}

class Person(val firstName: String, val lastName: String) : Comparable<Person> {
    override fun compareTo(other: Person): Int {
        return compareValuesBy(this, other, Person::firstName, Person::lastName)
    }
}