package com.kbjay.fragment.kjroundcornerview

import android.content.Context
import android.graphics.Canvas
import android.graphics.Path
import android.graphics.RectF
import android.util.AttributeSet
import android.widget.ImageView


class KjRoundCornerView(context: Context, attributeSet: AttributeSet) :
    ImageView(context, attributeSet) {
    private var corner: Int
    private var mRectF: RectF? = null
    private var mPath: Path

    init {
        val obtainStyledAttributes =
            context.obtainStyledAttributes(attributeSet, R.styleable.KjRoundCornerView)
        corner =
            obtainStyledAttributes.getDimensionPixelSize(R.styleable.KjRoundCornerView_corner, 0)
        obtainStyledAttributes.recycle()
        mPath = Path()
    }

    override fun onDraw(canvas: Canvas?) {
        mPath.reset();
        mRectF?.let {
            mPath.addRoundRect(
                it,
                corner.toFloat(),
                corner.toFloat(),
                Path.Direction.CW
            )
        }
        canvas?.save()
        canvas?.clipPath(mPath)
        super.onDraw(canvas)
        canvas?.restore()
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        mRectF = RectF(0f, 0f, w.toFloat(), h.toFloat())
    }
}