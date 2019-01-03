package com.ltz.kotlindemo.chapter8.chapter8_3

/**
 * Created by xiaowei on 2019/1/3
 *  从Lambda返回 使用标签返回 类似于continue 而不是break
 */

fun print8_3_2() {
    val people = listOf(Person("xxx", 11), Person("Carl", 12), Person("xiaoming", 18), Person("huaw", 18))

//    lookForCarlUseLable(people)
    lookForCarlReturnByFunName(people)
}


//全部会打印 return 只是退出了当前循环
fun lookForCarlUseLable(people: List<Person>) {
    people.forEach lable1@{
        if (it.name == "Carl") {
            println("Carl is found")
            return@lable1
        } else {
            println("not carl")
        }
    }
    println("finish loop")
}

//不会打印Carl is found 其他的都会打印出来
fun lookForCarlReturnByFunName(people: List<Person>) {
    people.forEach {
        if (it.name == "Carl") {
            return@forEach
        }
        println("${it.name} is found")
    }
    println("finish loop")
}