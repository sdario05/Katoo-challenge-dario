package com.icr.katoochallenge.koin.modules

import android.content.Context
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.logger.Level

object KotlinApplication {

    fun startKoin(contextApplication: Context) {
        org.koin.core.context.startKoin {
            androidLogger(Level.INFO)
            androidContext(contextApplication)
            koin.loadModules(
                concatenate(
                    CommonsModule.getModules(),
                )
            )
            koin.createRootScope()
        }
    }

    fun <T> concatenate(vararg lists: List<T>): List<T> {
        return listOf(*lists).flatten()
    }
}