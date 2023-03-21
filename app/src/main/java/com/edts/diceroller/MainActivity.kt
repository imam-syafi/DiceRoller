package com.edts.diceroller

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.edts.diceroller.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.setup()
    }

    private fun ActivityMainBinding.setup() {
        val dice = Dice(6)

        button.setOnClickListener {
            text.text = "${dice.roll()}"
        }
    }
}
