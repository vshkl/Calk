package co.touchlab.kampkit.features.calculator

import co.touchlab.kampkit.models.ViewModel
import co.touchlab.kermit.Logger
import com.github.murzagalin.evaluator.Evaluator
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
                val currentInput = calculatorState.value.input
                val parenthesesLeftCount = currentInput.count { it == '(' }
                val parenthesesRightCount = currentInput.count { it == ')' }
                _calculatorState.value = _calculatorState.value.copy(
                    input = currentInput + when {
                        parenthesesLeftCount > parenthesesRightCount -> ")"
                        else -> "("
                    }
                )
            }
            is InputAction.Clear -> {
                _calculatorState.value = CalculatorState()
            }
            is InputAction.Equals -> {
                calculate()
            }
        }
    }

    private fun calculate() {
        val currentInput = calculatorState.value.input
        val result = Evaluator().evaluateDouble(currentInput)
        _calculatorState.value = _calculatorState.value.copy(
            result = result.toString(),
        )
    }
}
