package com.lua.desing_system.component

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsFocusedAsState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import com.lua.common.EMPTY_STRING
import com.lua.desing_system.theme.DsColor
import com.lua.desing_system.theme.Font
import com.lua.desing_system.theme.Size

private const val ONE_LINE = 1

@Composable
fun TextField(
    text: String,
    onTextChanged: (String) -> Unit,
    modifier: Modifier = Modifier,
    isEnable: Boolean = true,
    isReadOnly: Boolean = false,
    style: TextStyle = Font.h2,
    hint: String = EMPTY_STRING,
    leadingIcon: @Composable (() -> Unit)? = null,
    trailingIcon: @Composable (() -> Unit)? = null,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    keyboardActions: KeyboardActions = KeyboardActions(),
    maxLines: Int = Int.MAX_VALUE
) {
    var hintText = hint
    val interaction = remember { MutableInteractionSource() }
    val focus by interaction.collectIsFocusedAsState()
    LaunchedEffect(key1 = focus) {
        hintText = if (focus) EMPTY_STRING else hint
    }
    Box {
        OutlinedTextField(
            value = text,
            onValueChange = onTextChanged,
            modifier = modifier,
            enabled = isEnable,
            readOnly = isReadOnly,
            textStyle = style,
            leadingIcon = leadingIcon,
            trailingIcon = trailingIcon,
            isError = false,
            visualTransformation = visualTransformation,
            keyboardOptions = keyboardOptions,
            keyboardActions = keyboardActions,
            singleLine = maxLines == ONE_LINE,
            maxLines = maxLines,
            interactionSource = interaction,
        )
        if (hintText.isNotEmpty()) {
            Text(
                modifier = Modifier
                    .align(alignment = Alignment.CenterStart)
                    .padding(horizontal = Size.SizeSM),
                text = hintText,
                style = Font.h2,
                color = DsColor.Secondary40
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun Preview() {
    TextField(hint = "ola", text = "", onTextChanged = {})
}