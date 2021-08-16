package com.kbjay.fragment.kjindexview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {
    private lateinit var kjIndexView: KJIndexView

    private var total = 10
    private var current = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        kjIndexView = findViewById(R.id.index)
        kjIndexView.update(total, current)
    }

    fun update(view: View) {
        current++
        if (current == total) {
            current = 0
        }
        kjIndexView.update(total, current)
    }
}