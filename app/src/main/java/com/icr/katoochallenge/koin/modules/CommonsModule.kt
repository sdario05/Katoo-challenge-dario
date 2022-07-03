package com.icr.katoochallenge.koin.modules

import com.icr.katoochallenge.cocktails.module.cocktailsModule
import com.icr.katoochallenge.core.base.repository.apiModule
import com.icr.katoochallenge.core.base.repository.apiCommonsModule
import com.icr.katoochallenge.koin.modules.KotlinApplication.concatenate
import com.icr.katoochallenge.main.module.ingredientsModule
import org.koin.core.module.Module

object CommonsModule {

    fun getModules(): List<Module>{
        return concatenate(
            getApiModules()
        )
    }

    private fun getApiModules(): List<Module>{
        return listOf(
            apiCommonsModule,
            apiModule,
            ingredientsModule,
            cocktailsModule
        )
    }
}