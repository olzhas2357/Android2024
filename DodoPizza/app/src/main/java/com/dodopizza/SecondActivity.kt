package com.dodopizza

import android.content.res.ColorStateList
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import com.bumptech.glide.Glide
import com.dodopizza.databinding.ActivitySecondBinding
import org.w3c.dom.Text
import java.lang.System.load


class SecondActivity : AppCompatActivity() {

    companion object {
        const val KEY_RESULT = "KeyResult"
        const val KEY_INGREDIENT = "KeyIngredient"
        const val KEY_IMAGE = "KeyImageUrl"
        const val KEY_PRICE = "KeyPrice"
    }


    private lateinit var binding: ActivitySecondBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val result = intent.getStringExtra(KEY_RESULT)
        val resultIng = intent.getStringExtra(KEY_INGREDIENT)
        val resultImage = intent.getIntExtra(KEY_IMAGE, 0)
        val resultPrice = intent.getStringExtra(KEY_PRICE)

        binding.resultTextView.text = result
        binding.resultIngredient.text = resultIng
        Glide.with(this)
            .load(resultImage) // Load the image from the URL
            .into(binding.imageView)

        val small: Button = binding.small
        val ave: Button = binding.avg
        val big: Button = binding.big

        val traditional: Button = binding.traditional
        val thin: Button = binding.thin

        var resultSize: TextView = binding.resultSize
        var resultDough: TextView = binding.resultDough

        val color_gray = Color.parseColor("#F2F2F5");

        small.setOnClickListener{
            resultSize.text = "Маленькая 25 cm,"
            small.backgroundTintList = ColorStateList.valueOf(Color.WHITE)
            ave.backgroundTintList = ColorStateList.valueOf(color_gray)
            big.backgroundTintList = ColorStateList.valueOf(color_gray)

        }
        ave.setOnClickListener{
            resultSize.text = "Средняя 30 cm,"
            ave.backgroundTintList = ColorStateList.valueOf(Color.WHITE)
            small.backgroundTintList = ColorStateList.valueOf(color_gray)
            big.backgroundTintList = ColorStateList.valueOf(color_gray)
        }
        big.setOnClickListener{
            resultSize.text = "Большая 35 cm,"
            big.backgroundTintList = ColorStateList.valueOf(Color.WHITE)
            ave.backgroundTintList = ColorStateList.valueOf(color_gray)
            small.backgroundTintList = ColorStateList.valueOf(color_gray)
        }

        traditional.setOnClickListener {
            resultDough.text = " традиционное теста"
            traditional.backgroundTintList = ColorStateList.valueOf(Color.WHITE)
            thin.backgroundTintList = ColorStateList.valueOf(color_gray)
        }
        thin.setOnClickListener {
            resultDough.text = " тонкое теста"
            thin.backgroundTintList = ColorStateList.valueOf(Color.WHITE)
            traditional.backgroundTintList = ColorStateList.valueOf(color_gray)
        }

        val regex = Regex("[0-9]+")
        val order: TextView = binding.order
        val res = resultPrice?.let { regex.find(it) }
        if (res != null) {
            order.text = "Заказать пиццу за ${res.value} KZT"
        }

        val prev_btn : ImageButton = binding.prevBtn
        prev_btn.setOnClickListener {
            finish()
        }
    }
}




