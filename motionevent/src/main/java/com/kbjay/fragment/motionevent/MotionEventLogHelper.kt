package com.kbjay.fragment.motionevent

import android.view.MotionEvent

class MotionEventLogHelper {
    companion object {
        fun getContent(ev: MotionEvent?): String {
            return when (ev?.action) {
                MotionEvent.ACTION_DOWN -> "down"
                MotionEvent.ACTION_MOVE -> "move"
                MotionEvent.ACTION_UP -> "up"
                MotionEvent.ACTION_CANCEL -> "cancel"
                else -> ""
            }
        }
    }
}