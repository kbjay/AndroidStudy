package com.kbjay.fragment.viwepager2gallery

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import androidx.viewpager2.widget.ViewPager2
import kotlin.math.abs

class KJRollerView : RelativeLayout {
    var pageScaleRate: Float = 1f
    var centerPageIntervalToPage: Int = 0
    var centerPageMarginToParent: Int = 0

    val viewPager2 by lazy {
        ViewPager2(context).apply {
            layoutParams = LayoutParams(
                LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
            )
        }
    }

    constructor(context: Context) : this(context, null)
    constructor(context: Context, attributeSet: AttributeSet?) : this(context, attributeSet, 0)
    constructor(context: Context, attributeSet: AttributeSet?, defStyleArr: Int)
            : this(context, attributeSet, defStyleArr, 0)
    constructor(context: Context, attributeSet: AttributeSet?, defStyleArr: Int, defStyleRes: Int)
            : super(context, attributeSet, defStyleArr, defStyleRes) {
        initParams(context, attributeSet)
        addViewPager2()
    }

    fun <T : RecyclerView.ViewHolder> setAdapter(adapter: RecyclerView.Adapter<T>) {
        viewPager2.adapter = adapter
    }

    private fun initParams(context: Context, attributeSet: AttributeSet?) {
        val typedArray =
            context.obtainStyledAttributes(attributeSet, R.styleable.KJRollerView)
        pageScaleRate = typedArray.getFloat(R.styleable.KJRollerView_pageScaleRate, 0f)
        centerPageIntervalToPage =
            typedArray.getDimensionPixelSize(R.styleable.KJRollerView_centerPageIntervalToPage, 0)
        centerPageMarginToParent =
            typedArray.getDimensionPixelSize(R.styleable.KJRollerView_centerPageMarginToParent, 0)
        typedArray.recycle()
    }

    private fun addViewPager2() {
        viewPager2.apply {
            val recyclerView = getChildAt(0) as RecyclerView
            recyclerView.apply {
                val padding = centerPageMarginToParent
                setPadding(padding, 0, padding, 0)
                clipToPadding = false
            }
            layoutParams = LayoutParams(LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.MATCH_PARENT)
        }

        val compositePageTransformer = CompositePageTransformer()
        compositePageTransformer.addTransformer(
            MarginPageTransformer(centerPageIntervalToPage)
        )
        compositePageTransformer.addTransformer(ScaleInTransformer(pageScaleRate))
        viewPager2.setPageTransformer(compositePageTransformer)
        addView(viewPager2)
    }

    class ScaleInTransformer(private val scaleRate: Float) : ViewPager2.PageTransformer {
        override fun transformPage(view: View, position: Float) {
            view.elevation = -abs(position)
            val pageWidth = view.width
            val pageHeight = view.height

            view.pivotY = (pageHeight / 2).toFloat()
            view.pivotX = (pageWidth / 2).toFloat()
            // (-00 ~ -1 )
            if (position < -1) {
                view.scaleX = scaleRate
                view.scaleY = scaleRate
                view.pivotX = pageWidth.toFloat()
            } else if (position <= 1) {
                // [-1 ~ 0)
                if (position < 0) {
                    val scaleFactor = (1 - scaleRate) * position + 1
                    view.scaleX = scaleFactor
                    view.scaleY = scaleFactor
                } else {
                    // [0 ~ 1]
                    val scaleFactor = (scaleRate - 1) * position + 1
                    view.scaleX = scaleFactor
                    view.scaleY = scaleFactor
                }
                view.pivotX = pageWidth * ((1 - position) * 0.5f)
            } else {
                // (1 ~ +00)
                view.pivotX = 0f
                view.scaleX = scaleRate
                view.scaleY = scaleRate
            }
        }
    }
}