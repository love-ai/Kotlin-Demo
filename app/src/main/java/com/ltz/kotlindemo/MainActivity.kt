package com.ltz.kotlindemo

import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.TextView
import com.ltz.kotlindemo.chapter2.chapter2_1.Person
import com.ltz.kotlindemo.chapter2.chapter2_2.createRandomRectangle
import com.ltz.kotlindemo.chapter2.chapter2_3.*
import com.ltz.kotlindemo.chapter2.chapter2_4.printFizzBuzzStepDown
import com.ltz.kotlindemo.chapter2.chapter2_4.printList
import com.ltz.kotlindemo.chapter2.chapter2_4.printTreeMap
import com.ltz.kotlindemo.chapter2.chapter2_4.recognize
import com.ltz.kotlindemo.chapter2.chapter2_5.readNumber2
import com.ltz.kotlindemo.chapter3.chapter3_6.print3_6
import com.ltz.kotlindemo.chapter4.chapter4_3.print4_3_3
import kotlinx.android.synthetic.main.activity_main.*
import java.io.BufferedReader
import java.io.StringReader
import com.ltz.kotlindemo.util.lastChar as last

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        showChapter2(main_text)
//        showChapter3(main_text)
        showChapter4(main_text)
    }
}


@SuppressLint("SetTextI18n")
fun showChapter2(main_text: TextView) {
    val xiaowei = Person("xiaowei", false)
    xiaowei.isMarried = true
    main_text.text = "ok${xiaowei.isMarried}"
    main_text.text = "isSquare:${createRandomRectangle().isSquare}"
    main_text.text = "rgb is ${MyColor.BLUE.rgb()}"
    main_text.text = "Mnemonic BLUE is ${getMnemonic(Color.BLUE)}"
    main_text.text = "red color is ${getWarmthColor(Color.RED)}"
    main_text.text = "red yellow mix then color is ${mixColor(Color.RED, Color.YELLOW)}"
    main_text.text = "when with no param is ${whenWithNoParameter(Color.RED)}"
    main_text.text = "result is ${eval(Sum(Sum(Num(1), Num(2)), Num(4)))}"
    main_text.text = "result is ${evalWithLogging(Sum(Sum(Num(1), Num(2)), Num(4)))}"
    main_text.text = "run function ${printFizzBuzzStepDown()}"
    main_text.text = "run function ${printTreeMap()}"
    main_text.text = "run function ${printList()}"
    main_text.text = "R  ${recognize('R')}"
    println(readNumber2(BufferedReader(StringReader("123a"))))
}

private fun showChapter3(main_text: TextView) {
//    printJavaClass()
//    printOriginList()
//    //直接扩展函数的方法。
//    println("xiaowei".last())
//    print3_3()
//    print3_4()
//    print3_5()
    print3_6()
}

private fun showChapter4(main_text: TextView) {
//    print4_1()
//    print4_2()
//    print4_3()
//    print4_3_2()
    print4_3_3()

}



