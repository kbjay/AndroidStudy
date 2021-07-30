package com.kbjay.fragment.nestedscroll

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.kbjay.fragment.nestedscroll.databinding.ItemRvBinding

class RvAdapter(var context: Context) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private val data = Array(40) { it }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return MyHolder(ItemRvBinding.inflate(LayoutInflater.from(context), parent, false))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        Log.d("kbjay_test", "call onBindViewHolder $position")
        (holder as MyHolder).mTv.text = "${data[position]}"
    }

    override fun getItemCount(): Int {
        return data.size
    }

    class MyHolder(rootBinding: ItemRvBinding) : RecyclerView.ViewHolder(rootBinding.root) {
        var mTv: TextView = rootBinding.tv
    }
}
