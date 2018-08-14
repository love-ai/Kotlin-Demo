package com.ltz.kotlindemo.chapter5.chapter5_2

/**
 * Created by xiaowei on 2018/8/10
 * 集合的ALl Any Count Find 判断式用法
 */


fun print5_2_2() {

    val people = listOf(Person("xiaohong", 23),
            Person("xiaohua", 16),
            Person("xiaoming", 15))

    val canBeInClue20 = { p: Person -> p.age <= 20 }

    //是否是所有的元素都满足表达式
    println(people.all(canBeInClue20))

    //只要有任何一个元素满足表达式返回 true
    println(people.any(canBeInClue20))


    val list = listOf(1, 3, 4, 2, 9, 7)
    //以下两种方式结果相同，建议用any
    println(!list.all { it == 4 })
    println(list.any { it == 4 })

    //计算满足表达式的个数 较下面的方式要高效
    println(people.count(canBeInClue20))
    //不建议用这种 会多创建一个临时数组
    println(people.filter(canBeInClue20).size)


    //需要找到满足表达式的 第一个 元素用find
    println(people.find(canBeInClue20))
    //返回所有满足表达式的集合
    println(people.filter(canBeInClue20))
}