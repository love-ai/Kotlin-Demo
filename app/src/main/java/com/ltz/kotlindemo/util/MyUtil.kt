@file:JvmName("StringFunctions")

//这个注解后Java可以直接调用该方法
package com.ltz.kotlindemo.util

/**
 * Created by xiaowei on 2018/7/31
 */
//使用这个注解会生成多个重载函数

var opCount = 0

fun preformOperation() {
    opCount++
}

fun reportOperationCount() {
    println("Operation performed $opCount  times")
}

//val UNIX_LINE_SEPARATOR = "\n"
const val UNIX_LINE_SEPARATOR = "\n"//等同于java中 public static final UNIX_LINE_SEPARATOR="\n"


@JvmOverloads
fun <T> joinToStringUtil(
        collection: Collection<T>,
        separator: String = ",",
        prefix: String = "",
        postfix: String = ""
): String {
    val result = StringBuilder(prefix)

    for ((index, element) in collection.withIndex()) {
        if (index > 0) result.append(separator)
        result.append(element)
    }
    result.append(postfix)
    return result.toString()
}

//扩展函数  接收者类型                    接收者对象
fun String.lastChar(): Char = this.get(this.length - 1)//事实上 把调用对象作为函数的第一个参数

fun String.lastCharWithOutThis(): Char = get(length - 1)//可以不加this


//扩展属性 不可被初始化
val String.lastChar: Char
    get() = get(length - 1)

var StringBuilder.lastChar: Char
    get() = get(length - 1)
    set(value: Char) {
        setCharAt(length - 1, value)
    }

