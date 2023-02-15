package co.touchlab.kampkit.android.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import co.touchlab.kampkit.features.calculator.CalculatorState
import co.touchlab.kampkit.features.calculator.InputAction
import co.touchlab.kampkit.features.calculator.Key

@Composable
fun CalculatorScreenContent(
    calculatorState: CalculatorState,
    onInput: (InputAction) -> Unit,
) {
    Column {
        Display(
            input = calculatorState.input,
            result = calculatorState.result,
        )
        Keyboard(onClick = { key: Key ->
            onInput(InputAction.fromKey(key))
        })
    }
}

@Preview
@Composable
fun CalculatorScreenContentPreview() {
    CalculatorScreenContent(
        calculatorState = CalculatorState(),
        onInput = {},
    )
}
