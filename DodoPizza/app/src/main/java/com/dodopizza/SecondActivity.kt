package com.dodopizza

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.dodopizza.databinding.ActivitySecondBinding
import java.lang.System.load


class SecondActivity : AppCompatActivity() {

    companion object {
        const val KEY_RESULT = "KeyResult"
        const val KEY_IMAGE = "KeyImageUrl"
    }


    private lateinit var binding: ActivitySecondBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val result = intent.getStringExtra(KEY_RESULT)
//        val resultImage = intent.getStringExtra(KEY_IMAGE)

        binding.resultTextView.text = result
//        Glide.with(this)
//            .load(resultImage) // Load the image from the URL
//            .into(binding.imageView)


    }
}

