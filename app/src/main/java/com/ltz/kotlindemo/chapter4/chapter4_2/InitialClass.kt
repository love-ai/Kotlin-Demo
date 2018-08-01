package com.ltz.kotlindemo.chapter4.chapter4_2

/**
 * Created by xiaowei on 2018/8/1
 */

fun print4_2() {
    val alice = User("Alice")//如果所有参数都有默认值，则编译器会自动创建一个没有参数的构造函数
    val bob = User("Bob", true)
    val xiena = WeiboUser("XieNa", true)
    println("xiena isMarried:${xiena.isMarried}")
    println("xiena name:${xiena.weiboName}")
    println(alice.isMarried)
    println(alice.isMarried)
}

//val 代表属性会用构造方法的参数来初始化  可设置默认值
open class User(val nickname: String = "xiiaowei", val isMarried: Boolean = false)

//同时可以在初始化子类时初始化父类   且父类的构造函数参数名-> 来自子类的参数名
class WeiboUser(val weiboName: String, val isChinese: Boolean = true) : User(weiboName, isChinese) {}

//可以省略关键字 constructor 直接用参数实例化属性
class User1(_nickname: String) {
    val nickname = _nickname
}

//构造方法
class User2 constructor(_nickname: String) {
    val nickname: String

    //初始化语句块
    init {
        nickname = _nickname
    }
}


open class Button {}
interface listener
//java should use extends and implements
class RadioButton : Button(), listener

class Secretive private constructor() {}

