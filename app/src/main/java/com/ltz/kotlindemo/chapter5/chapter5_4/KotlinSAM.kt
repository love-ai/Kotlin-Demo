package com.ltz.kotlindemo.chapter5.chapter5_4

/**
 * Created by xiaowei on 2018/8/14
 * SAM 构造方法 显式的将lambbda转换成函数接口
 */

fun print5_4_2() {
    createAllDoneRunnable().run()

}

fun createAllDoneRunnable(): Runnable {
    return Runnable { println("All done!") }
}