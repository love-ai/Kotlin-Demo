package com.ltz.kotlindemo.chapter7.chapter7_3

import android.os.Build
import android.support.annotation.RequiresApi
import java.time.LocalDate


/**
 * Created by xiaowei on 2018/10/10
 * 在for循环中使用Iterator的约定
 *
 */

@RequiresApi(Build.VERSION_CODES.O)
fun print7_3_4() {
    val newYear = LocalDate.ofYearDay(2017, 1)
    val daysOff = newYear.minusDays(5)..newYear
    for (dayOff in daysOff) {
        println(dayOff)
    }
}


//自定义Iterator
operator fun ClosedRange<LocalDate>.iterator(): Iterator<LocalDate> =
        object : Iterator<LocalDate> {
            //这个对象实现了遍历LocalDate元素的Iterator
            var current = start

            override fun hasNext() =
                    current <= endInclusive//这里的日期用到了 compareTo约定

            @RequiresApi(Build.VERSION_CODES.O)
            //在修改前返回当前日期作为结果
            override fun next() = current.apply {
                current = plusDays(2) //把当前日期增加一天
            }

        }