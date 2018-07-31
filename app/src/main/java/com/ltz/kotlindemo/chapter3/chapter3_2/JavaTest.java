package com.ltz.kotlindemo.chapter3.chapter3_2;

//import com.ltz.kotlindemo.util.MyUtilKt;

import com.ltz.kotlindemo.util.StringFunctions;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiaowei on 2018/7/31
 * java 调用kt 顶层函数的方式
 */
public class JavaTest {
    public void joinToStringJava() {
        List<String> nameList = new ArrayList<>();
        nameList.add("alice");
        nameList.add("bob");
        nameList.add("france");
        //没有注解的时候的用法 名+文件后缀
//        MyUtilKt.joinToStringUtil(nameList, ",", "", "");
        //有注解的时候的用法
        StringFunctions.joinToStringUtil(nameList, ",", "", "");
        //@JvmOverloads 注解之后可以直接调用，不用编译
        StringFunctions.joinToStringUtil(nameList);
        StringFunctions.joinToStringUtil(nameList, ",");
        StringFunctions.joinToStringUtil(nameList, ",", "[");
        //java调用扩展函数
        StringFunctions.lastChar("xiaowei");
//        MyUtilKt.lastChar("xiaowei");
        StringFunctions.getLastChar("Java");
    }
}
