package com.icr.katoochallenge.cocktails.module

import com.icr.katoochallenge.cocktails.datasource.CocktailsRepository
import com.icr.katoochallenge.cocktails.datasource.ICocktailsRepository
import com.icr.katoochallenge.cocktails.datasource.ICocktailsService
import com.icr.katoochallenge.cocktails.usecase.GetCocktailsByIngredientUseCase
import com.icr.katoochallenge.cocktails.viewmodel.CocktailsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module
import retrofit2.Retrofit

val cocktailsModule: Module = module {

    //Inject viewModel
    viewModel {
        CocktailsViewModel(
            get()
        )
    }

    //Inject service
    single { providerCocktailsService(get()) }

    //Inject repository
    single<ICocktailsRepository> {
        CocktailsRepository(
            cocktailsService = get()
        )
    }

    //Inject useCase
    single { providerGetCocktailsByIngredientUseCase(get()) }
}

fun providerGetCocktailsByIngredientUseCase(cocktailsRepository: ICocktailsRepository): GetCocktailsByIngredientUseCase {
    return GetCocktailsByIngredientUseCase(cocktailsRepository)
}

fun providerCocktailsService(retrofit: Retrofit): ICocktailsService {
    return retrofit.create(ICocktailsService::class.java)
}