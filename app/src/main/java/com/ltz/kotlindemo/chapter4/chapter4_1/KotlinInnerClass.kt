package com.ltz.kotlindemo.chapter4.chapter4_1

import java.io.Serializable

/**
 * Created by xiaowei on 2018/8/1
 */

interface State : Serializable

interface MyView {
    fun getCurrentState(): State
    fun restoreState(state: State) {}
}

class MyButton : MyView {
    //不同被定义为Button redeclearation 重复声明
    override fun getCurrentState(): State = ButtonState()

    override fun restoreState(state: State) {}
    class ButtonState : State {/*...*/ }

}

class Outer {
    val name = "outerclass"

    inner class inner {
        fun print() {
            println(name)
            println(this@Outer.name)
        }
        fun getOuterReference(): Outer = this@Outer
    }
}