package com.icr.katoochallenge.cocktails.datasource

import com.icr.katoochallenge.cocktails.model.CocktailsResponse

class CocktailsRepository(private val cocktailsService: ICocktailsService): ICocktailsRepository {

    override suspend fun fetchCocktailsByIngredient(ingredient: String): CocktailsResponse {
        return cocktailsService.fetchCocktailsByIngredient(ingredient)
    }
}