package com.ltz.kotlindemo.chapter4.chapter4_3

/**
 * Created by xiaowei on 2018/8/2
 * 类委托 使用by
 */

fun print4_3_3() {
    val cset = CountingSet<Int>()
    cset.addAll(listOf(1, 2, 3))
    println("${cset.objectsAdded} objects were added,${cset.size} reamin")

    //MyCollection 将实现方法委托给了传入的一个参数 自己并不持有任何参数
    val collection = MyCollection<Int>()
    collection.isEmpty()
}

class DelegatingCollection<T> : Collection<T> {

    private val innerList = arrayListOf<T>()
    override val size: Int get() = innerList.size
    override fun isEmpty(): Boolean = innerList.isEmpty()
    override fun iterator(): Iterator<T> = innerList.iterator()
    override fun contains(element: T): Boolean = innerList.contains(element)
    override fun containsAll(elements: Collection<T>): Boolean = innerList.containsAll(elements)

}

//通过by 将接口的实现委托到另外一个对象
//这个地方 innerList其实就是传入的一个参数，并不是MyCollection的一个属性
class MyCollection<T>(innerList: Collection<T> = ArrayList<T>()) : Collection<T> by innerList {}

class CountingSet<T>(
        val innerSet: MutableCollection<T> = HashSet<T>()
) : MutableCollection<T> by innerSet {
    var objectsAdded = 0
    override fun add(element: T): Boolean {
        objectsAdded++
        return innerSet.add(element)
    }
    override fun addAll(elements: Collection<T>): Boolean {
        objectsAdded += elements.size
        return innerSet.addAll(elements)
    }
}