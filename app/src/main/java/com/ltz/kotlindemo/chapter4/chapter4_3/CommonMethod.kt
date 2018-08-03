package com.ltz.kotlindemo.chapter4.chapter4_3

/**
 * Created by xiaowei on 2018/8/2
 */

fun print4_3() {
    val client = Client("xiaowei", 100010)
    val client1 = Client("xiaowei", 100010)
    println(client.toString()) //默认是打印：com.ltz.kotlindemo.chapter4.chapter4_3.Client@deb7add
    println(client == client1)//两个对象不相等，== 会被编译成 equals 和java不同 java是比较饮用
    val processed = hashSetOf(Client("xiaoming", 432700))
    println(processed.contains(Client("xiaoming", 432700)))
}

class Client(val name: String, val postalCode: Int) {

    override fun equals(other: Any?): Boolean {
        if (other == null || other !is Client)
            return false
        return other.name == name && other.postalCode == postalCode
    }

    override fun toString(): String = "Client(name=$name, postalCode=$postalCode)"

    override fun hashCode(): Int = name.hashCode() * 37 + postalCode

    //data 类默认的copy函数 实现
    fun copy(name: String = this.name, postalCode: Int = this.postalCode) = Client(name, postalCode)
}

