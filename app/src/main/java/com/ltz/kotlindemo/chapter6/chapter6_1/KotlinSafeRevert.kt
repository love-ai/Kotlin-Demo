package com.ltz.kotlindemo.chapter6.chapter6_1

/**
 * Created by xiaowei on 2018/8/29
 */

fun print6_1_5() {

    val s1 = Student("xiao", "hong")
    val s2 = Student("xiao", "hong")
    println(s1 == s2)//true ==运算符会调用equals方法
    println(s1.equals(s2))//true
    println(s1.equals(34))//true
}

class Student(val firstName: String, val lastName: String) {
    override fun equals(o: Any?): Boolean {
        val otherStudent = o as? Student ?: return false
        return otherStudent.firstName == firstName  && otherStudent.lastName == lastName
    }

    override fun hashCode(): Int = firstName.hashCode() * 37 + lastName.hashCode()
}

