package com.ltz.kotlindemo.chapter6.chapter6_1

/**
 * Created by xiaowei on 2018/8/29
 */

fun print6_1_4() {

    println(strLenCanBeNull(null))
    println(strLenCanBeNull("2ad3s(*"))

    val address = Address("Elsestr. 47", 80687, "Munich", "Germany")
    val jetbrains = Company("jetBrains", address)
    val person = Person("Dmitry", jetbrains)
    printShippingLable(person)
    printShippingLable(Person("xiaowei", null))
}

fun strLenCanBeNullElvis(s: String?) = s?.length ?: 0 // ?. 和 ?: 同时使用

fun Person.countryNameElvis(): String? {
    return company?.address?.country ?: "Unknow"
}

fun printShippingLable(person: Person) {
    val address = person.company?.address ?: throw IllegalStateException("No address")
    with(address) {
        println(streetAddress)
        println("$zipCode $city, $country")
    }
}
