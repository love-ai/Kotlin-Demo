package com.ltz.kotlindemo.chapter8.chapter8_1

/**
 * Created by xiaowei on 2018/11/8
 * 通过lambda去除重复代码
 */

fun print8_1_6() {
    val averageWindowsDuration = log.filter { it.os == OS.MAC }.map { it.duration }.average()
    println(averageWindowsDuration)
    println(log.averageDurationFor(OS.IOS))

    println(log.averageDurationIn(setOf(OS.MAC, OS.WINDOWS)))

    println(log.averageDurationBy { it.os == OS.IOS && it.path == "/siri" })

}


data class SiteVisite(val path: String, val duration: Double, val os: OS)

enum class OS { WINDOWS, MAC, IOS, ANDROID, LINUX }

val log = listOf(SiteVisite("/", 34.0, OS.WINDOWS),
        SiteVisite("/login", 22.0, OS.MAC),
        SiteVisite("/paly", 29.0, OS.MAC),
        SiteVisite("/main", 18.3, OS.LINUX),
        SiteVisite("/user", 29.1, OS.ANDROID),
        SiteVisite("/siri", 30.3, OS.IOS),
        SiteVisite("/si", 10.3, OS.IOS)
)

fun List<SiteVisite>.averageDurationFor(os: OS) = filter { it.os == os }.map { it.duration }.average()
fun List<SiteVisite>.averageDurationIn(os: Set<OS>) = filter { it.os in os }.map { it.duration }.average()

fun List<SiteVisite>.averageDurationBy(predicate: (SiteVisite) -> Boolean) = filter(predicate).map { it.duration }.average()

