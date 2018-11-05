package com.ltz.kotlindemo.chapter7.chapter7_5


/**
 * Created by xiaowei on 2018/10/11
 *
 * class Foo{
 *     var p:Type by Delegate()
 * }
 * 使用委托属性
 * 惰性初始化 by lazy()
 *
 * lazy 函数返回一个对象，该对象具有一个名为 getValue 且签名正确的方法，因此可以把它与 by 关键字一起使用来创建一个委托属性。
 * lazy 的参数是一个 lambda，可以调用它来初始化这个值。
 * 默认情况下， lazy函数是线程安全的
 *
 */

fun print7_5_2() {
    val p = Person1("Alice")
    p.emails
    println("----")
    p.emails//不会打印
    println("----")
    p.email
}


class Email

fun loadEmails(person: Person1): List<Email> {
    println("Load email for ${person.name}")
    return listOf(Email())
}

class Person1(val name: String) {
    //支持属性技术 类似属性委托
    private var _emails: List<Email>? = null
    val emails: List<Email>
        get() {
            if (_emails == null) {
                _emails = loadEmails(this)
            }
            return _emails!!//非空断言
        }

    //实现上面的功能 懒加载 lazy是线程安全的
    val email by lazy { loadEmails(this) }
}
