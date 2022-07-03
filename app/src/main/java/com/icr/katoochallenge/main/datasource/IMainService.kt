package com.icr.katoochallenge.main.datasource

import com.icr.katoochallenge.main.model.IngredientsResponse
import retrofit2.http.GET

interface IMainService {

    @GET("json/v1/1/list.php?i=list")
    suspend fun fetchIngredients(): IngredientsResponse
}