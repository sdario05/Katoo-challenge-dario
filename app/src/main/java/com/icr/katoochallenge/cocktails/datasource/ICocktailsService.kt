package com.icr.katoochallenge.cocktails.datasource

import com.icr.katoochallenge.cocktails.model.CocktailsResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ICocktailsService {

    @GET("json/v1/1/filter.php")
    suspend fun fetchCocktailsByIngredient(@Query("i") name: String): CocktailsResponse
}