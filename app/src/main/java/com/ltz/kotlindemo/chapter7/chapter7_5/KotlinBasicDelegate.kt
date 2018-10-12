package com.ltz.kotlindemo.chapter7.chapter7_5


/**
 * Created by xiaowei on 2018/10/11
 *
 * class Foo{
 *     var p:Type by Delegate()
 * }
 * 惰性初始化 by lazy()
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
    private var _emails: List<Email>? = null
    val emails: List<Email>
        get() {
            if (_emails == null) {
                _emails = loadEmails(this)
            }
            return _emails!!//非空断言
        }

    //实现上面的功能
    val email by lazy { loadEmails(this) }
}
