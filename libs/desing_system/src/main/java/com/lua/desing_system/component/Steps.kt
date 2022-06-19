package com.lua.desing_system.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import com.lua.desing_system.theme.DsColor
import com.lua.desing_system.theme.Line
import com.lua.desing_system.theme.Size


@Composable
fun Steps(
    progress: Int,
    modifier: Modifier = Modifier,
    backgroundColor: Color = DsColor.Support200,
    progressColor: Color = DsColor.Primary100,
    height: Dp = Size.SizeSM,
) {
    LinearProgressIndicator(
        modifier = modifier
            .height(height)
            .fillMaxWidth()
            .background(shape = RoundedCornerShape(Size.SizeXSM), color = DsColor.Support200)
            .border(width = Line.LineMD, color = DsColor.Support100),
        color = progressColor,
        backgroundColor = backgroundColor,
        progress = progress / 10f
    )
}