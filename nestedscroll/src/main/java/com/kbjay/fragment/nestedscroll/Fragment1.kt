package com.kbjay.fragment.nestedscroll

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class Fragment1: Fragment() {
    private lateinit var root:View
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        root = inflater.inflate(R.layout.fragment_1, container, false)
        initView()
        return root
    }

    private fun initView() {
        val rv = root.findViewById<RecyclerView>(R.id.rv)
        rv.layoutManager = LinearLayoutManager(requireContext())
        rv.adapter = RvAdapter(requireContext())
    }
}

