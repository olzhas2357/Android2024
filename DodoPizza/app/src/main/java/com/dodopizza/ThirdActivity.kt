package com.dodopizza

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.dodopizza.adapter.ComboAdapter
import com.dodopizza.databinding.ActivityThirdBinding
import com.dodopizza.model.PizzaDataSource

class ThirdActivity : AppCompatActivity() {
    private lateinit var binding: ActivityThirdBinding
    private var combo_adapter: ComboAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityThirdBinding.inflate(layoutInflater)
        setContentView(binding.root)
        combo_adapter = ComboAdapter(
            onComboClick = {
            }
        )
        binding.comboView.adapter = combo_adapter
        combo_adapter?.setData(PizzaDataSource.comboList)
    }
}