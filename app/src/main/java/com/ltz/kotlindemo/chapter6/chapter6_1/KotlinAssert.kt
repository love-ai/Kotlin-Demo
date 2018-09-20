package com.ltz.kotlindemo.chapter6.chapter6_1

/**
 * Created by xiaowei on 2018/9/17
 * Kotlin 断言
 */

fun print6_1_6(){
   ignoreNulls(null)
}

fun ignoreNulls(s:String?){
    val sNotNull:String=s!!//这一行就会报错 kotlin.KotlinNullPointerException
    println(sNotNull)
}