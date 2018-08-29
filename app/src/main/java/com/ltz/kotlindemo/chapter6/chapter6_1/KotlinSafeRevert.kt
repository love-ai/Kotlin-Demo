package com.ltz.kotlindemo.chapter6.chapter6_1

/**
 * Created by xiaowei on 2018/8/29
 */

fun print6_1_5() {

    val s1 = Student("xiao", "hong")
    val s2 = Student("xiao", "hong")
    println(s1 == s2)
    println(s1.equals(s2))

}

class Student(val firstName: String, val lastName: String) {
    override fun equals(o: Any?): Boolean {
        val otherStudent = o as? Student ?: return false
        return o.firstName == firstName  && o.lastName == lastName
    }

    override fun hashCode(): Int = firstName.hashCode() * 37 + lastName.hashCode()
}

