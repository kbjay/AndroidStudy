package com.kbjay.fragment.viwepager2gallery

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.DisplayMetrics
import android.view.LayoutInflater
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import androidx.viewpager2.widget.ViewPager2
import com.kbjay.fragment.viwepager2gallery.databinding.ActivityMainBinding
import kotlin.math.abs

class MainActivity : AppCompatActivity() {
    private val rootBinding by lazy {
        ActivityMainBinding.inflate(LayoutInflater.from(this))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(rootBinding.root)

        initVp2()
    }

    private fun initVp2() {
        rootBinding.vp.apply {
            val recyclerView = getChildAt(0) as RecyclerView
            recyclerView.apply {
                val padding = resources.getDimensionPixelOffset(R.dimen.dp_84)
                // setting padding on inner RecyclerView puts overscroll effect in the right place
                setPadding(padding, 0, padding, 0)
                clipToPadding = false
            }
        }

        var compositePageTransformer = CompositePageTransformer()
        compositePageTransformer.addTransformer(MarginPageTransformer(resources.getDimensionPixelSize(R.dimen.dp_42)))
        compositePageTransformer.addTransformer(ScaleInTransformer(0.85f))
        rootBinding.vp.setPageTransformer(compositePageTransformer)
        rootBinding.vp.offscreenPageLimit = 3
        rootBinding.vp.adapter = CardViewAdapter()
    }

    class ScaleInTransformer(private val scaleRate: Float) : ViewPager2.PageTransformer {
        override fun transformPage(view: View, position: Float) {
            view.elevation = abs(position)
            if (position > -1 && position < 1) {
                val rate = 1 - (1 - scaleRate) * abs(position)
                view.scaleY = rate
                view.scaleX = rate
            } else {
                view.scaleY = scaleRate
                view.scaleX = scaleRate
            }
        }
    }
}



