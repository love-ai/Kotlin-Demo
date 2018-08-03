package com.ltz.kotlindemo.chapter4.chapter4_4

/**
 * Created by xiaowei on 2018/8/3
 */

fun print4_4_3() {
    val person = Person.Loader.fromJSON("xiaowei")
    val person2 = Person.fromJSON("xiaohong")

    //函数使用抽象方法加载实体，直接传入Person对象
    loadFromJson(Person)

}


interface JSONFactory<T> {
    fun fromJSON(jsonText: String): T
}


class Person(val name: String) {
    //伴生对象中实现接口
    companion object Loader : JSONFactory<Person> {
        override fun fromJSON(jsonText: String): Person = Person(jsonText)
    }
}


fun <T> loadFromJson(factory: JSONFactory<T>): T {
    return factory.fromJSON("s")
}