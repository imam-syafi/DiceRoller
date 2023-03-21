package com.edts.diceroller

import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
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
            if (image1.isInvisible) {
                image1.isVisible = true
                image2.isVisible = true
                text.isVisible = false
            }

            val side1 = image1.roll(dice, false)
            val side2 = image2.roll(dice)

            val msg = if (side1 == side2) {
                "It's a tie!"
            } else if (side1 > side2) {
                "Dice 1 wins!"
            } else {
                "Dice 2 wins!"
            }

            Toast
                .makeText(this@MainActivity, msg, Toast.LENGTH_SHORT)
                .show()
        }
    }

    private fun ImageView.roll(dice: Dice, rotateClockwise: Boolean = true): Int {
        val side = dice.roll()

        val id = when (side) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        animate().rotationBy(if (rotateClockwise) 360f else -360f).start()
        contentDescription = getString(R.string.dice_side, side)
        setImageResource(id)

        return side
    }
}
