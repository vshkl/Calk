package co.touchlab.kampkit.android.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import co.touchlab.kampkit.models.CalculatorState
import co.touchlab.kampkit.models.InputAction

@Composable
fun CalculatorScreenContent(
    calculatorState: CalculatorState,
    onInput: (InputAction) -> Unit,
) {
    Column {
        Display(input = calculatorState.input, result = calculatorState.result)
        Keyboard(onClick = { key ->
            val inputAction: InputAction = when (key) {
                Key.Backspace -> InputAction.Remove
                Key.Clear -> InputAction.Clear
                Key.Decimal -> InputAction.Add(".")
                Key.Divide -> InputAction.Add("÷")
                Key.Equals -> {
                    // TODO: Think of it later
                    InputAction.Add("=")
                }
                Key.Minus -> InputAction.Add("-")
                Key.Multiply -> InputAction.Add("×")
                is Key.Number -> InputAction.Add(key.number.toString())
                Key.Parentheses -> {
                    // TODO: Think of it later
                    InputAction.Add("()")
                }
                Key.Percent -> InputAction.Add("%")
                Key.Plus -> InputAction.Add("+")
            }

            onInput(inputAction)
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
