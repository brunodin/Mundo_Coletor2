package com.lua.desing_system.component

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Checkbox
import androidx.compose.material.CheckboxDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.lua.desing_system.theme.DsColor
import com.lua.desing_system.theme.Font
import com.lua.desing_system.theme.Size
import com.lua.desing_system.theme.span12

@Composable
fun CheckBox(
    text: String,
    isChecked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Checkbox(
            checked = isChecked,
            onCheckedChange = onCheckedChange,
            colors = CheckboxDefaults.colors(
                checkedColor = DsColor.Primary100,
                checkmarkColor = DsColor.Primary10,
                uncheckedColor = DsColor.Secondary20
            )
        )
        SpacerHorizontal(dp = Size.SizeXSM)
        Text(
            text = text,
            style = Font.span12
        )
    }
}