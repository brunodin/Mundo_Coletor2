package com.lua.desing_system.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable

private val DarkColorPalette = darkColors(
    primary = DsColor.Primary100,
    primaryVariant = DsColor.Primary40,
    secondary = DsColor.Primary10,
    onSurface = DsColor.Support100
)

private val LightColorPalette = lightColors(
    primary = DsColor.Primary100,
    primaryVariant = DsColor.Primary40,
    secondary = DsColor.Primary10,
    onSurface = DsColor.Support100

    /* Other default colors to override
    background = Color.White,
    surface = Color.White,
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black,
    */
)

@Composable
fun MundoColetorTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = Font,
        shapes = Shapes,
        content = content
    )
}