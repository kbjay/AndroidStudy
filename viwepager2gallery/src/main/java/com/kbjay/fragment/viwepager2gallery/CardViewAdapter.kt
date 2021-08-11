package com.kbjay.fragment.viwepager2gallery

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import androidx.recyclerview.widget.RecyclerView

class CardViewAdapter : RecyclerView.Adapter<CardViewAdapter.MyHolder>() {
    private val colorsArr by lazy {
        arrayOf(Color.GREEN, Color.RED, Color.CYAN, Color.BLUE, Color.LTGRAY)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        return MyHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_vp, parent, false)
        )
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        holder.bind(colorsArr[position])
    }

    override fun getItemCount(): Int {
        return colorsArr.size
    }

    class MyHolder(root: View) : RecyclerView.ViewHolder(root) {
        private val rootView: RelativeLayout = root.findViewById(R.id.rl)
        fun bind(color: Int) {
            rootView.setBackgroundColor(color)
        }
    }
}