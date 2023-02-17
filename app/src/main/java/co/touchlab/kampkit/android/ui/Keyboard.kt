package co.touchlab.kampkit.android.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import co.touchlab.kampkit.features.calculator.Key

@Composable
fun Keyboard(
    modifier: Modifier = Modifier,
    onClick: (Key) -> Unit,
) {
    Card(
        modifier = modifier,
        shape = MaterialTheme.shapes.large,
        elevation = 8.dp,
    ) {
        Column {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
            ) {
                KeyButton(modifier = Modifier.weight(1F), key = Key.Clear, onClick = onClick)
                KeyButton(modifier = Modifier.weight(1F), key = Key.Backspace, onClick = onClick)
                KeyButton(modifier = Modifier.weight(1F), key = Key.Percent, onClick = onClick)
                KeyButton(modifier = Modifier.weight(1F), key = Key.Divide, onClick = onClick)
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
            ) {
                KeyButton(modifier = Modifier.weight(1F), key = Key.Number(7), onClick = onClick)
                KeyButton(modifier = Modifier.weight(1F), key = Key.Number(8), onClick = onClick)
                KeyButton(modifier = Modifier.weight(1F), key = Key.Number(9), onClick = onClick)
                KeyButton(modifier = Modifier.weight(1F), key = Key.Multiply, onClick = onClick)
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
            ) {
                KeyButton(modifier = Modifier.weight(1F), key = Key.Number(4), onClick = onClick)
                KeyButton(modifier = Modifier.weight(1F), key = Key.Number(5), onClick = onClick)
                KeyButton(modifier = Modifier.weight(1F), key = Key.Number(6), onClick = onClick)
                KeyButton(modifier = Modifier.weight(1F), key = Key.Minus, onClick = onClick)
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
            ) {
                KeyButton(modifier = Modifier.weight(1F), key = Key.Number(1), onClick = onClick)
                KeyButton(modifier = Modifier.weight(1F), key = Key.Number(2), onClick = onClick)
                KeyButton(modifier = Modifier.weight(1F), key = Key.Number(3), onClick = onClick)
                KeyButton(modifier = Modifier.weight(1F), key = Key.Plus, onClick = onClick)
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
            ) {
                KeyButton(modifier = Modifier.weight(1F), key = Key.Decimal, onClick = onClick)
                KeyButton(modifier = Modifier.weight(1F), key = Key.Number(0), onClick = onClick)
                KeyButton(modifier = Modifier.weight(1F), key = Key.Parentheses, onClick = onClick)
                KeyButton(modifier = Modifier.weight(1F), key = Key.Equals, onClick = onClick)
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
