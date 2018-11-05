package com.ltz.kotlindemo.JavaCode;


import com.ltz.kotlindemo.chapter8.chapter8_1.UseKotlinFunClassInJavaKt;

import java.util.ArrayList;
import java.util.List;

import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;

/**
 * Created by xiaowei on 2018/11/5
 * <p>
 * java中调用kotlin函数类型
 *
 * 函数或者 lambda可以返回 Unit。但因为在 Kotiin 中 Unit 类型 是有一个值的，所以需要显式地返回它
 */
public class UseKotlinFunClass {

    public static void Test() {
        UseKotlinFunClassInJavaKt.processTheAnswer(new Function1<Integer, Integer>() {
            @Override
            public Integer invoke(Integer integer) {
                System.out.println(integer);
                return integer + 1;
            }
        });

        UseKotlinFunClassInJavaKt.processTheAnswer(number -> number + 100);


        List<String> strings = new ArrayList<>();
        strings.add("42");
        CollectionsKt.forEach(strings, s -> {
            System.out.println(s);
            return Unit.INSTANCE;//一个返回 void 的 lambda 不能作为返回 Unit 的函数类型的实参
        });
    }
}
