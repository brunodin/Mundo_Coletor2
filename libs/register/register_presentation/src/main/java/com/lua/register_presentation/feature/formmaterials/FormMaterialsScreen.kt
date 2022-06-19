package com.lua.register_presentation.feature.formmaterials

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.lua.desing_system.R
import com.lua.desing_system.component.ButtonIcon
import com.lua.desing_system.component.Icon
import com.lua.desing_system.component.SpacerVertical
import com.lua.desing_system.component.SpacerWeight
import com.lua.desing_system.component.Steps
import com.lua.desing_system.component.TextField
import com.lua.desing_system.component.Toolbar
import com.lua.desing_system.component.WaveItem
import com.lua.desing_system.theme.DsColor
import com.lua.desing_system.theme.Font
import com.lua.desing_system.theme.Line
import com.lua.desing_system.theme.Size
import com.lua.desing_system.theme.span14
import com.lua.desing_system.util.CustomArrangement
import com.lua.register_presentation.R.string
import org.koin.androidx.compose.getViewModel

@Composable
fun FormMaterialsScreen(
    viewModel: FormMaterialsViewModel = getViewModel()
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = CustomArrangement.Bottom
    ) {
        WaveItem()
        Toolbar(onActionPerformed = {})
        SpacerVertical()
        Steps()
        SpacerVertical()
        TypesMaterialsText()
        SpacerVertical(Size.SizeMD)
        AddMoreMaterialsRow()
        Card(
            modifier = Modifier.padding(horizontal = Size.SizeMD),
            border = BorderStroke(width = Line.LineMD, color = DsColor.Secondary10),
            shape = MaterialTheme.shapes.medium
        ) {
            Column(modifier = Modifier
                .fillMaxWidth()
                .padding(all = Size.SizeXSM)) {
                TextField(
                    text = "",
                    onTextChanged = {},
                    hint = stringResource(id = string.register_form_material_select_kind_material)
                )
            }
        }
        WaveItem(isUpSideDown = true)
    }
}

@Composable
private fun Toolbar(onActionPerformed: (FormMaterialsAction) -> Unit) {
    Toolbar(
        icon = Icon.icon(iconStart = R.drawable.ic_arrow_back),
        title = "Teste",
        onStartIconClicked = { onActionPerformed(FormMaterialsAction.BackButtonAction) }
    )
}

@Composable
private fun Steps() {
    Steps(progress = 5, modifier = Modifier.padding(horizontal = Size.SizeMD))
}

@Composable
private fun TypesMaterialsText() {
    Text(
        text = stringResource(id = string.register_form_materials_title),
        style = Font.h1,
        modifier = Modifier.padding(horizontal = Size.SizeMD)
    )
}

@Composable
private fun AddMoreMaterialsRow() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(
            text = stringResource(id = string.register_form_material_select_material),
            style = Font.span14,
            modifier = Modifier.padding(start = Size.SizeMD)
        )
        SpacerWeight()
        ButtonIcon(
            modifier = Modifier
                .padding(end = Size.SizeMD)
                .clip(shape = MaterialTheme.shapes.medium)
                .background(color = DsColor.Primary100)
                .border(
                    width = Line.LineMD,
                    color = DsColor.Secondary100,
                    shape = MaterialTheme.shapes.medium
                ),
            icon = painterResource(id = R.drawable.ic_add),
            onClick = {}
        )
    }
}