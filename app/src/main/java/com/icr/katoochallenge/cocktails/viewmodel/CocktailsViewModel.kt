package com.icr.katoochallenge.cocktails.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.icr.katoochallenge.cocktails.model.CocktailsResponse
import com.icr.katoochallenge.cocktails.usecase.GetCocktailsByIngredientUseCase
import kotlinx.coroutines.launch

class CocktailsViewModel(
    private val getCocktailsUseCase: GetCocktailsByIngredientUseCase
): ViewModel() {

    val cocktailsLiveData = MutableLiveData<CocktailsResponse>()

    fun getCocktailsByIngredient(ingredient: String) {
        viewModelScope.launch {
            cocktailsLiveData.postValue(getCocktailsUseCase.fetchCocktailsByIngredient(ingredient))
        }
    }
}