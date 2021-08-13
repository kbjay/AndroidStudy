package com.kbjay.fragment.view

import android.content.Context
import android.graphics.*
import android.graphics.Paint.ANTI_ALIAS_FLAG
import android.util.AttributeSet
import android.view.View

class KJGradientBorderXparentCenterView(context: Context, attributeSet: AttributeSet) :
    View(context, attributeSet) {

    private var borderStartColor: Int
    private var borderEndColor: Int
    private var contentColor: Int
    private var corners: Int
    private var borderStrokeWidth: Int
    private var borderPaint: Paint
    private var centerContentPaint: Paint
    private var type: Int = 2

    companion object {
        const val TYPE_HORIZONTAL = 0
        const val TYPE_VERTICAL = 1
        const val TYPE_TILT = 2
    }

    init {
        val typedArray = context.obtainStyledAttributes(
            attributeSet,
            R.styleable.KJGradientBorderXparentCenterView
        )

        contentColor =
            typedArray.getColor(R.styleable.KJGradientBorderXparentCenterView_contentColor, -1)
        borderStartColor =
            typedArray.getColor(
                R.styleable.KJGradientBorderXparentCenterView_borderStartColor,
                -1
            )
        borderEndColor =
            typedArray.getColor(
                R.styleable.KJGradientBorderXparentCenterView_borderEndColor,
                -1
            )
        corners = typedArray.getDimensionPixelSize(
            R.styleable.KJGradientBorderXparentCenterView_corners,
            0
        )
        borderStrokeWidth =
            typedArray.getDimensionPixelSize(
                R.styleable.KJGradientBorderXparentCenterView_gradientWidth,
                0
            )
        type = typedArray.getInt(R.styleable.KJGradientBorderXparentCenterView_type, 0)

        typedArray.recycle()
        borderPaint = Paint(ANTI_ALIAS_FLAG)
        borderPaint.style = Paint.Style.STROKE
        borderPaint.strokeWidth = borderStrokeWidth.toFloat()
        centerContentPaint = Paint(ANTI_ALIAS_FLAG)
        centerContentPaint.color = contentColor
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        when (type) {
            TYPE_HORIZONTAL -> {
                borderPaint.shader = LinearGradient(
                    0f, 0f, 0f, w.toFloat(), borderStartColor, borderEndColor, Shader.TileMode.CLAMP
                )
            }
            TYPE_VERTICAL -> {
                borderPaint.shader = LinearGradient(
                    0f, 0f, h.toFloat(), 0f, borderStartColor, borderEndColor, Shader.TileMode.CLAMP
                )
            }
            TYPE_TILT -> {
                borderPaint.shader = LinearGradient(
                    0f,
                    0f,
                    w.toFloat(),
                    h.toFloat(),
                    borderStartColor,
                    borderEndColor,
                    Shader.TileMode.CLAMP
                )
            }
        }

    }

    override fun onDraw(canvas: Canvas?) {
        canvas?.drawRoundRect(
            borderStrokeWidth.toFloat()/2,
            borderStrokeWidth.toFloat()/2,
            measuredWidth -  borderStrokeWidth.toFloat()/2,
            measuredHeight - borderStrokeWidth.toFloat()/2,
            corners.toFloat(),
            corners.toFloat(),
            centerContentPaint
        )
        canvas?.drawRoundRect(
            borderStrokeWidth.toFloat()/2,
            borderStrokeWidth.toFloat()/2,
            measuredWidth -  borderStrokeWidth.toFloat()/2,
            measuredHeight - borderStrokeWidth.toFloat()/2,
            corners.toFloat(),
            corners.toFloat(),
            borderPaint
        )
    }
}