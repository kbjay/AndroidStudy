package com.kbjay.fragment.motionevent

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.MotionEvent
import android.view.View

class CustomTextView(context: Context, attributeSet: AttributeSet) :
    View(context, attributeSet) {
    override fun dispatchTouchEvent(ev: MotionEvent?): Boolean {
        Log.d("kbjay_test", "view -> dispatchTouchEvent: ${MotionEventLogHelper.getContent(ev)}")
        return super.dispatchTouchEvent(ev)
    }

    override fun onTouchEvent(ev: MotionEvent?): Boolean {
        Log.d("kbjay_test", "view -> onTouchEvent: ${MotionEventLogHelper.getContent(ev)}")
        return super.onTouchEvent(ev)
    }
    init {
        isClickable = true
    }
}