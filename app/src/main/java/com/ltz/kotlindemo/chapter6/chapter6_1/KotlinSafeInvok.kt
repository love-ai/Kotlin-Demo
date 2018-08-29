package com.ltz.kotlindemo.chapter6.chapter6_1

/**
 * Created by xiaowei on 2018/8/16
 * kotlin 安全调用
 */

fun print6_1_3() {
    //可空类型调用 方法
    printAllCaps("abc")
    printAllCaps(null)

    //安全调用 属性
    val ceo = Employee("zhanglei", null)
    val developer = Employee("Bob Smith", ceo)
    val assistent = Employee("xiaoming", developer)
    println(managerName(ceo))
    println(managerName(developer))
    println(managerName(assistent))

    //连续安全调用
    val person = Person("xiaohua", null)
    println(person.countryName())
}

fun printAllCaps(s: String?) {
    val allCaps: String? = s?.toUpperCase()
    println(allCaps)
}

class Employee(val name: String, val manager: Employee?)//这时候？放在类型的后面

fun managerName(employee: Employee): String? = employee.manager?.name


class Address(val streetAddress: String, val zipCode: Int, val city: String, val country: String)
class Company(val name: String, val address: Address?)
class Person(val name: String, val company: Company?)

fun Person.countryName(): String? {
    val country= this.company?.address?.country
    return if(country!=null) country else "Unknow"
}