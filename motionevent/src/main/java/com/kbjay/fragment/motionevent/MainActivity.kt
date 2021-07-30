package com.kbjay.fragment.motionevent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MotionEvent

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun dispatchTouchEvent(ev: MotionEvent?): Boolean {
        Log.d(
            "kbjay_test",
            "Activity -> dispatchTouchEvent: ${MotionEventLogHelper.getContent(ev)}"
        )
        return super.dispatchTouchEvent(ev)
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        Log.d("kbjay_test", "Activity -> onTouchEvent: ${MotionEventLogHelper.getContent(event)}")
        return super.onTouchEvent(event)
    }
}