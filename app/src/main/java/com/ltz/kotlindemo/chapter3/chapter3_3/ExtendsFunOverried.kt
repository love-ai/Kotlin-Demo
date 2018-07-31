package com.ltz.kotlindemo.chapter3.chapter3_3

/**
 * Created by xiaowei on 2018/7/31
 */

//要被集成需要 open
open class View {
    //要被重写需要 open 成员函数会优先使用
    open fun click() = println("View clicked")
}

fun View.showOff() = println("I'm a View")

class Button : View() {
    override fun click() = println("Button clicked")
}

fun Button.showOff() = println("I'm a Button")


//如果后期增加了相同的成员函数，会进行重新编译，该方法将不被调用
fun View.click() = println("view 的 click 同名扩展函数")