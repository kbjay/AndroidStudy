package com.kbjay.fragment.decompile

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.kbjay.decompile.hook.log.InjectLog

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        InjectLog.hookApp(application)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        InjectLog.printFunc()
    }
}