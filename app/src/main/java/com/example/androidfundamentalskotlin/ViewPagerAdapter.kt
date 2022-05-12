package com.example.androidfundamentalskotlin

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.view.menu.MenuView
import androidx.recyclerview.widget.RecyclerView
import com.example.androidfundamentalskotlin.databinding.ItemViewPagerBinding

class ViewPagerAdapter(
    val images: List<Int>
):RecyclerView.Adapter<ViewPagerAdapter.ViewPagerViewHolder>() {
    inner class ViewPagerViewHolder(val binding: ItemViewPagerBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewPagerViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemViewPagerBinding.inflate(layoutInflater,parent,false)
        return ViewPagerViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewPagerViewHolder, position: Int) {
        val curImage = images[position]
        holder.binding.ivImage.setImageResource(curImage)
    }

    override fun getItemCount(): Int {
        return images.size
    }
}