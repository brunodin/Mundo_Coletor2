package com.lua.desing_system.component

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.lua.desing_system.theme.DsColor
import com.lua.desing_system.theme.MundoColetorTheme
import com.lua.desing_system.util.CustomArrangement


@Composable
fun WaveBackGround(
    modifier: Modifier = Modifier,
    content: @Composable ColumnScope.() -> Unit
) {
    MundoColetorTheme {
        Column(
            modifier = modifier.fillMaxSize(),
            verticalArrangement = CustomArrangement.Bottom
        ) {
            WaveItem()
            content()
            WaveItem(isUpSideDown = true)
        }
    }
}

@Composable
fun WaveItem(
    modifier: Modifier = Modifier,
    color: Color = DsColor.Primary100,
    isUpSideDown: Boolean = false,
    height: Dp = 70.dp,
) {
    BoxWithConstraints(
        modifier = modifier
            .fillMaxWidth()
            .height(height * 1f)
    ) {
        val width = with(LocalDensity.current) { maxWidth.toPx() }
        val heightPx = with(LocalDensity.current) { maxHeight.toPx() }
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
            val shadowRadius: Dp = 8.dp
            val offsetY: Dp = 0.dp
            val offsetX: Dp = 0.dp
            val transparentColor = android.graphics.Color.toArgb(color.copy(alpha = 0.0f).value.toLong())
            val shadowColor = android.graphics.Color.toArgb(DsColor.Secondary100.copy(alpha = 0.5f).value.toLong())
            drawIntoCanvas {
                val paint = Paint()
                val frameworkPaint = paint.asFrameworkPaint()
                frameworkPaint.color = transparentColor
                frameworkPaint.setShadowLayer(
                    shadowRadius.toPx(),
                    offsetX.toPx(),
                    offsetY.toPx(),
                    shadowColor
                )
                it.drawPath(
                    path = path,
                    paint = paint
                )
            }
            drawPath(
                path = path,
                color = color,
            )
        }
    }
}