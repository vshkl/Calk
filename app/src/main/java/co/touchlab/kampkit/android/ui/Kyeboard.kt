package co.touchlab.kampkit.android.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import co.touchlab.kampkit.android.ui.Button
import co.touchlab.kampkit.android.ui.Key

@Composable
fun Keyboard(
    modifier: Modifier = Modifier,
    onClick: (Key) -> Unit,
) {
    Box(modifier = modifier) {
        Column {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
            ) {
                Button(modifier = Modifier.weight(1F), key = Key.Clear, onClick = onClick)
                Button(modifier = Modifier.weight(1F), key = Key.Backspace, onClick = onClick)
                Button(modifier = Modifier.weight(1F), key = Key.Percent, onClick = onClick)
                Button(modifier = Modifier.weight(1F), key = Key.Plus, onClick = onClick)
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
            ) {
                Button(modifier = Modifier.weight(1F), key = Key.Number(7), onClick = onClick)
                Button(modifier = Modifier.weight(1F), key = Key.Number(8), onClick = onClick)
                Button(modifier = Modifier.weight(1F), key = Key.Number(9), onClick = onClick)
                Button(modifier = Modifier.weight(1F), key = Key.Multiply, onClick = onClick)
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
            ) {
                Button(modifier = Modifier.weight(1F), key = Key.Number(4), onClick = onClick)
                Button(modifier = Modifier.weight(1F), key = Key.Number(5), onClick = onClick)
                Button(modifier = Modifier.weight(1F), key = Key.Number(6), onClick = onClick)
                Button(modifier = Modifier.weight(1F), key = Key.Minus, onClick = onClick)
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
            ) {
                Button(modifier = Modifier.weight(1F), key = Key.Number(1), onClick = onClick)
                Button(modifier = Modifier.weight(1F), key = Key.Number(2), onClick = onClick)
                Button(modifier = Modifier.weight(1F), key = Key.Number(3), onClick = onClick)
                Button(modifier = Modifier.weight(1F), key = Key.Plus, onClick = onClick)
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
            ) {
                Button(modifier = Modifier.weight(1F), key = Key.Decimal, onClick = onClick)
                Button(modifier = Modifier.weight(1F), key = Key.Number(0), onClick = onClick)
                Button(modifier = Modifier.weight(1F), key = Key.Parentheses, onClick = onClick)
                Button(modifier = Modifier.weight(1F), key = Key.Equals, onClick = onClick)
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
