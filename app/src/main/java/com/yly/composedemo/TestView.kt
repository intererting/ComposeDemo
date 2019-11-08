package com.yly.composedemo

import android.content.Context
import android.graphics.Canvas
import android.util.AttributeSet
import android.view.View

class TestView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    override fun draw(canvas: Canvas?) {
        println("child  $canvas")
        super.draw(canvas)
    }
}