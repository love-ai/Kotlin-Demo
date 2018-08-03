package com.ltz.kotlindemo.chapter4.chapter4_3

/**
 * Created by xiaowei on 2018/8/2
 */

fun print4_3_2() {
    val client = MyClient("xiaohua", 100080)
    val client1 = MyClient("xiaohua", 100080)
    val clientSet = hashSetOf(MyClient("lili", 100088))
    //使用data类之后 之前的 toString hashcode equals 方法将默认实现
    println(client.toString())
    println(client == client1)
    println(clientSet.contains(MyClient("lili", 100088)))

    //修改val 最好是创建对象的副本 data修饰之后添加了 copy方法
    val client2 = client.copy("xiaoming")
    println(client2.name)
}

data class MyClient(val name: String, val postCode: Int)