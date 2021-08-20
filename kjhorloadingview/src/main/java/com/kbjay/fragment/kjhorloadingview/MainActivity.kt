package com.kbjay.fragment.kjhorloadingview

import android.animation.ObjectAnimator
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val loadingView = findViewById<KJHorLoadingView>(R.id.kj_loading)
        loadingView.postDelayed({
            ObjectAnimator.ofInt(loadingView, "progress", 0, 100).setDuration(4000).start()
        }, 1000)
    }
}