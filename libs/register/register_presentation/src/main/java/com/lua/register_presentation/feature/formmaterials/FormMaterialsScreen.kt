package com.lua.register_presentation.feature.formmaterials

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.lua.desing_system.R
import com.lua.desing_system.component.ButtonIcon
import com.lua.desing_system.component.ButtonWidth
import com.lua.desing_system.component.CheckBox
import com.lua.desing_system.component.DefaultButton
import com.lua.desing_system.component.Icon
import com.lua.desing_system.component.SpacerVertical
import com.lua.desing_system.component.SpacerWeight
import com.lua.desing_system.component.Steps
import com.lua.desing_system.component.TextField
import com.lua.desing_system.component.Toolbar
import com.lua.desing_system.component.WaveBackGround
import com.lua.desing_system.component.WaveItem
import com.lua.desing_system.theme.DsColor
import com.lua.desing_system.theme.Font
import com.lua.desing_system.theme.Line
import com.lua.desing_system.theme.Size
import com.lua.desing_system.theme.span14
import com.lua.desing_system.util.CustomArrangement
import com.lua.register_presentation.R.string
import com.lua.register_presentation.feature.formmaterials.mapper.text
import org.koin.androidx.compose.getViewModel

@Composable
fun FormMaterialsScreen(
    viewModel: FormMaterialsViewModel = getViewModel()
) {
    Screen()
}

@Composable
private fun Screen() {
    Scaffold() {
        
    }
    WaveBackGround(
        modifier = Modifier.verticalScroll(state = rememberScrollState()),
    ) {
        Toolbar(onActionPerformed = {})
        SpacerVertical()
        Steps()
        SpacerVertical()
        TypesMaterialsText()
        SpacerVertical()
        AddMoreMaterialsRow()
        SpacerVertical()
        MaterialInformationCard()
        SpacerVertical()
        SelectAnOptionText()
        SpacerVertical()
        MultipleCheckBoxes()
        SpacerVertical()
        ContinueButton()
    }
}

@Composable
private fun Toolbar(onActionPerformed: (FormMaterialsAction) -> Unit) {
    Toolbar(
        icon = Icon.icon(iconStart = R.drawable.ic_arrow_back),
        onStartIconClicked = { onActionPerformed(FormMaterialsAction.BackButtonAction) }
    )
}

@Composable
private fun Steps() {
    Steps(progress = 5, modifier = Modifier.padding(horizontal = Size.SizeMD))
}

@Composable
private fun MaterialInformationCard() {
    Card(
        modifier = Modifier.padding(horizontal = Size.SizeMD, vertical = Size.Size2XSM),
        border = BorderStroke(width = Line.LineMD, color = DsColor.Secondary10),
        shape = MaterialTheme.shapes.medium,
        backgroundColor = DsColor.Support200
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(all = Size.SizeXSM)
        ) {
            TextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(all = Size.Size0),
                text = "",
                onTextChanged = {},
                hint = stringResource(id = string.register_form_material_select_kind_material)
            )
            SpacerVertical(dp = Size.SizeSM)
            TextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(all = Size.Size0),
                text = "",
                onTextChanged = {},
                hint = stringResource(id = string.register_form_material_select_describe_material)
            )
        }
    }
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
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = stringResource(id = string.register_form_material_select_material),
            style = Font.span14,
            modifier = Modifier.padding(start = Size.SizeMD)
        )
        ButtonIcon(
            modifier = Modifier
                .padding(end = Size.SizeMD)
                .clip(shape = MaterialTheme.shapes.medium)
                .background(color = DsColor.Primary100)
                .border(
                    width = Line.LineMD,
                    color = DsColor.Secondary100,
                    shape = MaterialTheme.shapes.medium
                )
                .size(size = Size.SizeXLG),
            iconSize = Size.SizeSM,
            icon = painterResource(id = R.drawable.ic_add),
            onClick = {}
        )
    }
}

@Composable
private fun SelectAnOptionText() {
    Text(
        text = stringResource(id = string.register_form_material_select_an_option),
        style = Font.span14,
        modifier = Modifier.padding(start = Size.SizeMD)
    )
}

@Composable
private fun MultipleCheckBoxes() {
    FormMaterialSelectOptionEnum.values().forEach { option ->
        CheckBox(
            modifier = Modifier.padding(horizontal = Size.SizeXSM),
            text = option.text(),
            isChecked = true,
            onCheckedChange = {}
        )
    }
}

@Composable
private fun ContinueButton() {
    DefaultButton(
        modifier = Modifier.padding(horizontal = Size.SizeMD, vertical = Size.Size2XSM),
        onClick = { /*TODO*/ },
        text = stringResource(id = string.register_form_material_continue),
        buttonWidth = ButtonWidth.fill()
    )
}

@Preview(showBackground = true)
@Composable
private fun Preview() {
    Screen()
}