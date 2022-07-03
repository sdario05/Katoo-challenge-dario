package com.icr.katoochallenge.cocktails.usecase

import com.icr.katoochallenge.cocktails.datasource.ICocktailsRepository

class GetCocktailsByIngredientUseCase(private val cocktailsRepository: ICocktailsRepository) {

    suspend fun fetchCocktailsByIngredient(ingredient: String) =
        cocktailsRepository.fetchCocktailsByIngredient(ingredient)
}