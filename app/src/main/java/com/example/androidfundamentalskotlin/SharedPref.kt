package com.example.androidfundamentalskotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.androidfundamentalskotlin.databinding.ActivitySharedPrefBinding

class SharedPref : AppCompatActivity() {

    private lateinit var binding: ActivitySharedPrefBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySharedPrefBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val shP = getSharedPreferences("myPref", MODE_PRIVATE)
        val editor = shP.edit()

        binding.btnSave.setOnClickListener(){
            val name = binding.etName.text.toString()
            val age = binding.etAge.text.toString().toInt()
            val isAdult = binding.cbAdult.isChecked

            editor.apply{
                putString("name", name)
                putInt("age", age)
                putBoolean("isAdult", isAdult)
                //commit() - sync, blocks the main thread
                apply()
            }
        }

        binding.btnLoad.setOnClickListener(){
            val name = shP.getString("name", null)
            val age = shP.getInt("age", 0)
            val isAdult = shP.getBoolean("isAdult", false)

            binding.etName.setText(name)
            binding.etAge.setText(age.toString())
            binding.cbAdult.isChecked = isAdult

        }
    }
}