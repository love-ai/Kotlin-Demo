package com.ltz.kotlindemo.chapter6.chapter6_1

import junit.framework.Assert
import org.junit.Before
import org.junit.Test


/**
 * Created by xiaowei on 2018/9/21
 * lateinit 延迟化加载 可以避免重复使用空检查
 * Kotiin 通常要求你在构造方法中初始化所有属性，如果某个属性是 非空类型，你就必须提供非空的初始化值。
 * 否则 ， 你就必须使用可空类型。如果你这样做，该属性的每一次访问都需要 null 检查或者 !! 运算符
 */

fun print6_1_8() {
    val myTest = MyTest()
    myTest.testAction()
}

class MyService {
    fun performAction(): String = "foo"
}

class MyTest {
    //    private var myService: MyService? = null
    private lateinit var myService: MyService

    @Before
    fun setUp() {
        myService = MyService()
    }

    @Test
    fun testAction() {
//        Assert.assertEquals("foo", myService?.performAction())
//        Assert.assertEquals("foo", myService!!.performAction())
        Assert.assertEquals("foo", myService.performAction())
    }

}