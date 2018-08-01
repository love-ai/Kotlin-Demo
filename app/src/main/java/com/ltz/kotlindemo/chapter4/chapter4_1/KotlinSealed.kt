package com.ltz.kotlindemo.chapter4.chapter4_1

/**
 * Created by xiaowei on 2018/8/1
 */
sealed class Expr {
    class Num(val value: Int) : Expr()//这个后面需要加() 因为这里是类，需要调用默认的构造方法

}

//Kotlin 1.1之后可以被定义在 sealed 类之外
class Sum(val left: Expr, val right: Expr) : Expr()

class Sum1(val left: Expr, val right: Expr)

fun eval(e: Expr): Int = when (e) {
    is Expr.Num -> e.value
    is Sum -> eval(e.left) + eval(e.right)
}
