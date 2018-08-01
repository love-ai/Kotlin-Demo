package com.ltz.kotlindemo.chapter4.chapter4_1

/**
 * Created by xiaowei on 2018/8/1
 */

abstract class Animated {
    abstract fun animate()

    open fun stopAnimate() {
    }

    //默认是final的
    fun animateTwice() {
    }
}