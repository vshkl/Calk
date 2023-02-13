package co.touchlab.kampkit.android.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun CalculatorScreen() {
    Column() {
        Display(input = "", result = "")
        Keyboard(onClick = {})
    }
}

@Preview
@Composable
fun CalculatorScreenPreview() {
    CalculatorScreen()
}
