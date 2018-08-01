package com.ltz.kotlindemo.chapter4.chapter4_1

/**
 * Created by xiaowei on 2018/8/1
 */

internal open class TalkativeButton : Focusable {
    private fun yell() = println("Hey!")
    protected fun whisper() = println("Let's talk!")
}
/*
//扩展函数不能访问 private 和protected成员
fun TalkativeButton.giveSpeech() {//需要定义为 internal 或 private 不能让TalkativeButton的可见性变大
    yell() //private 只能在类中可见
    whisper() //protected 在当前类和子类中可见
}
*/