package com.ltz.kotlindemo.chapter4.chapter4_4

import com.ltz.kotlindemo.chapter2.chapter2_1.Person
import java.io.File

/**
 * Created by xiaowei on 2018/8/3
 * object 对象声明 kotlin单例模式
 */

fun print4_4_1() {
    //直接调用对象
    Payroll.allEmployees.add(Person("xiaowei", false))
    //直接调用方法
    Payroll.calculateSalary()

    println(CaseInsensitiveFileComparator.compare(File("User"), File("user")))

    val files = listOf(File("/Z"), File("/a"), File("/b"), File("/A"))
    println(files.sortedWith(CaseInsensitiveFileComparator))
}


//Payroll是一个类，也是一个单例对象
object Payroll {
    //对象声明中与类类似 可以有属性
    val allEmployees = arrayListOf<Person>()

    //可以有方法
    fun calculateSalary() {
        for (person in allEmployees) {
            //...
        }
    }
    // Constructors are not allowed for objects
//    constructor()
}

object CaseInsensitiveFileComparator : Comparator<File> {
    override fun compare(o1: File, o2: File): Int {
        return o1.path.compareTo(o2.path, ignoreCase = true)
    }
}