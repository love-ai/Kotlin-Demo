package com.ltz.kotlindemo.chapter4.chapter4_2

/**
 * Created by xiaowei on 2018/8/2
 */

interface NetUser {
    val nickname: String
    //有get() 可以被继承
    val name: String
        get() = nickname.plus(" Mikle")
    //interface 中不能只设置set 不设置get
//    var lastname: String


}

class PrivateUser(override val nickname: String) : NetUser {}

//在这里定义一个构造函数 val email 是一个属性
class SubscirbeUser(val email: String) : NetUser {
    override val nickname: String
        get() = email.substringBefore("@")
}

class FackBookUser(val accountId: Int) : NetUser {
    fun getFaceBookName(accountId: Int): String = "facebook$accountId"
    override val nickname: String
        get() = getFaceBookName(accountId)
}