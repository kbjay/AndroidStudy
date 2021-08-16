package com.kbjay.fragment.kjindexview

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout

class KJIndexView(context: Context, attributeSet: AttributeSet) :
    LinearLayout(context, attributeSet) {

    private var currentTotalSize = 0
    private var preSelectedItemIndex = 0
    private var unSelectedDrawable: Drawable?
    private var selectedDrawable: Drawable?
    private var cap = 0

    init {
        val obtainStyledAttributes =
            context.obtainStyledAttributes(attributeSet, R.styleable.KJIndexView)
        selectedDrawable =
            obtainStyledAttributes.getDrawable(R.styleable.KJIndexView_selected_drawable)
                ?: context.getDrawable(R.mipmap.index_selected)
        unSelectedDrawable =
            obtainStyledAttributes.getDrawable(R.styleable.KJIndexView_unSelected_drawable)
                ?: context.getDrawable(R.mipmap.index_unselected)
        cap = obtainStyledAttributes.getDimensionPixelSize(R.styleable.KJIndexView_item_cap,0)
        obtainStyledAttributes.recycle()

        orientation = HORIZONTAL
        layoutParams = ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
    }

    fun update(total: Int, currentIndex: Int) {
        if (total <= 0 || currentIndex >= total) {
            return
        }

        if (currentTotalSize == total) {
            (getChildAt(preSelectedItemIndex) as ImageView).setImageDrawable(unSelectedDrawable)
            (getChildAt(currentIndex) as ImageView).setImageDrawable(selectedDrawable)
            preSelectedItemIndex = currentIndex
        } else {
            removeAllViews()
            for (i in 0 until total) {
                if (currentIndex == i) {
                    addView(createSelectedView(i == total - 1))
                } else {
                    addView(createUnSelectedView(i == total - 1))
                }
            }
            currentTotalSize = total
            preSelectedItemIndex = currentIndex
        }

        postInvalidate()
    }

    private fun createUnSelectedView(isLastItem: Boolean): ImageView {
        return ImageView(context).apply {
            setImageDrawable(unSelectedDrawable)
            val marginLayoutParams = MarginLayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            )
            if (!isLastItem) {
                marginLayoutParams.marginEnd = cap
            }
            layoutParams = marginLayoutParams
        }
    }

    private fun createSelectedView(isLastItem: Boolean): ImageView {
        return ImageView(context).apply {
            setImageDrawable(selectedDrawable)
            val marginLayoutParams = MarginLayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            )
            if (!isLastItem) {
                marginLayoutParams.marginEnd = cap
            }
            layoutParams = marginLayoutParams
        }
    }
}