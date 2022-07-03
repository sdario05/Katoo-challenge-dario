package com.icr.katoochallenge.main.view

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.icr.katoochallenge.R
import com.icr.katoochallenge.cocktails.view.CocktailsActivity
import com.icr.katoochallenge.common.INGREDIENT_NAME
import com.icr.katoochallenge.main.adapter.IngredientsAdapter
import com.icr.katoochallenge.main.viewmodel.IngredientsViewModel
import org.koin.android.ext.android.inject
import kotlinx.android.synthetic.main.activity_ingredients.*

class IngredientsActivity:  AppCompatActivity() {

    private val viewModel: IngredientsViewModel by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ingredients)
        setTitle(R.string.ingredients)

        observeToLiveData()
        viewModel.getIngredients()
    }

    private fun observeToLiveData() {
        viewModel.ingredientsLiveData.observe(this, Observer {response ->
            progressBar.visibility = View.GONE
            rv_ingredients.adapter = IngredientsAdapter(
                response.drinks.map {it.ingredient },
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
        })
    }
}