package com.lua.desing_system.component

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.lua.desing_system.theme.DsColor
import com.lua.desing_system.theme.Line


@Composable
fun WaveItem(
    modifier: Modifier = Modifier,
    color: Color = DsColor.Primary100,
    isUpSideDown: Boolean = false,
    height: Dp = 70.dp,
) {
    BoxWithConstraints(modifier = modifier.fillMaxWidth().height(height * 0.9f)) {
        val width = constraints.maxWidth.toFloat()
        val heightPx = with(LocalDensity.current) { height.toPx() }
        val point1 = Offset(x = 0f, y = heightPx * 0.8f)

        val path = Path().apply {
            moveTo(x = point1.x, y = point1.y)
            cubicTo(
                x1 = width * 0.50f,
                y1 = heightPx + (heightPx * 0.2f),
                x2 = width * 0.55f,
                y2 = -(heightPx * 0.50f),
                x3 = width,
                y3 = heightPx * 0.8f
            )
            lineTo(width, 0f)
            lineTo(0f, 0f)
            close()
        }
        Canvas(
            modifier = Modifier
                .fillMaxSize()
                .graphicsLayer {
                rotationX = if (isUpSideDown) 180f else 0f
                rotationY = if (isUpSideDown) 180f else 0f
            }
        ) {
            drawPath(
                path = path,
                color = color,
            )
        }
    }
}