package com.dodopizza

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.dodopizza.adapter.ComboAdapter
import com.dodopizza.adapter.PizzaAdapter
import com.dodopizza.databinding.ActivityMainBinding
import com.dodopizza.model.Pizza
import com.dodopizza.model.PizzaDataSource

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    private var pizza_adapter: PizzaAdapter? = null

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