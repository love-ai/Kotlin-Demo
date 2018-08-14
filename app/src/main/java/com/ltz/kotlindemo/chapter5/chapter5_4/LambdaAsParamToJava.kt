package com.ltz.kotlindemo.chapter5.chapter5_4

import com.ltz.kotlindemo.JavaCode.JavaTest

/**
 * Created by xiaowei on 2018/8/13
 * Lambda 当作参数传递给Java方法
 */


fun print5_4_1() {
    val javaTest = JavaTest()
    //多次调用只会生成一个Runnable实例
    javaTest.postponeComputation(1000) { println(42) }

    //通过显示的实现Runnable匿名对象 达到上面的效果 但是每次调用都会创建一个新的Runnable实例
    javaTest.postponeComputation(1000, object : Runnable {
        override fun run() {
            println(42)
        }
    })

}