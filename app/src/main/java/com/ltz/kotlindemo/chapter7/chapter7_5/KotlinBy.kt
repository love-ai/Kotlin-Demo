package com.ltz.kotlindemo.chapter7.chapter7_5

import java.beans.PropertyChangeListener
import java.beans.PropertyChangeSupport

/**
 * Created by xiaowei on 2018/10/11
 * 实现委托属性
 *
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

class Person(val name: String, age: Int, salary: Int) : PropertyChangeAware() {
    var age: Int = age
        set(newValue) {
            val oldValue = field
            field = newValue
            changeSupport.firePropertyChange("age", oldValue, newValue)
        }
    var salary: Int = salary
        set(newValue) {
            val oldvalue = field
            field = newValue
            changeSupport.firePropertyChange("salary", oldvalue, newValue)
        }
}