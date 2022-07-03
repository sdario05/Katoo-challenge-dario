package com.icr.katoochallenge.main.view

import android.content.Intent
import android.content.res.ColorStateList
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import com.icr.katoochallenge.R
import com.icr.katoochallenge.cocktails.view.CocktailsActivity
import com.icr.katoochallenge.common.INGREDIENT_NAME
import com.icr.katoochallenge.common.onTextChanged
import com.icr.katoochallenge.main.adapter.IngredientsAdapter
import com.icr.katoochallenge.main.model.Ingredient
import com.icr.katoochallenge.main.viewmodel.IngredientsViewModel
import org.koin.android.ext.android.inject
import kotlinx.android.synthetic.main.activity_ingredients.*

class IngredientsActivity:  AppCompatActivity() {

    private val viewModel: IngredientsViewModel by inject()
    private var ingredients: List<Ingredient>? = null
    private var adapter: IngredientsAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ingredients)
        setTitle(R.string.ingredients)

        observeToLiveData()
        viewModel.getIngredients()
        setListeners()
    }

    private fun observeToLiveData() {
        viewModel.ingredientsLiveData.observe(this, Observer {response ->
            ingredients = response.ingredients

            et_search.apply {
                isEnabled = true
                hint = getString(R.string.enter_ingredient)
                backgroundTintList = ColorStateList.valueOf(
                    ContextCompat.getColor(this@IngredientsActivity, R.color.white)
                )
            }
            progressBar.visibility = View.GONE

            adapter = IngredientsAdapter(
                response.ingredients.map { it.ingredient },
                object: IngredientsAdapter.OnIngredientClickListener {
                    override fun onItemClick(name: String) {
                        val intent = Intent(
                            this@IngredientsActivity,
                            CocktailsActivity::class.java
                        )
                        intent.putExtra(INGREDIENT_NAME, name)
                        startActivity(intent)
                    }
                }
            )
            rv_ingredients.adapter = adapter
        })
    }

    private fun setListeners() {
        et_search.onTextChanged {text ->
            if (text.isNotEmpty()) {
                img_clear.visibility = View.VISIBLE
            } else {
                img_clear.visibility = View.GONE
            }
            val filter = ingredients?.filter { it.ingredient.lowercase().contains(text.lowercase()) }
            filter?.let {items ->
                (adapter as IngredientsAdapter).setFilteredItems(items.map { it.ingredient })
            }
        }
        img_clear.setOnClickListener {
            et_search.setText("")
            img_clear.visibility = View.GONE
        }
    }
}