package com.ltz.kotlindemo.chapter4.chapter4_2

import android.content.Context
import android.util.AttributeSet
import android.view.View

/**
 * Created by xiaowei on 2018/8/1
 */

open class MyView : View {
    constructor(ctx: Context)
            : super(ctx)

    constructor(ctx: Context, attr: AttributeSet)
            : super(ctx, attr)
}

class MyButton : MyView {
    //this()委托给这个类的其他构造方法
//    constructor() : this(context)
    constructor(ctx: Context) : super(ctx)
    constructor(ctx: Context, attr: AttributeSet) : super(ctx, attr)
}