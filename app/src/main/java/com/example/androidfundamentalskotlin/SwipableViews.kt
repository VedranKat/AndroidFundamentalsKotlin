package com.example.androidfundamentalskotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.example.androidfundamentalskotlin.databinding.ActivitySwipableViewsBinding

class SwipableViews : AppCompatActivity() {

    private lateinit var binding: ActivitySwipableViewsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySwipableViewsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val images = listOf(
            R.drawable.miami,
            R.drawable.sanfrancisco,
            R.drawable.nyc
        )

        val adapter = ViewPagerAdapter(images)
        binding.viewPager.adapter = adapter

        // binding.viewPager.orientation = ViewPager2.ORIENTATION_VERTICAL

    }
}