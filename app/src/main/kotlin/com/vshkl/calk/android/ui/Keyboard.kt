package com.vshkl.calk.android.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.vshkl.calk.model.Key

@Composable
fun Keyboard(
    modifier: Modifier = Modifier,
    onClick: (Key) -> Unit,
) {
    val keys: Array<Array<Key>> = arrayOf(
        arrayOf(Key.Clear, Key.Backspace, Key.Percent, Key.Divide),
        arrayOf(Key.Number(7), Key.Number(8), Key.Number(9), Key.Multiply),
        arrayOf(Key.Number(4), Key.Number(5), Key.Number(6), Key.Minus),
        arrayOf(Key.Number(1), Key.Number(2), Key.Number(3), Key.Plus),
        arrayOf(Key.Parentheses, Key.Number(0), Key.Decimal, Key.Equals),
    )

    Card(
        modifier = modifier,
        shape = MaterialTheme.shapes.large,
        elevation = 8.dp,
    ) {
        Column {
            for (row in keys) {
                Row(modifier = Modifier.fillMaxWidth()) {
                    for (key in row) {
                        KeyButton(
                            modifier = Modifier.weight(1F),
                            key = key,
                            onClick = onClick,
                        )
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun KeyboardPreview() {
    Keyboard(
        modifier = Modifier,
        onClick = { },
    )
}
