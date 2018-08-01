package com.ltz.kotlindemo.chapter4.chapter4_2

import android.content.Context
import android.util.AttributeSet
import android.view.View

/**
 * Created by xiaowei on 2018/8/1
 */

class MyView : View {
    constructor(ctx: Context)
            : super(ctx)

    constructor(ctx: Context, attr: AttributeSet)
            : super(ctx, attr)
}