package com.ltz.kotlindemo.chapter6.chapter6_2

/**
 * Created by xiaowei on 2018/9/27
 * Any 和 Any? 根类型 : 所有非空类型的超类型 包括基本数据类型
 */
fun print6_2_4() {
    val answer: Any = Any()//Any是引用类型所以42会被装箱
    //Any是非空的，所以Any类型的变量不可以持有null值
    //在 Kotlin 中如果你需要可以持有任何可能值的变量，包括 null 在内，必须使用 Any?类型
    val all: Any? = null
    println(answer.javaClass)// class java.lang.Object
}