package com.icr.katoochallenge.main.datasource

import com.icr.katoochallenge.main.model.IngredientsResponse

interface IMainRepository {

    suspend fun fetchIngredients(): IngredientsResponse
}