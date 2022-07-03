package com.icr.katoochallenge.core.base.repository

import org.koin.dsl.module

val apiModule = module {
    single {
        providerRetrofit(get())
    }
}