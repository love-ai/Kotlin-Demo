package com.ltz.kotlindemo.chapter5.chapter5_1

/**
 * Created by xiaowei on 2018/8/9
 * Lambda 表达式的语法
 */

fun print5_1_3() {
    val people = listOf(Person("xiaowei", 21), Person("xiaohua", 19))
    //以下为maxBy 函数调用的简化过程
    //1 原始用法 lambda表达式作为参数传递给一个函数
    people.maxBy({ p: Person -> p.age })
    //2 如果表达式是最后一个实参 则可以放到括号外
    people.maxBy() { p: Person -> p.age }
    //3.当lambda是唯一实参时 可以省略前面的括号
    people.maxBy { p: Person -> p.age }
    //4.更为复杂的调用
    val name = people.joinToString(separator = " ", transform = { p: Person -> p.name })
    val name1 = people.joinToString(separator = " ") { p: Person -> p.name }
    println(name)
    //5.继续优化 移除参数类型
    people.maxBy { p -> p.age } //参数类型自动推导
    //6.终极优化 使用it
    people.maxBy { it.age }//it 自动生成的参数名称

    //当使用变量存储lambda时 需要显示的声明参数类型
    val getAge = { p: Person -> p.age }
    people.maxBy(getAge) //编译器会自动提示maxby(getAge)这个就很强大了！

    val sum = { x: Int, y: Int ->
        println("the sum of x and y is:")
        x + y//最后一个表达式就是lambda的值
    }

    println(sum(3, 4))
}