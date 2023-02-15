package co.touchlab.kampkit.models

import co.touchlab.kampkit.features.calculator.CalculatorState
import co.touchlab.kampkit.features.calculator.InputAction
import co.touchlab.kermit.Logger
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class CalculatorViewModel(
    log: Logger,
) : ViewModel() {

    private val log = log.withTag("CalculatorCommonViewModel")

    private val _calculatorState: MutableStateFlow<CalculatorState> =
        MutableStateFlow(CalculatorState())
    val calculatorState: StateFlow<CalculatorState> = _calculatorState

    override fun onCleared() {
        log.v("Clearing CalculatorViewModel")
    }

    fun modifyInput(action: InputAction) {
        when (action) {
            is InputAction.Add -> {
                val currentInput = calculatorState.value.input
                _calculatorState.value = _calculatorState.value.copy(
                    input = currentInput + action.value
                )
            }
            is InputAction.Remove -> {
                val currentInput = calculatorState.value.input
                _calculatorState.value = _calculatorState.value.copy(
                    input = currentInput.dropLast(1)
                )
            }
            is InputAction.Parentheses -> {
                // TODO: Implement
            }
            is InputAction.Clear -> {
                _calculatorState.value = CalculatorState()
            }
            is InputAction.Equals -> {
                // TODO: Implement
            }
        }
    }
}
