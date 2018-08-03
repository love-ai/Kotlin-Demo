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
    val klus = FackBookUser(123)
    println("klus's name is ${klus.name}")

    val wangjian = AliUer("wangjian")
    wangjian.address = "hangzhou xihu"

    val lengthCounter = LengthCounter()
    lengthCounter.addWord("xiaowei")
    lengthCounter.addWord("xiaoming")
    lengthCounter.addWord("lihua")
    lengthCounter.addWord("lili")
    lengthCounter.printAllLength()
}

//val 代表属性会用构造方法的参数来初始化  可设置默认值  两个字段都有默认值，则会自动生成一个无参数的构造函数
open class User(val nickname: String = "xiaowei", val isMarried: Boolean = false)

//同时可以在初始化子类时初始化父类   且父类的构造函数参数名-> 来自子类的参数名 不初始化调用默认构造函数也行
class WeiboUser(val weiboName: String, val isChinese: Boolean = true) : User(weiboName, isChinese) {}

//可以省略关键字 constructor 直接用参数实例化属性
// 这个时候参数列表就是在调用函数 而不是在定义属性
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


open class Button //会自动生成一个不带任何参数的构造方法
interface listener
//冒号表示继承和实现，这里必须要显式调用父类的构造方法
class RadioButton : Button(), listener

//被private 修饰的默认构造函数的类的外部代码不可以实例化他
class Secretive private constructor() {}


