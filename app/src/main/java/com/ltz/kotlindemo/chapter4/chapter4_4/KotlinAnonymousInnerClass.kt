package com.ltz.kotlindemo.chapter4.chapter4_4

/**
 * Created by xiaowei on 2018/8/6
 * 对象表达式
 */

fun print4_4_4() {
    //object 声明匿名对象 代替类java中匿名内部类
    val listener = object : MouseAdapter {
        override fun mouseClicked() {

        }

        override fun mouseEnterd() {

        }
    }
}

fun countClicks(window: Window) {
    var clickCount = 0 //声明局部变量
    window.addMouseListener(object : MouseAdapter {
        override fun mouseClicked() {
            clickCount++ //直接更新变量的值，不用像 java定义成final
        }

        override fun mouseEnterd() {
            //...
        }
    })

}

interface MouseAdapter {
    fun mouseClicked()
    fun mouseEnterd()
}

class Window(val name: String) {
    fun addMouseListener(listener: MouseAdapter) {
    }
}