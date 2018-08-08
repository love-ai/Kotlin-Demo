package com.ltz.kotlindemo.chapter4.chapter4_4

/**
 * Created by xiaowei on 2018/8/3
 * 伴生对象
 */

fun print4_4_2() {
    //类似java中的静态函数
    println(A.bar())
    //需要创建对象，然后调用方法
    println(A().getValue())
    println("nickname is :${User("zxwei@twiter.com").nickname}")
    //类似单例模式 生成的fb1、fb2为C ompanionUser的子类 称为伴生对象成员
    val fb1 = CompanionUser.createFaceBookUser(144255366)
    val fb2 = CompanionUser.createFaceBookUser(144255366)
    println("nickname is :${fb1.nickname}")
    //kotlin in action 中说这里会判断id与唯一一个CompanionUser对象对应 但是就是对应不起来？？
    println(fb1)
    println(fb2)
    println(fb1.equals(fb2))//false
    println(fb1.equals(CompanionUser.createFaceBookUser(144255366)))//
    println(fb1 == fb2)//输出 uid=10494(u0_a494) com.ltz.kotlindemo identical 1 line
    println(fb1 === fb2)//false
}

class A {
    //companion object 需要同时出现，而且一个类中只能有一个 companion object 加名字区别也不行
    companion object {
        fun bar() {
            println("Companion object called")
        }
    }

    fun getValue(): Int = 1
}

//定义一个拥有多个构造方法的类
class User {
    val nickname: String

    constructor(email: String) {
        nickname = email.substringBefore("@")
    }

    constructor(facebookId: Int) {
        nickname = "facebookId:$facebookId"
    }
}

class CompanionUser private constructor(val nickname: String) {//主构造方法标记为私有

    //声明伴生对象
    companion object {
        //工厂方法
        fun createTwiterUser(email: String) =
                CompanionUser(email.substringBefore("@"))

        fun createFaceBookUser(fackbookId: Int) =
                CompanionUser("facebookId:$fackbookId")
    }
}

