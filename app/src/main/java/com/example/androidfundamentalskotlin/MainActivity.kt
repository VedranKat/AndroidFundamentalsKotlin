package com.example.androidfundamentalskotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RadioButton
import com.example.androidfundamentalskotlin.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnOrder.setOnClickListener(){
            val checkedMeatRadioButtonId = binding.rgMeat.checkedRadioButtonId
            val meat = findViewById<RadioButton>(checkedMeatRadioButtonId)
            val cheese = binding.cbCheese.isChecked
            val onions = binding.cbOnions.isChecked
            val salad = binding.cbSalad.isChecked
            val orderString = "You order a burger with: \n" +
                    "${meat.text}" +
                    (if(cheese)"\nCheese" else "") +
                    (if(onions)"\nOnions" else "") +
                    (if(salad)"\nSalad" else "")

            binding.tvOrder.text = orderString

        }

    }
}