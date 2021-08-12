package com.kbjay.fragment.view

import android.content.Context
import android.graphics.*
import android.graphics.Paint.ANTI_ALIAS_FLAG
import android.util.AttributeSet
import android.view.View

class GradientBorderAndTranslateContentView(context: Context, attributeSet: AttributeSet) :
    View(context, attributeSet) {

    private var borderStartColor: Int
    private var borderEndColor: Int
    private var contentColor: Int
    private var corners: Float
    private var borderStrokeWidth: Int
    private var paint: Paint
    private var type: Int = 2

    companion object {
        const val TYPE_HORIZONTAL = 0
        const val TYPE_VERTICAL = 1
        const val TYPE_TILT = 2
    }

    init {
        val typedArray = context.obtainStyledAttributes(
            attributeSet,
            R.styleable.GradientBorderAndTranslateContentView
        )

        contentColor =
            typedArray.getColor(R.styleable.GradientBorderAndTranslateContentView_contentColor, -1)
        borderStartColor =
            typedArray.getColor(
                R.styleable.GradientBorderAndTranslateContentView_borderStartColor,
                -1
            )
        borderEndColor =
            typedArray.getColor(
                R.styleable.GradientBorderAndTranslateContentView_borderEndColor,
                -1
            )
        corners = typedArray.getFloat(R.styleable.GradientBorderAndTranslateContentView_corners, 0f)
        borderStrokeWidth =
            typedArray.getDimensionPixelSize(
                R.styleable.GradientBorderAndTranslateContentView_gradientWidth,
                0
            )
        type = typedArray.getInt(R.styleable.GradientBorderAndTranslateContentView_type, 0)

        typedArray.recycle()
        paint = Paint(ANTI_ALIAS_FLAG)
        paint.style = Paint.Style.STROKE
        paint.strokeWidth = borderStrokeWidth.toFloat()
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        when (type) {
            TYPE_HORIZONTAL -> {
                paint.shader = LinearGradient(
                    0f, 0f, 0f, w.toFloat(), borderStartColor, borderEndColor, Shader.TileMode.CLAMP
                )
            }
            TYPE_VERTICAL -> {
                paint.shader = LinearGradient(
                    0f, 0f, h.toFloat(), 0f, borderStartColor, borderEndColor, Shader.TileMode.CLAMP
                )
            }
            TYPE_TILT -> {
                paint.shader = LinearGradient(
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
        canvas?.drawColor(contentColor)
        canvas?.drawRoundRect(
            0f,
            0f,
            measuredWidth.toFloat(),
            measuredHeight.toFloat(),
            corners,
            corners,
            paint
        )
        super.onDraw(canvas)
    }
}