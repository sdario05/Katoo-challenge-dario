package com.icr.katoochallenge.core.base.repository

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val apiCommonsModule = module {
    single {
        providesOkHttp()
    }
}

//Commons
fun providerRetrofit(client: OkHttpClient): Retrofit {
    return Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl("http://www.thecocktaildb.com/api/")
        .client(client)
        .build()
}

fun providesOkHttp(): OkHttpClient {
    val logging = HttpLoggingInterceptor()
    logging.level = HttpLoggingInterceptor.Level.BODY
    return OkHttpClient.Builder().apply {
        addInterceptor(logging)
        readTimeout(30000, TimeUnit.MILLISECONDS)
    }.build()
}

