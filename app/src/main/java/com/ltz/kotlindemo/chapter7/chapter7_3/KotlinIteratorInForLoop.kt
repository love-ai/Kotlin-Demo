package com.ltz.kotlindemo.chapter7.chapter7_3

import android.os.Build
import android.support.annotation.RequiresApi
import java.time.LocalDate

@RequiresApi(Build.VERSION_CODES.O)
        /**
         * Created by xiaowei on 2018/10/10
         * 在for循环中使用Iterator的约定
         *
         */


fun print7_3_4() {
    val newYear = LocalDate.ofYearDay(2017, 1)
    val daysOff = newYear.minusDays(3)..newYear
    for (dayOff in daysOff) {
        println(dayOff)
    }
}


operator fun ClosedRange<LocalDate>.iterator(): Iterator<LocalDate> =
        object : Iterator<LocalDate> {
            var current = start
            override fun hasNext() =
                    current <= endInclusive

            @RequiresApi(Build.VERSION_CODES.O)
            override fun next() = current.apply {
                current = plusDays(1)
            }

        }