package com.icr.katoochallenge.main.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.icr.katoochallenge.R

class IngredientsAdapter(
    private val items: List<String>,
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