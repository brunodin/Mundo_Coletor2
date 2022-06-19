package com.lua.register.di

import com.lua.register_presentation.feature.formmaterials.FormMaterialsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { FormMaterialsViewModel() }
}