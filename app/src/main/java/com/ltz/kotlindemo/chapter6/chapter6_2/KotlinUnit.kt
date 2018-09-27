package com.ltz.kotlindemo.chapter6.chapter6_2

/**
 * Created by xiaowei on 2018/9/27
 * Kotlin Unit类型  对应java void类型
 */

fun print6_2_5() {
    val noRequestProcessor = NoRequestProcessor()
    noRequestProcessor.process()
}

//如果你的 Kotlin 函数使用 Unit 作为返回类型并且没有重写泛型函数，在底层它会被编译成旧的 void 函数。如果你要在 Java 代码中重写这个函数，新的 Java 函数需要返回 void
interface Processor<T> {
    fun process(): T
}


//只存在一个值是 Unit 类型，这个 值也叫作 Unit，并且(在函数中)会被隐式地返回。当你在重写返回泛型参数的 函数时这非常有用，只需要让方法返回 Unit 类型的值
class NoRequestProcessor : Processor<Unit> {
    //接口签名要求 process 函数返回一个值;而且，因为 Unit 类型确实有值，所以从方法中返回它并没有问题。
    override fun process() { //返回Unit，但可以省略类型说明
        //do stuff
        //这里不需要显式的return
        println("NoRequestProcessor show what is Unit")
    }
}