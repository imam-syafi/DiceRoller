package com.edts.diceroller

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isInvisible
import androidx.core.view.isVisible
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
            if (image.isInvisible) {
                image.isVisible = true
                text.isVisible = false
            }

            val side = dice.roll()

            val id = when (side) {
                1 -> R.drawable.dice_1
                2 -> R.drawable.dice_2
                3 -> R.drawable.dice_3
                4 -> R.drawable.dice_4
                5 -> R.drawable.dice_5
                else -> R.drawable.dice_6
            }

            with(image) {
                animate().rotationBy(360f).start()
                contentDescription = getString(R.string.dice_side, side)
                setImageResource(id)
            }
        }
    }
}
