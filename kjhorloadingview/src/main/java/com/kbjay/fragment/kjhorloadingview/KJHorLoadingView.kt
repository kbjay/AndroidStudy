package com.kbjay.fragment.kjhorloadingview

import android.content.Context
import android.content.res.Resources
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.DashPathEffect
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

class KJHorLoadingView(context: Context, attributeSet: AttributeSet) : View(context, attributeSet) {

    var width: Int? = null
    var height: Int? = null

    // default 20
    private var totalCount: Int

    // default 2dp
    private var gap: Int

    // default 4dp
    private var boundWidth: Int

    // default 2dp
    private var corner: Int
    var dashSize: Float? = null
    var progress = 0f
    private var boundColor: Int
    private var progressColor: Int

    private var boundPaint: Paint

    private var progressPaint: Paint

    init {
        val obtainStyledAttributes =
            context.obtainStyledAttributes(attributeSet, R.styleable.KJHorLoadingView)

        totalCount = obtainStyledAttributes.getInt(R.styleable.KJHorLoadingView_totalCount, 20)
        gap = obtainStyledAttributes.getDimensionPixelSize(
            R.styleable.KJHorLoadingView_boundWidth,
            (Resources.getSystem().displayMetrics.density * 2).toInt()
        )
        boundWidth = obtainStyledAttributes.getDimensionPixelSize(
            R.styleable.KJHorLoadingView_boundWidth,
            (Resources.getSystem().displayMetrics.density * 4).toInt()
        )

        corner = obtainStyledAttributes.getDimensionPixelSize(
            R.styleable.KJHorLoadingView_corner,
            (Resources.getSystem().displayMetrics.density * 2).toInt()
        )
        boundColor = obtainStyledAttributes.getColor(
            R.styleable.KJHorLoadingView_boundColor,
            Color.parseColor("#FF46EC1A")
        )
        progressColor = obtainStyledAttributes.getColor(
            R.styleable.KJHorLoadingView_progressColor,
            Color.parseColor("#FF44F05B")
        )
        obtainStyledAttributes.recycle()
        boundPaint =
            Paint(Paint.ANTI_ALIAS_FLAG).apply {
                color = boundColor
                strokeWidth = boundWidth.toFloat()
                style = Paint.Style.STROKE
            }
        progressPaint =
            Paint(Paint.ANTI_ALIAS_FLAG).apply {
                color = progressColor
            }
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        width = w
        height = h
        dashSize = (width!! - boundWidth * 2 - gap) / totalCount.toFloat() - gap
        progressPaint.pathEffect = DashPathEffect(floatArrayOf(dashSize!!, gap.toFloat()), 0f)
        progressPaint.strokeWidth = (h - gap * 2 - boundWidth * 2).toFloat()
    }


    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        canvas?.drawRoundRect(
            (boundWidth / 2).toFloat(),
            (boundWidth / 2).toFloat(),
            (width!! - boundWidth / 2).toFloat(),
            (height!! - boundWidth / 2).toFloat(),
            corner.toFloat(),
            corner.toFloat(),
            boundPaint
        )
        canvas?.drawLine(
            (boundWidth + gap).toFloat(),
            height!! / 2f,
            boundWidth + gap + progress * (width!! - 2 * boundWidth - gap),
            height!! / 2f,
            progressPaint
        )
    }

    fun setProgress(progress: Int) {
        this.progress = progress / 100f
        postInvalidate()
    }
}