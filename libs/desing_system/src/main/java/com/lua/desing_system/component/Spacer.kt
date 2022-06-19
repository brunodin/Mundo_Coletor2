package com.lua.desing_system.component

import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import com.lua.common.WEIGHT1
import com.lua.desing_system.theme.Size

@Composable
fun SpacerVertical(dp: Dp = Size.SizeSM) {
    Spacer(modifier = Modifier.height(dp))
}
@Composable
fun SpacerHorizontal(dp: Dp = Size.SizeSM) {
    Spacer(modifier = Modifier.width(dp))
}
@Composable
fun ColumnScope.SpacerWeight(weight: Float = WEIGHT1) {
    Spacer(modifier = Modifier.weight(weight))
}
@Composable
fun RowScope.SpacerWeight(weight: Float = WEIGHT1) {
    Spacer(modifier = Modifier.weight(weight))
}