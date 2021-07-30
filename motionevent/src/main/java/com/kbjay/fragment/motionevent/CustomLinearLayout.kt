package com.kbjay.fragment.motionevent

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.MotionEvent
import android.view.ViewGroup

class CustomLinearLayout(context: Context, attributeSet: AttributeSet) :
    ViewGroup(context, attributeSet) {

    override fun dispatchTouchEvent(ev: MotionEvent?): Boolean {
        Log.d(
            "kbjay_test",
            "ViewGroup -> dispatchTouchEvent: ${MotionEventLogHelper.getContent(ev)}"
        )
        return super.dispatchTouchEvent(ev)
    }

    override fun onInterceptTouchEvent(ev: MotionEvent?): Boolean {
        Log.d(
            "kbjay_test",
            "ViewGroup -> onInterceptTouchEvent: ${MotionEventLogHelper.getContent(ev)}"
        )
        return super.onInterceptTouchEvent(ev)
    }

    override fun onTouchEvent(ev: MotionEvent?): Boolean {
        Log.d("kbjay_test", "ViewGroup -> onTouchEvent: ${MotionEventLogHelper.getContent(ev)}")
        return super.onTouchEvent(ev)
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        measureChildren(
            MeasureSpec.getSize(widthMeasureSpec),
            MeasureSpec.getSize(heightMeasureSpec)
        )
    }

    override fun onLayout(changed: Boolean, l: Int, t: Int, r: Int, b: Int) {
        val child = getChildAt(0)
        child.layout(0, 0, child.measuredWidth, child.measuredHeight)
    }
}