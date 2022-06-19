package com.lua.desing_system.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import com.lua.common.EMPTY_STRING
import com.lua.desing_system.theme.DsColor
import com.lua.desing_system.theme.Font
import com.lua.desing_system.theme.Line
import com.lua.desing_system.theme.Size

@Composable
fun DefaultButton(
    modifier: Modifier = Modifier,
    text: String = EMPTY_STRING,
    onClick: () -> Unit,
    textStyle: TextStyle = Font.button,
    isEnable: Boolean = true,
    buttonStyle: ButtonStyle = ButtonStyle.primary(),
    buttonHeight: Dp = Size.SizeXLG,
    icon: Icon = Icon.icon(),
    horizontalArrangement: Arrangement.Horizontal = Arrangement.Center,
    buttonWidth: ButtonWidth = ButtonWidth.fill(),
) {
    Button(
        onClick = onClick,
        modifier = modifier.height(height = buttonHeight),
        enabled = isEnable,
        shape = buttonStyle.shape,
        elevation = ButtonDefaults.elevation(
            defaultElevation = buttonStyle.elevation,
            disabledElevation = Size.Size0,
            pressedElevation = Size.Size0
        ),
        border = buttonStyle.stroke?.let { stroke ->
            BorderStroke(width = stroke.width, color = if (isEnable) stroke.color else DsColor.Secondary40)
        },
        colors = ButtonDefaults.buttonColors(backgroundColor = if (isEnable) buttonStyle.color else DsColor.Primary10),
    ) {
        Row(
            modifier = buttonWidth.width,
            horizontalArrangement = horizontalArrangement
        ) {
            icon.startIcon?.let { startIcon ->
                ButtonIcon(
                    description = icon.iconStartDescription,
                    startIcon = startIcon,
                    color = icon.color
                )
                SpacerHorizontal(dp = icon.spacing)
            }
            if (text.isNotEmpty()) {
                Text(
                    text = if (buttonStyle.isCapslockActive) text.uppercase() else text,
                    style = textStyle,
                    textAlign = TextAlign.Center,
                    color = if (isEnable) DsColor.Secondary100 else DsColor.Secondary40
                )
            }
            icon.endIcon?.let { endIcon ->
                SpacerHorizontal(dp = icon.spacing)
                ButtonIcon(
                    description = icon.iconStartDescription,
                    startIcon = endIcon,
                    color = icon.color
                )
            }
        }
    }
}

@Composable
private fun ButtonIcon(
    startIcon: Int,
    description: String,
    color: Color
) {
    Icon(
        tint = color,
        painter = painterResource(id = startIcon),
        contentDescription = description,
        modifier = Modifier.size(size = Size.SizeMD),
    )
}

data class ButtonWidth(
    val width: Modifier,
) {
    companion object {
        @Composable
        fun fill() = ButtonWidth(Modifier.fillMaxWidth())

        @Composable
        fun wrapContent() = ButtonWidth(Modifier.wrapContentSize())
    }
}

data class ButtonStyle constructor(
    val color: Color,
    val stroke: Stroke?,
    val elevation: Dp,
    val shape: Shape,
    val isCapslockActive: Boolean,
) {
    companion object {
        @Composable
        fun primary() = ButtonStyle(
            color = DsColor.Primary100,
            stroke = Stroke(width = Line.LineMD, color = DsColor.Secondary100),
            elevation = Size.Size0,
            shape = MaterialTheme.shapes.medium,
            isCapslockActive = true
        )
        @Composable
        fun outline() = ButtonStyle(
            color = DsColor.Secondary100,
            stroke = Stroke(width = Line.LineMD, color = DsColor.Support200),
            elevation = Size.Size0,
            shape = MaterialTheme.shapes.medium,
            isCapslockActive = true
        )
    }
}

data class Stroke(
    val width: Dp,
    val color: Color,
)