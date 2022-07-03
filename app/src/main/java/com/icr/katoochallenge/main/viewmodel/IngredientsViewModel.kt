package com.icr.katoochallenge.main.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.icr.katoochallenge.main.model.IngredientsResponse
import com.icr.katoochallenge.main.usecase.GetIngredientsUseCase
import kotlinx.coroutines.launch

class IngredientsViewModel(
    private val getIngredientsUseCase: GetIngredientsUseCase
): ViewModel() {

    val ingredientsLiveData = MutableLiveData<IngredientsResponse>()

    fun getIngredients() {
        viewModelScope.launch {
            ingredientsLiveData.postValue(getIngredientsUseCase.fetchIngredients())
        }
    }
}