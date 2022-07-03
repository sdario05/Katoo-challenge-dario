package com.icr.katoochallenge.cocktails.view

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.icr.katoochallenge.R
import com.icr.katoochallenge.cocktails.adapter.CocktailsAdapter
import com.icr.katoochallenge.cocktails.viewmodel.CocktailsViewModel
import com.icr.katoochallenge.common.INGREDIENT_NAME
import kotlinx.android.synthetic.main.activity_cocktails.*
import org.koin.android.ext.android.inject

class CocktailsActivity: AppCompatActivity() {

    private val viewModel: CocktailsViewModel by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cocktails)
        setTitle(R.string.cocktails)

        observeToLiveData()
        intent.getStringExtra(INGREDIENT_NAME)?.let {
            viewModel.getCocktailsByIngredient(it)
        }
    }

    private fun observeToLiveData() {
        viewModel.cocktailsLiveData.observe(this, Observer {response ->
            progressBar.visibility = View.GONE
            rv_cocktails.adapter = CocktailsAdapter(
                response.drinks
            )
        })
    }
}