package com.lua.mundocoletor

import android.app.Application
import com.lua.register.di.RegisterDi
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class AppMain: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@AppMain)
            RegisterDi.init()
        }
    }
}