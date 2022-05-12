package com.example.androidfundamentalskotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.androidfundamentalskotlin.databinding.ActivityFragmentBinding

class FragmentActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFragmentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFragmentBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val firstFragment = FirstFragment()
        val secondFragment = SecondFragment()

        supportFragmentManager.beginTransaction().apply {
            replace(R.id.flFragment, firstFragment).commit()
        }

        binding.btnFragmentOne.setOnClickListener(){
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.flFragment, firstFragment)
                    .addToBackStack(null)
                    .commit()
            }
        }

        binding.btnFragmentTwo.setOnClickListener(){
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.flFragment, secondFragment)
                    addToBackStack(null)
                    .commit()
            }
        }


    }
}