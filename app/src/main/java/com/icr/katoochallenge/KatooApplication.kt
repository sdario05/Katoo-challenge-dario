package com.icr.katoochallenge

import android.app.Application
import com.icr.katoochallenge.koin.modules.KotlinApplication

class KatooApplication: Application() {

    companion object {
        lateinit var instance: Application
            private set
    }

    override fun onCreate() {
        super.onCreate()
        KotlinApplication.startKoin(this)
    }
}