package com.lua.desing_system.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import com.lua.common.EMPTY_STRING
import com.lua.desing_system.theme.DsColor.Support100
import com.lua.desing_system.theme.DsColor.Support200
import com.lua.desing_system.theme.Font
import com.lua.desing_system.theme.Size

@Composable
fun Toolbar(
    modifier: Modifier = Modifier,
    title: String = EMPTY_STRING,
    titleColor: Color = Support100,
    background: Color = Support200,
    icon: Icon = Icon.icon(),
    elevation: Dp = Size.Size0,
    isCapslockOn: Boolean = true,
    onStartIconClicked: () -> Unit = {},
    onEndIconClicked: () -> Unit = {},
) {
    TopAppBar(
        modifier = modifier,
        elevation = elevation,
        backgroundColor = background
    ) {
        Box(modifier = Modifier.fillMaxWidth()) {
            icon.startIcon?.let {
                ButtonIcon(
                    modifier = Modifier.align(alignment = Alignment.CenterStart),
                    icon = painterResource(id = icon.startIcon),
                    description = icon.iconStartDescription,
                    buttonColor = icon.color,
                    iconSize = Size.SizeLG,
                    onClick = onStartIconClicked
                )
            }
            Text(
                modifier = Modifier.align(alignment = Alignment.Center),
                text = if (isCapslockOn) title.uppercase() else title,
                textAlign = TextAlign.Center,
                style = Font.h1,
                color = titleColor,
            )
            icon.endIcon?.let {
                ButtonIcon(
                    modifier = Modifier.align(alignment = Alignment.CenterEnd),
                    icon = painterResource(id = icon.endIcon),
                    description = icon.iconEndDescription,
                    buttonColor = icon.color,
                    iconSize = Size.SizeLG,
                    onClick = onEndIconClicked
                )
            }
        }
    }
}

class Icon private constructor(
    val startIcon: Int?,
    val endIcon: Int?,
    val color: Color,
    val spacing: Dp,
    val iconStartDescription: String,
    val iconEndDescription: String,
) {
    companion object {
        @Composable
        fun icon(
            iconStart: Int? = null,
            iconStartDescription: String = EMPTY_STRING,
            iconEnd: Int? = null,
            spacing: Dp = Size.SizeSM,
            iconEndDescription: String = EMPTY_STRING,
            iconColor: Color = Support100
        ) = Icon(
            startIcon = iconStart,
            endIcon = iconEnd,
            color = iconColor,
            spacing = spacing,
            iconStartDescription = iconStartDescription,
            iconEndDescription = iconEndDescription
        )
    }
}