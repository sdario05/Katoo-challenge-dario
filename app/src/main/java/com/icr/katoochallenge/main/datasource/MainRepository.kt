package com.icr.katoochallenge.main.datasource

import com.icr.katoochallenge.main.model.IngredientsResponse

class MainRepository(private val mainService: IMainService): IMainRepository {

    override suspend fun fetchIngredients(): IngredientsResponse {
        return mainService.fetchIngredients()
    }
}