package co.touchlab.kampkit.android.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import co.touchlab.kampkit.features.calculator.CalculatorState
import co.touchlab.kampkit.features.calculator.InputAction
import co.touchlab.kampkit.features.calculator.Key

@Composable
fun CalculatorScreenContent(
    calculatorState: CalculatorState,
    calculations: List<String>,
    onInput: (InputAction) -> Unit,
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Bottom,
    ) {
        CalculationsHistory(
            calculations = calculations,
        )
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
        calculatorState = CalculatorState(
            input = "20×2+4÷2",
            result = "42",
        ),
        calculations = listOf(
            "1+1=2",
            "2+2=4",
        ),
        onInput = {},
    )
}
