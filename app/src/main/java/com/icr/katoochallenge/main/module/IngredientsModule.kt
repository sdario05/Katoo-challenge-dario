package com.icr.katoochallenge.main.module

import com.icr.katoochallenge.main.datasource.IMainRepository
import com.icr.katoochallenge.main.datasource.IMainService
import com.icr.katoochallenge.main.datasource.MainRepository
import com.icr.katoochallenge.main.usecase.GetIngredientsUseCase
import com.icr.katoochallenge.main.viewmodel.IngredientsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module
import retrofit2.Retrofit

val ingredientsModule: Module = module {

    //Inject viewModel
    viewModel {
        IngredientsViewModel(
            get()
        )
    }

    //Inject service
    single { providerMainService(get()) }

    //Inject repository
    single<IMainRepository> {
        MainRepository(
            mainService = get()
        )
    }

    //Inject useCase
    single { providerGetIngredientsUseCase(get()) }
}

fun providerGetIngredientsUseCase(mainRepository: IMainRepository): GetIngredientsUseCase {
    return GetIngredientsUseCase(mainRepository)
}

fun providerMainService(retrofit: Retrofit): IMainService {
    return retrofit.create(IMainService::class.java)
}