package com.dodopizza.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dodopizza.databinding.ItemElementBinding
import com.dodopizza.model.Pizza

class PizzaAdapter (
            private val onPizzaClick: (Pizza)-> Unit,
        ):RecyclerView.Adapter<PizzaAdapter.ViewHolder>(){

    private val pizzaList: ArrayList<Pizza> = ArrayList()
    fun setData(pizzas:ArrayList<Pizza>){
        pizzaList.clear()
        pizzaList.addAll(pizzas)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemElementBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun getItemCount() = pizzaList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(pizzaList[position])
    }

    inner class ViewHolder(
        private val binding: ItemElementBinding
    ): RecyclerView.ViewHolder(binding.root){
        fun bind(pizza: Pizza){
            with(binding) {
                pizzaImage.setImageResource(pizza.imageRes)
                pizzaTitle.text = pizza.title
                pizzaDescription.text = pizza.description
                pizzaPrice.text= pizza.price.toString()

                pizzaPrice.setOnClickListener {
                    onPizzaClick(pizza)
                }
                root.setOnClickListener{
                    onPizzaClick(pizza)
                }


            }
        }

    }

}