package com.kbjay.fragment.nestedscroll

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.kbjay.fragment.nestedscroll.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val rootBinding by lazy {
        ActivityMainBinding.inflate(LayoutInflater.from(this))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(rootBinding.root)
        initView()
    }

    private fun initView() {

        val array = arrayOf(Fragment1(), Fragment2(), Fragment3())

        rootBinding.vp.adapter = object : FragmentStateAdapter(this) {
            override fun getItemCount(): Int {
                return array.size
            }

            override fun createFragment(position: Int): Fragment {
                return array[position]
            }


        }
        TabLayoutMediator(rootBinding.tabLayout, rootBinding.vp) { tab, position ->
            when (position) {
                0 -> tab.text = "First"
                1 -> tab.text = "Second"
                else -> tab.text = "Third"
            }
        }.attach()
    }
}