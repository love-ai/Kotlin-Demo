package com.ltz.kotlindemo.chapter8.chapter8_2

import java.util.concurrent.locks.Lock

/**
 * Created by xiaowei on 2018/12/25
 * 什么是内联函数 及内联函数的限制
 */

fun print8_2_1() {
//    val l = Lock()
//    synchronized(l) {}


}

inline fun <T> synchronized1(lock: Lock, action: () -> T): T {
    lock.lock()
    try {
        return action()
    } finally {
        lock.unlock()
    }
}

fun foo(l: Lock) {
    println("Before sync")
    synchronized(l) {
        println("Action")
    }
    println("After sync")
}


/**
 * 一般来说，参数如果被直接调用或者作为参数传递给另外一个 inline 函数， 它是可以被内联的 。否则，编译器会禁止参数被内联并给出错误信息“ Illegal usage of inline-parameter”(非法使用内联参数)。
 */


//fun <T, R> Sequence<T>.map(transform: (T) -> R): Sequence<R> {
//    return TransformingSequence(this, transform)
//}


//noinline关键字
inline fun foo1(inlined: () -> Unit, noinline notInlined: () -> Unit) {

}