package com.ltz.kotlindemo.chapter7.chapter7_4

import com.ltz.kotlindemo.chapter7.chapter7_1.Point

/**
 * Created by xiaowei on 2018/10/11
 * 解构声明和组建函数
 * val(a,b)= p 会调用如下两个方法
 * val a = p.component1()
 * val b = p.component2()
 */

fun print7_4() {
    val p = Point(10, 20)
    val (x, y) = p //声明变量x,y 然后用p的组件来初始化
    println("($x , $y)")
    val (name, ext) = splitFileName("xiaowei.kt")
    println("name = $name,extension: $ext")
}

//数据类会自动生成componentN函数
data class NameComponents(val name: String, val extension: String)

//返回data class
fun splitFileName(fullName: String): NameComponents {
//    val result = fullName.split(".", limit = 2)
    val (name, ext) = fullName.split(".", limit = 2)//数组和集合中也是有componentN函数
    return NameComponents(name, ext)
}