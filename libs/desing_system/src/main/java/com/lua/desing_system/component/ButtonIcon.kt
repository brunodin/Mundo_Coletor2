package com.lua.desing_system.component

import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.unit.Dp
import com.lua.common.EMPTY_STRING
import com.lua.desing_system.theme.DsColor.Support100
import com.lua.desing_system.theme.Size.SizeMD

@Composable
fun ButtonIcon(
    icon: Painter,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    description: String = EMPTY_STRING,
    buttonColor: Color = Support100,
    iconSize: Dp = SizeMD
) {
    IconButton(
        modifier = modifier,
        onClick = onClick,
    ) {
        Icon(
            painter = icon,
            contentDescription = description,
            modifier = Modifier.size(size = iconSize),
            tint = buttonColor,
        )
    }
}