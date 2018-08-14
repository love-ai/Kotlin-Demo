package com.ltz.kotlindemo.chapter5.chapter5_3

import java.io.File

/**
 * Created by xiaowei on 2018/8/13
 * 创建序列
 */

fun print5_3_2() {
    //计算出下一个元素
    val naturalNumbers = generateSequence(0) { it + 1 }
    //计算所有元素
    val numbersTo100 = naturalNumbers.takeWhile { it <= 100 }
    //打印序列的和 这个时候上面的两个方法才会执行 延期执行
    println(numbersTo100.sum())

    val file = File("/.idea/gradle.xml")//true
    val file1 = File("/app/build.gradle")//false
    println(file1.isInsideHiddenDirectory())
    println(file.getFirstHiddenDirectory())
}

//当前文件是否是在隐藏文件夹下面
fun File.isInsideHiddenDirectory() = generateSequence(this) { it.parentFile }.any { it.isHidden }

//打印最近一级的隐藏目录 如果没有找到则为null 找到了则返回目录名称
fun File.getFirstHiddenDirectory() = generateSequence(this) { it.parentFile }.find { it.isHidden }
