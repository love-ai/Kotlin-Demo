package com.ltz.kotlindemo.chapter6.chapter6_3

/**
 * Created by xiaowei on 2018/9/29
 */

fun print6_3_5() {
    val letter = Array(26) { i -> ('a' + i).toString() }
    println(letter.joinToString(""))


    val strings = listOf("a", "b", "c")
    println("%s/%s/%s".format(*strings.toTypedArray()))//期望vararg（可变参数）时使用展开运算符（*）传递数组

    //数纽类型的类型参数始终会变成对象类型  Array<Int> 对应Java java.lang.Integer[]
    //IntArray->int[]   ByteArray->byte[]   CharArray->char[]

    //下面是创建存储5个0的整形数组的两种方式
    val fiveZero = IntArray(5)

    println(fiveZero.joinToString())

    val fiveZeroToo = intArrayOf(0, 0, 0, 0)
    val squares = Array(5) { i -> (i + 1) * (i + 1) }
    println(squares.joinToString())

    //调用main函数
    main(letter)
}


fun main(args: Array<String>) {
    for (i in args.indices) {
        println("Arguments $i is :${args[i]}")
    }

    // Kotlin 标准库支持一套和集合相同的用于数组的扩展函数。
    // 第 5 章中你看到的全部函数( filter、 map 等)也适用于数组，
    // 包括基本数据类型的数组(注意，这些方法的返回值是列表而不是数组)。
    args.forEachIndexed { index, element -> println("Argument $index is: $element") }
}

