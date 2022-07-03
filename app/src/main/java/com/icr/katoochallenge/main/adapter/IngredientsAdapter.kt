package com.icr.katoochallenge.main.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.icr.katoochallenge.R

class IngredientsAdapter(
    private var items: List<String>,
    private val onIngredientClickListener: OnIngredientClickListener
): RecyclerView.Adapter<IngredientsAdapter.ViewHolderIngredients>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderIngredients {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.layout_item_ingredient, parent, false)
        return ViewHolderIngredients(view)
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: ViewHolderIngredients, position: Int) {
        holder.bind(items[position], onIngredientClickListener)
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setFilteredItems(filteredItems: List<String>) {
        items = filteredItems
        notifyDataSetChanged()
    }

    class ViewHolderIngredients(
        itemView: View
    ): RecyclerView.ViewHolder(itemView) {

        fun bind(name: String, onIngredientClickListener: OnIngredientClickListener) {
            itemView.findViewById<TextView>(R.id.txt_name).text = name
            itemView.setOnClickListener { onIngredientClickListener.onItemClick(name) }
        }
    }

    interface OnIngredientClickListener {
        fun onItemClick(name: String)
    }
}