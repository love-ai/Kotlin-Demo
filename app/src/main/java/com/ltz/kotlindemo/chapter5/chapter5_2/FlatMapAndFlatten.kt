package com.ltz.kotlindemo.chapter5.chapter5_2

/**
 * Created by xiaowei on 2018/8/13
 * flatMap flatten  处理嵌套集合中的元素
 */

class book(val title: String, val authors: List<String>)


fun print5_2_4() {
    val strings = listOf("abc", "dbf")
    println(strings[0].toList())
    //flatMap 将多个集合平铺在一起  并不会剔除多余的元素
    println(strings.flatMap { it.toList() })

    val books = listOf(book("a brief history of time", listOf("stephen hocking")),
            book("Thursday Next", listOf("Jasper Fforde")),
            book("Mort", listOf("Terry Pratchett")),
            book("Good Omens", listOf("Terry Pratchett", "Neil Gaima")))

    println(books.flatMap { it.authors }.toSet())//toSet()移除重复元素

    //listOfLists.flatten() 这个函数没有找到


}