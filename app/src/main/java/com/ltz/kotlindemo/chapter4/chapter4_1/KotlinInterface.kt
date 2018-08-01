package com.ltz.kotlindemo.chapter4.chapter4_1

/**
 * Created by xiaowei on 2018/8/1
 */

fun print4_1() {
    val button = Button()
    button.showOff()
    button.setFocus(true)
    button.click()

}

interface Clickable {
    fun click()//这里不能加final 加上open是多余的
    fun showOff() = println("I'm Clickable")//接口中函数可以实现，且可以定义多个有实现的函数
}

interface Focusable {
    fun setFocus(b: Boolean) =
            println("I ${if (b) "got" else "lose"} focus.")

    fun showOff() = println("I'm Focusable")
}

class Button : Clickable, Focusable {
    //如果相同的继承成员又不止一个实现，必须提供一个显式的实现
    override fun showOff() {
        //调用对应父类的方法
        super<Clickable>.showOff()
        super<Focusable>.showOff()
    }

    override fun click() = println("I was clicked")
}


open class RichButton : Clickable {
    //没有final 的override就是open的 如果不想被重写可以 显式的 加上final
    override fun click() {}//

    fun disable() {}//不能再子类中重写

    open fun animate() {}//可以再子类中重写
}

