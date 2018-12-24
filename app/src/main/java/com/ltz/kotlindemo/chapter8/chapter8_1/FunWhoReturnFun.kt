package com.ltz.kotlindemo.chapter8.chapter8_1

/**
 * Created by xiaowei on 2018/11/8
 * 返回函数的函数
 */

fun print8_1_5() {
    val calculator = getShippingCostCalculator(Delivery.EXPEDITED)
    println("shipping costs ${calculator(Order(3))}")


    val contacts = listOf(Person("Dmitry", "Jemerov", "1230-323"),
            Person("xiaohong", "xiaoming"),
            Person("Dmast", "slow", "man"),
            Person("xiao", "wei", "222-333"),
            Person("Dmitrr", "xiao"))
    val contactListFilters = ContactListFilters()
    with(contactListFilters) {
        prefix = "Dm"
        onlyWithPhoneNumber = true
    }
    println(contacts.filter(contactListFilters.getpredicate()))

    with(contactListFilters) {
        prefix = "xi"
        onlyWithPhoneNumber = false
    }

    println(contacts.filter(contactListFilters.getpredicate()))
}

enum class Delivery { STANDARD, EXPEDITED }
class Order(val itemCount: Int)

fun getShippingCostCalculator(delivery: Delivery): (Order) -> Double {
    if (delivery == Delivery.STANDARD) {
        return { order -> order.itemCount * 1.2 }
    }
    return { order -> 6 + order.itemCount * 2.1 }
}


data class Person(
        val firstName: String,
        val lastName: String,
        val phoneNumber: String? = null
)

class ContactListFilters {
    var prefix: String = ""
    var onlyWithPhoneNumber: Boolean = false
    fun getpredicate(): (Person) -> Boolean {
        val startWithPrefix = { p: Person -> p.firstName.startsWith(prefix) || p.lastName.startsWith(prefix) }
        if (!onlyWithPhoneNumber) {
            return startWithPrefix
        }
        return { startWithPrefix(it) && it.phoneNumber != null } //这个地方是return 能够自动推断出类型，所以可以使用it
    }
}
