package com.ltz.kotlindemo.chapter7.chapter7_5

import java.beans.PropertyChangeListener
import java.beans.PropertyChangeSupport
import kotlin.properties.Delegates
import kotlin.reflect.KProperty

/**
 * Created by xiaowei on 2018/10/11
 * 实现委托属性 by
 *
 * by 右边的表达式不一定是新创建 的实例，也可以是函数调用、另 一个属性或任何其他表达式 ，
 * 只要这个表达式的值，是能够被编译器用正确的参数类型来调用 getValue 和 setValue 的对象。
 * 与其他约定一样， getValue 和 setValue 可以是对象自己声明的方法或扩展函数。
 */

fun print7_5_3() {
    var p = Person("xiaoming", 23, 45)
    p.addPropertyChangeListener(PropertyChangeListener { evt ->
        println("Property ${evt.propertyName} changed from ${evt.oldValue} to ${evt.newValue}")
    })
    p.age = 5
    p.salary = 50
}

open class PropertyChangeAware {
    protected val changeSupport = PropertyChangeSupport(this)
    fun addPropertyChangeListener(listener: PropertyChangeListener) {
        changeSupport.addPropertyChangeListener(listener)
    }

    fun removePropertyChangeListener(listener: PropertyChangeListener) {
        changeSupport.removePropertyChangeListener(listener)
    }
}


//class ObservableProperty(val propName: String, var propValue: Int, val changeSupport: PropertyChangeSupport) {
//    fun getValue(): Int = propValue
//    fun setValue(newValue: Int) {
//        val oldValue = propValue
//        propValue = newValue
//        changeSupport.firePropertyChange(propName, oldValue, newValue)
//    }
//}

class ObservableProperty(var propValue: Int, val changeSupport: PropertyChangeSupport) {
    operator fun getValue(p: Person, prop: KProperty<*>): Int = propValue
    operator fun setValue(p: Person, prop: KProperty<*>, newValue: Int) {
        val oldValue = propValue
        propValue = newValue
        changeSupport.firePropertyChange(prop.name, oldValue, newValue)
    }
}


class Person(val name: String, age: Int, salary: Int) : PropertyChangeAware() {
//    var age: Int = age
//        set(newValue) {
//            val oldValue = field //field 标识符允许访问属性背后的支持字段
//            field = newValue
//            changeSupport.firePropertyChange("age", oldValue, newValue) //属性变化时通知监听器
//        }
//    var salary: Int = salary
//        set(newValue) {
//            val oldvalue = field
//            field = newValue
//            changeSupport.firePropertyChange("salary", oldvalue, newValue) //属性变化时通知监听器
//        }

    //使用代理的写法
//    val _age = ObservableProperty("age", age, changeSupport)
//    var age: Int
//        get() = _age.getValue()
//        set(newValue) = _age.setValue(newValue)
//
//    val _salary = ObservableProperty("salary", salary, changeSupport)
//    var salary: Int
//        get() = _salary.getValue()
//        set(newValue) = _salary.setValue(newValue)

    //使用kotlin委托属性的写法
//    var age: Int by ObservableProperty(age, changeSupport)
//    var salary: Int by ObservableProperty(salary, changeSupport)


    //使用Delegates.observalbe实现属性修改的通知
    private val observer = { prop: KProperty<*>, oldValue: Int, newValue: Int ->
        changeSupport.firePropertyChange(prop.name, oldValue, newValue)
    }
    var age: Int by Delegates.observable(age,observer)
    var salary:Int by Delegates.observable(salary,observer)
}