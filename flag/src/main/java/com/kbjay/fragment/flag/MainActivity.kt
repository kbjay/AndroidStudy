package com.kbjay.fragment.flag

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private val mBean by lazy {
        Bean()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun addA(view: View) {
        mBean.addFlag(Bean.FLAG_A)
    }

    fun addD(view: View) {
        mBean.addFlag(Bean.FLAG_D)
    }

    fun addF(view: View) {
        mBean.addFlag(Bean.FLAG_F)
    }

    fun removeA(view: View) {
        mBean.removeFlag(Bean.FLAG_A)
    }

    fun removeD(view: View) {
        mBean.removeFlag(Bean.FLAG_D)
    }

    fun removeF(view: View) {
        mBean.removeFlag(Bean.FLAG_F)
    }

    fun containsA(view: View) {
        Toast.makeText(this, "${mBean.contains(Bean.FLAG_A)}", Toast.LENGTH_SHORT).show()
    }

    fun containsD(view: View) {
        Toast.makeText(this, "${mBean.contains(Bean.FLAG_D)}", Toast.LENGTH_SHORT).show()
    }

    fun containsF(view: View) {
        Toast.makeText(this, "${mBean.contains(Bean.FLAG_F)}", Toast.LENGTH_SHORT).show()
    }
}