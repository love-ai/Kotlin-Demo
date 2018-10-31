package com.ltz.kotlindemo.chapter7.chapter7_5

/**
 * Created by xiaowei on 2018/10/31
 *
 * map中保存属性值
 */

fun print7_5_5() {
    val s = Student()
    val data = mapOf("name" to "xiaowei_123", "school" to "xinhua")
    for ((attrName, value) in data) {
        s.setAttribute(attrName, value)
    }
    println(s.name)
}

class Student {
    private val _attribute = hashMapOf<String, String>()
    fun setAttribute(attrName: String, value: String) {
        _attribute[attrName] = value
    }

//    val name: String
//        get() = _attribute["name"]!!

    val name by _attribute//将map作为委托属性

}