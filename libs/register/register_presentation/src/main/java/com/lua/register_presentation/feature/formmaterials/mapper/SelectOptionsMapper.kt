package com.lua.register_presentation.feature.formmaterials.mapper

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.lua.register_presentation.R
import com.lua.register_presentation.feature.formmaterials.FormMaterialSelectOptionEnum

@Composable
fun FormMaterialSelectOptionEnum.text() = when(this) {
    FormMaterialSelectOptionEnum.MY_ADDRESS -> stringResource(R.string.register_form_material_select_option_my_address)
    FormMaterialSelectOptionEnum.YOUR_ADDRESS -> stringResource(R.string.register_form_material_select_option_your_address)
    FormMaterialSelectOptionEnum.ALL -> stringResource(R.string.register_form_material_select_option_all)
}