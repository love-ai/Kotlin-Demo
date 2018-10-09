package com.ltz.kotlindemo.chapter7.chapter7_1

/**
 * Created by xiaowei on 2018/10/9
 * 重载复合赋值运算符
 */

fun print7_1_2() {
    var point = Point(1, 2)
    point += Point(3, 4)//+=只针对可变变量有效
    println(point)

    //在一些情况下，定义 += 运算可以修改使用它的变量所引用的对象，但不会重新分配引用
    val number = ArrayList<Int>()
    number += 42
    number.add(3)
    println(number[0])


    val list = arrayListOf(1, 2) //如果改为var 则编译器会报错
    list += 3//修改list
    val newList = list + listOf(4, 5)//不修改list返回一个包含所有元素的新列表
    println(list)
    println(newList)
}

//同一个包中的类只能定义一个同名的
//data class Point(val x: Int, val y: Int) {
//}


//返回值为Unit 名为plusAssign +=、minusAssign -=、timesAssign *= 会改变变量本身的值
//不要同时定义 plus和plusAssign 如果同时定义当调用+=时编译器会报错
//1.替换运算符为普通的函数调用 2.替换val为var plusAssigna运算就不适用
//根据对象是否是可变的，如果不可变就返回一个新值，如果可变就体统plusAssign类似的运算符

operator fun <T> MutableCollection<T>.plusAssign(element: T) {
    this.add(element)
}

operator fun <T> MutableCollection<T>.plus(element: T): MutableCollection<T> {
    this.add(element)
    return this
}








