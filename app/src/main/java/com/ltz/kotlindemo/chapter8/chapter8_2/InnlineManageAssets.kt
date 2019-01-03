package com.ltz.kotlindemo.chapter8.chapter8_2

import java.io.BufferedReader
import java.io.FileReader
import java.util.concurrent.locks.Lock
import kotlin.concurrent.withLock

/**
 * Created by xiaowei on 2019/1/3
 * 内联lambda管理资源
 *
 */

fun print8_2_5() {

    val l: Lock? = null
    l?.withLock { }


}


fun readFirstLineFromFile(path: String): String {
    //这个方法调用 lambda 并且确保资源被关闭，无论 lambda 正常执行还是抛出了异常。
    BufferedReader(FileReader(path)).use { br ->
        return br.readLine()
    }
}


//fun <T> Lock.withLock(action: () -> T): T {
//    lock()
//    try {
//        return action()
//    } finally {
//        unlock()
//    }
//}