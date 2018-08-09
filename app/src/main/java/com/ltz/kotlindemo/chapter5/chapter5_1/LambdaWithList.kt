package com.ltz.kotlindemo.chapter5.chapter5_1

/**
 * Created by xiaowei on 2018/8/9
 * Lambda 和 集合
 */

data class Person(val name: String, val age: Int)


fun print5_1_2() {
    val people = listOf(Person("xiaowei", 21), Person("xiaohua", 19))
    findTheOldest(people)

    //使用kotlin方法 it只在{}中使用
    println(people.maxBy { it.age })
    //如果lambda中正好是函数或是属性的委托，可以直接使用成员引用 这里就直接用()代表传递参数
    println(people.maxBy(Person::age))


    //lambda 表达式语法
    val sum = { a: Int, b: Int -> a + b }

    println("sum is: ${sum(1, 2)}");
    { println(42) }()//不能直接放在println函数后面 放在后面需要在前一句加上分号 代表上一个表达式结束

    //可读性好
    run { println(43) }

}

fun findTheOldest(people: List<Person>) {
    var maxAge = 0
    var theOldest: Person? = null
    for (person in people) {
        if (person.age > maxAge) {
            maxAge = person.age
            theOldest = person
        }
    }
    println(theOldest)
}

