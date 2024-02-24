package com.dodopizza

import android.annotation.SuppressLint
import android.content.Intent
import android.content.res.ColorStateList
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.MotionEvent
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.widget.SearchView
import com.dodopizza.adapter.PizzaAdapter
import com.dodopizza.databinding.ActivityMainBinding
import com.dodopizza.model.Pizza
import com.dodopizza.model.PizzaDataSource


class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    private var pizza_adapter: PizzaAdapter? = null

    @SuppressLint("ClickableViewAccessibility")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val tocombo: Button = binding.toCombo
        tocombo.setOnClickListener {
            val intent = Intent(this, ThirdActivity::class.java)
            startActivity(intent)
        }

        pizza_adapter = PizzaAdapter(
            onPizzaClick = {
                handlePizzaClick(it)
            }
        )
        binding.pizzaView.adapter = pizza_adapter
        pizza_adapter?.setData(PizzaDataSource.pizzaList)

        binding.edtView.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                val searchQuery = s.toString()
                val list = PizzaDataSource.pizzaList.filter {
                    it.title.contains(searchQuery)
                }
                pizza_adapter?.setData(ArrayList(list))
            }

            override fun afterTextChanged(s: Editable?) {
            }
        })

    }
    private fun handlePizzaClick(pizza: Pizza){
        val intent = Intent(this, SecondActivity::class.java)
        intent.putExtra(SecondActivity.KEY_RESULT, pizza.title)
        intent.putExtra(SecondActivity.KEY_INGREDIENT, pizza.description)
        intent.putExtra(SecondActivity.KEY_IMAGE, pizza.imageRes)
        intent.putExtra(SecondActivity.KEY_PRICE, pizza.price)
        startActivity(intent)
    }

}
