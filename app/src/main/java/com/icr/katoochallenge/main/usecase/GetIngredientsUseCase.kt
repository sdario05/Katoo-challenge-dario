package com.icr.katoochallenge.main.usecase

import com.icr.katoochallenge.main.datasource.IMainRepository

class GetIngredientsUseCase(private val mainRepository: IMainRepository) {

    suspend fun fetchIngredients() = mainRepository.fetchIngredients()
}