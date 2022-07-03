package com.icr.katoochallenge.cocktails.datasource

import com.icr.katoochallenge.cocktails.model.CocktailsResponse

interface ICocktailsRepository {

    suspend fun fetchCocktailsByIngredient(ingredient: String): CocktailsResponse
}