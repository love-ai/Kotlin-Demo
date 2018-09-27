package com.ltz.kotlindemo.chapter6.chapter6_2

import com.ltz.kotlindemo.chapter6.chapter6_1.Address
import com.ltz.kotlindemo.chapter6.chapter6_1.Company

/**
 * Created by xiaowei on 2018/9/27
 * Nothing 函数永不返回
 */

fun print6_2_6() {

    val company = Company("ltz", Address("sanlitun", 110, "86", "chaoyang"))
    //返回 Nothing 的函数可以放在 Elvis 运算符的右边来做先决条件检查
    val address = company.address ?: fail("No address")
    //如果继续往下执行说明address不为null
    println(address.city)//这里不会报错

    fail("Error Occurred")

}

fun fail(message: String): Nothing {
    throw IllegalStateException(message)
}