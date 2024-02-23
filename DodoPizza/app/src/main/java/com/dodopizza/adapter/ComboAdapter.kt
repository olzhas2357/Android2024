package com.dodopizza.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView
import com.dodopizza.databinding.ItemComboElementBinding
import com.dodopizza.model.Pizza

class ComboAdapter (
            private val onComboClick: (Pizza) -> Unit,
        ): RecyclerView.Adapter<ComboAdapter.ViewHolder>() {

    private val comboList: ArrayList<Pizza> = ArrayList()

    fun setData(combos: ArrayList<Pizza>) {
        comboList.clear()
        comboList.addAll(combos)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemComboElementBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun getItemCount() = comboList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(comboList[position])
    }

    inner class ViewHolder(
        private val binding: ItemComboElementBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        val comboPrice: Button = binding.comboPrice

        fun bind(pizza: Pizza) {
            with(binding){
                comboImg.setImageResource(pizza.imageRes)
                comboName.text = pizza.title
                comboDesc.text = pizza.description
                comboPrice.text = pizza.price.toString()
                root.setOnClickListener {
                    onComboClick(pizza)
                }
                comboPrice.setOnClickListener {
                    onComboClick(pizza)
                }
            }
        }
    }
}

