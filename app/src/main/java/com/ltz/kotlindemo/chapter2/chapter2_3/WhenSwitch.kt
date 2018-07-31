package com.ltz.kotlindemo.chapter2.chapter2_3

/**
 * Created by xiaowei on 2018/7/27
 */
//单一条件switch
fun getMnemonic(color: Color) = when (color) {
    Color.RED -> "Richard"
    Color.ORANGE -> "OF"
    Color.YELLOW -> "York"
    Color.GREEN -> "Gave"
    Color.BLUE -> "Battle"
    Color.INDIGO -> "In"
    Color.VILOET -> "Vain"
}

//多个条件满足一个 switch
fun getWarmthColor(color: Color) = when (color) {
    Color.RED, Color.YELLOW, Color.ORANGE -> "warmth"
    Color.GREEN -> "neutral"
    Color.BLUE, Color.VILOET, Color.INDIGO -> "cold"
}

//可以把表达式当作参数传给一个函数 太赞了 setOf kotlin内置函数
fun mixColor(c1: Color, c2: Color) = getMnemonic(when (setOf(c1, c2)) {
    setOf(Color.RED, Color.YELLOW) -> Color.ORANGE
    setOf(Color.YELLOW, Color.BLUE) -> Color.GREEN
    setOf(Color.BLUE, Color.VILOET) -> Color.INDIGO
    else -> throw Exception("Dirty Color")
})

//无参数 每个表达式必须是Boolean
fun whenWithNoParameter(color: Color) = when {
    color == Color.YELLOW -> "yellow"
    else -> "other"
}


interface Expr
class Num(val value: Int) : Expr
class Sum(val left: Expr, val right: Expr) : Expr

fun eval(e: Expr): Int = when (e) {
    is Num -> e.value
    is Sum -> eval(e.right) + eval(e.left)
    else -> throw IllegalArgumentException("Unkown expression")
}


//带有代码块的条件 最后一行表达式 是返回值
fun evalWithLogging(e: Expr): Int = when (e) {//这个地方必须规定返回值类型
    is Num -> {
        println("num:${e.value}")
        e.value
    }
    is Sum -> {
        val left = evalWithLogging(e.left)
        val right = evalWithLogging(e.right)
        println("sum :$left+$right")
        left + right
    }
    else -> throw IllegalArgumentException("Unkown expression")
}

