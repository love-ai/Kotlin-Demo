package com.ltz.kotlindemo.chapter5.chapter5_1

/**
 * Created by xiaowei on 2018/8/10
 * 成员引用
 */

val people = listOf(Person("xiaowei", 21), Person("xiaohua", 19))

fun salute() = println("Salute!")


fun sendEmail(person: Person, message: String) {
    println("people: ${person.name} send message : $message")
}


fun print5_1_5() {
    val getAge = Person::age
    val getAge1 = { person: Person -> person.age }
    //成员引用 引用属性
    people.maxBy(Person::age)
    //引用顶层函数 不需要加（）
    run(::salute)

    //lambda 实现委托给sendEmail函数
    val action = { person: Person, message: String -> sendEmail(person, message) }
    //可以直接用成员引用代替
    val nextAction = ::sendEmail

    val createPerson = ::Person //创建Person 实例的动作被保存成了值
    val p = createPerson("Alice", 22)
    //p.isAdult 无法调用 局部函数后面声明的时候无法调用 但是顶层函数是可以调用的
    println(p)

    fun Person.isAdult() = age >= 21
    val predicate = Person::isAdult//把函数的调用保存成了值
    println(p.isAdult())
    println(predicate(p))

    //绑定成员引用  捕捉特定实例上的方法引用
    val personD = Person("Dmitry", 34)
    val personsAgeFunction = Person::age //绑定属性
    println(personsAgeFunction(personD))//指定对象的

    //kotlin 1.1 开始可以使用绑定成员引用
    val dmitrysAgeFunction = personD::age
    println(dmitrysAgeFunction())//无参数

}
