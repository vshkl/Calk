package com.vshkl.calk.feature.calculator

import co.touchlab.kermit.Logger
import com.vshkl.calk.model.InputAction
import com.vshkl.calk.core.ViewModel
import com.vshkl.calk.usecases.EvaluateExpression
import com.vshkl.calk.usecases.ObserveCalculationsHistory
import com.vshkl.calk.usecases.SaveCalculation
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class CalculatorViewModel(
    private val evaluateExpression: EvaluateExpression,
    private val observeCalculationsHistory: ObserveCalculationsHistory,
    private val saveCalculation: SaveCalculation,
    log: Logger,
) : ViewModel() {

    private val log = log.withTag("CalculatorCommonViewModel")

    private val _calculatorState: MutableStateFlow<CalculatorState> =
        MutableStateFlow(CalculatorState())
    val calculatorState: StateFlow<CalculatorState> = _calculatorState

    init {
        viewModelScope.launch {
            observeCalculationsHistory()
                .map { history ->
                    _calculatorState.value = _calculatorState.value
                        .copy(history = history)
                }
                .stateIn(viewModelScope, SharingStarted.Lazily, CalculatorState())
                .collect()
        }
    }

    override fun onCleared() {
        log.v("Clearing CalculatorViewModel")
    }

    fun modifyInput(action: InputAction) {
        fun maybeCalculate() {
            evaluateExpression(expression = calculatorState.value.input)?.let { result ->
                _calculatorState.value = _calculatorState.value
                    .copy(result = result)
            }
        }

        fun writeCalculation(input: String, result: String) {
            viewModelScope.launch {
                if (result.isNotBlank()) {
                    saveCalculation(input = input, result = result)
                }
            }
        }

        when (action) {
            is InputAction.Add -> {
                val currentInput = calculatorState.value.input
                _calculatorState.value = _calculatorState.value.copy(
                    input = currentInput + action.value,
                )
            }
            is InputAction.Remove -> {
                val currentInput = calculatorState.value.input
                _calculatorState.value = _calculatorState.value.copy(
                    input = currentInput.dropLast(1),
                )
            }
            is InputAction.Parentheses -> {
                val currentInput = calculatorState.value.input
                val countLeft = currentInput.count { it == '(' }
                val countRight = currentInput.count { it == ')' }
                _calculatorState.value = _calculatorState.value
                    .copy(
                        input = currentInput + when {
                            countLeft > countRight -> ")"
                            else -> "("
                        }
                    )
            }
            is InputAction.Clear -> {
                _calculatorState.value = _calculatorState.value.copy(
                    input = "",
                    result = "",
                )
            }
            is InputAction.Equals -> {
                val currentInput = calculatorState.value.input
                val currentResult = calculatorState.value.result
                _calculatorState.value = _calculatorState.value.copy(
                    input = currentResult,
                    result = "",
                )
                writeCalculation(currentInput, currentResult)
            }
        }

        if (action is InputAction.Add ||
            action is InputAction.Remove ||
            action is InputAction.Parentheses
        ) {
            maybeCalculate()
        }
    }
}
