package com.ltz.kotlindemo.chapter6.chapter6_1

/**
 * Created by xiaowei on 2018/9/17
 * let
 */

fun print6_1_7() {
    val email: String? = "hello xiaohong"
    if (email != null) sendEmailTo(email)
    email?.let { sendEmailTo(it) }


    //这个时候使用let不用多创建一个变量
    val person: Person? = getTheBestPersonInWord()
    if (person != null) sendEmailTo(person.name)

    getTheBestPersonInWord()?.let { sendEmailTo(it.name) }
}

fun sendEmailTo(email: String) {
    println("send email to $email")
}

fun getTheBestPersonInWord(): Person? = null