package com.lua.register.di

import org.koin.core.context.GlobalContext.loadKoinModules

object RegisterDi {

    fun init() = loadKoinModules(viewModelModule)
}