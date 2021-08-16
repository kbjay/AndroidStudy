package com.kbjay.fragment.kjindexview

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

class KJIndexView(context: Context, attributeSet: AttributeSet) : View(context, attributeSet) {

    private var unSelectedColor: Int
    private var selectedColor: Int

    private var itemWidth: Int
    private var itemHeight: Int

    private var paint1: Paint
    private var paint2: Paint

    var itemCount = 10

    init {
        itemHeight = 40
        itemWidth = 100
        unSelectedColor = Color.DKGRAY
        selectedColor = Color.GRAY
        paint1 = Paint(Paint.ANTI_ALIAS_FLAG).apply {
            color = unSelectedColor
        }
        paint2 = Paint(Paint.ANTI_ALIAS_FLAG).apply {
            color = selectedColor
        }
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        canvas?.drawRect(
            (measuredWidth / 2 - itemWidth / 2).toFloat(),
            (measuredHeight / 2 - itemHeight / 2).toFloat(),
            (measuredWidth / 2 + itemWidth / 2).toFloat(),
            (measuredHeight / 2 + itemHeight / 2).toFloat(),
            paint2
        )
        canvas?.skew(1f, 0f)
        canvas?.drawRect(
            (measuredWidth / 2 - itemWidth / 2).toFloat(),
            (measuredHeight / 2 - itemHeight / 2).toFloat(),
            (measuredWidth / 2 + itemWidth / 2).toFloat(),
            (measuredHeight / 2 + itemHeight / 2).toFloat(),
            paint1
        )
    }
}