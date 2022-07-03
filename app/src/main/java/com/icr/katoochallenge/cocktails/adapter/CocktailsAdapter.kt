package com.icr.katoochallenge.cocktails.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.icr.katoochallenge.R
import com.icr.katoochallenge.cocktails.model.Cocktail

class CocktailsAdapter(
    private val items: List<Cocktail>
): RecyclerView.Adapter<CocktailsAdapter.ViewHolderCocktails>() {
    private var context: Context? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderCocktails {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.layout_item_cocktail, parent, false)
        context = parent.context
        return ViewHolderCocktails(view)
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: ViewHolderCocktails, position: Int) {
        holder.bind(items[position], context)
    }

    class ViewHolderCocktails(
        itemView: View
    ): RecyclerView.ViewHolder(itemView) {

        fun bind(cocktail: Cocktail, context: Context?) {
            itemView.findViewById<TextView>(R.id.txt_name).text = cocktail.name
            context?.let {
                Glide.with(it)
                    .load(cocktail.image)
                    .placeholder(ContextCompat.getDrawable(context, R.drawable.img_placeholder))
                    .into(itemView.findViewById<ImageView>(R.id.img_drink))
            }
        }
    }
}