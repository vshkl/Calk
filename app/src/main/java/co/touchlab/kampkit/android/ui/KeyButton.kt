package co.touchlab.kampkit.android.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import co.touchlab.kampkit.android.ui.theme.BurntSienna
import co.touchlab.kampkit.android.ui.theme.EbonyClay
import co.touchlab.kampkit.android.ui.theme.MintFoam
import co.touchlab.kampkit.features.calculator.Key

@Composable
fun KeyButton(
    modifier: Modifier = Modifier,
    key: Key,
    onClick: (Key) -> Unit,
) {
    val keyText: String = when (key) {
        is Key.Plus -> "+"
        is Key.Minus -> "-"
        is Key.Multiply -> "×"
        is Key.Divide -> "÷"
        is Key.Equals -> "="
        is Key.Clear -> "AC"
        is Key.Decimal -> ","
        is Key.Percent -> "%"
        is Key.Parentheses -> "()"
        is Key.Backspace -> "⌫"
        is Key.Number -> key.number.toString()
    }

    val keyFontSize: Int = when (key) {
        is Key.Clear -> 22
        is Key.Decimal,
        is Key.Percent,
        is Key.Parentheses,
        is Key.Backspace -> 24
        is Key.Plus,
        is Key.Minus,
        is Key.Multiply,
        is Key.Divide,
        is Key.Equals,
        is Key.Number -> 28
    }
    val keyFontWeight: FontWeight = if (key is Key.Number)
        FontWeight.Medium else
        FontWeight.Normal

    val keyBackgroundColor: Color = if (key is Key.Equals)
        BurntSienna else
        MintFoam
    val keyTextColor: Color = when (key) {
        is Key.Plus,
        is Key.Minus,
        is Key.Multiply,
        is Key.Divide -> BurntSienna
        is Key.Clear,
        is Key.Decimal,
        is Key.Percent,
        is Key.Parentheses,
        is Key.Backspace,
        is Key.Number -> EbonyClay
        is Key.Equals -> MintFoam
    }

    Box(
        modifier = modifier
            .background(keyBackgroundColor)
            .aspectRatio(1.3F)
            .clickable { onClick(key) },
    ) {
        Text(
            modifier = Modifier
                .padding(8.dp)
                .align(Alignment.Center)
                .clickable { onClick(key) },
            text = keyText,
            fontSize = keyFontSize.sp,
            fontWeight = keyFontWeight,
            color = keyTextColor,
            textAlign = TextAlign.Center,
        )
    }
}

private class KeyProvider : PreviewParameterProvider<Key> {
    override val values: Sequence<Key> = sequenceOf(
        Key.Clear,
        Key.Backspace,
        Key.Divide,
        Key.Number(7),
        Key.Equals,
    )
}

@Preview
@Composable
fun KeyButtonPreview(
    @PreviewParameter(KeyProvider::class) key: Key,
) {
    Box(modifier = Modifier.width(100.dp)) {
        KeyButton(
            modifier = Modifier,
            key = key,
            onClick = {},
        )
    }
}
