package co.touchlab.kampkit.models

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
            is InputAction.Clear -> {
                _calculatorState.value = CalculatorState()
            }
        }
    }
}

data class CalculatorState(
    val input: String = "",
    val result: String = "",
)

sealed class InputAction {
    data class Add(val value: String) : InputAction()
    object Remove : InputAction()
    object Clear : InputAction()
}
