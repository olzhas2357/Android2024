package com.dodopizza

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.dodopizza.adapter.PizzaAdapter
import com.dodopizza.databinding.ActivityMainBinding
import com.dodopizza.model.Pizza
import com.dodopizza.model.PizzaDataSource

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    private var adapter: PizzaAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        PizzaAdapter(
            onPizzaClick = {
//                Toast.makeText(this, it.title, Toast.LENGTH_SHORT).show()
                handleMovieClick(it)
            },
            onPizzaRemoved ={
                handlePizzaRemoval(it)
            }
        )
        adapter  = PizzaAdapter(
            onPizzaClick = {
//                Toast.makeText(this, it.title, Toast.LENGTH_SHORT).show()
                handleMovieClick(it)
            },
            onPizzaRemoved ={
                handlePizzaRemoval(it)
            }
        )

        binding.recyclerView.adapter = adapter
        adapter?.setData(PizzaDataSource.pizzaList)

    }
    private fun handleMovieClick(pizza: Pizza){
        val intent = Intent(this, SecondActivity::class.java)
        intent.putExtra(SecondActivity.KEY_RESULT, pizza.description)
        intent.putExtra(SecondActivity.KEY_IMAGE, pizza.imageRes)
        startActivity(intent)
    }
    private fun handlePizzaRemoval(pizza: Pizza){
        val pizzaList = PizzaDataSource.pizzaList
        pizzaList.remove(pizza)
        adapter?.setData(pizzaList)
    }
}