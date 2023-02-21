package co.touchlab.kampkit

import co.touchlab.kermit.Logger
import com.github.murzagalin.evaluator.Evaluator
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class CalculatorViewModel(
    private val calculatorRepository: CalculatorRepository,
    log: Logger,
) : ViewModel() {

    private val log = log.withTag("CalculatorCommonViewModel")

    private val _calculatorState: MutableStateFlow<CalculatorState> =
        MutableStateFlow(CalculatorState())
    val calculatorState: StateFlow<CalculatorState> = _calculatorState

    init {
        calculatorRepository
            .getCalculations()
            .map { calculations ->
                _calculatorState.value = _calculatorState.value.copy(
                    history = calculations.map { calculation ->
                        "${calculation.input}=${calculation.result}"
                    }
                )
            }
            .stateIn(viewModelScope, SharingStarted.Lazily, CalculatorState())
    }

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
                maybeCalculate()
            }
            is InputAction.Remove -> {
                val currentInput = calculatorState.value.input
                _calculatorState.value = _calculatorState.value.copy(
                    input = currentInput.dropLast(1)
                )
                maybeCalculate()
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
                maybeCalculate()
            }
            is InputAction.Clear -> {
                _calculatorState.value = CalculatorState()
            }
            is InputAction.Equals -> {
                val currentInput = calculatorState.value.input
                val currentResult = calculatorState.value.result
                _calculatorState.value = _calculatorState.value.copy(
                    input = currentResult,
                    result = "",
                )
                viewModelScope.launch {
                    calculatorRepository.insertCalculation(
                        input = currentInput,
                        result = currentResult,
                    )
                }
            }
        }
    }

    private fun maybeCalculate() {
        fun String.normalize(): String {
            return this
                .replace("÷", "/")
                .replace("×", "*")
        }

        val currentInput = calculatorState.value.input
        val evaluator = Evaluator()

        val result: Double
        try {
            result = evaluator.evaluateDouble(currentInput.normalize())
        } catch (e: IllegalArgumentException) {
            return
        }

        _calculatorState.value = _calculatorState.value.copy(
            result = result.toString().removeSuffix(".0")
        )
    }
}
