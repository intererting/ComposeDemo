package com.yly.composedemo

import android.content.Context
import android.graphics.Canvas
import android.util.AttributeSet
import android.widget.LinearLayout

class TestLayout @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {

    override fun dispatchDraw(canvas: Canvas?) {
        println("parent  $canvas")
        super.dispatchDraw(canvas)
    }
}