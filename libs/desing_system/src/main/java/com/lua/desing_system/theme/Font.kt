package com.lua.desing_system.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import com.lua.desing_system.R

val fonts = FontFamily(
    Font(R.font.assistant_bold, weight = FontWeight.Bold),
    Font(R.font.assistant_extra_bold, weight = FontWeight.ExtraBold),
    Font(R.font.assistant_extra_light, weight = FontWeight.ExtraLight),
    Font(R.font.assistant_light, weight = FontWeight.Light),
    Font(R.font.assistant_medium, weight = FontWeight.Medium),
    Font(R.font.assistant_regular, weight = FontWeight.Normal),
    Font(R.font.assistant_semibold, weight = FontWeight.SemiBold)
)

val Font = Typography(
    h1 = TextStyle(
        fontWeight = FontWeight.Bold,
        fontFamily = fonts,
        lineHeight = DsFontSize.XLG,
        fontSize = DsFontSize.LG
    ),
    h2 = TextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = DsFontSize.MD
    ),
    h3 = TextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = DsFontSize.SM
    ),
    h4 = TextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = DsFontSize.XSM
    ),
    button = TextStyle(
        fontWeight = FontWeight.Bold,
        fontSize = DsFontSize.MD
    )
)

inline val Typography.span14 get() = TextStyle(
    fontWeight = FontWeight.SemiBold,
    fontFamily = fonts,
    fontSize = DsFontSize.MD
)

inline val Typography.span12 get() = TextStyle(
    fontWeight = FontWeight.Medium,
    fontFamily = fonts,
    fontSize = DsFontSize.SM
)
inline val Typography.h3Bold get() = h3.copy(fontWeight = FontWeight.Bold)
inline val Typography.h4Bold get() = h4.copy(fontWeight = FontWeight.Bold)