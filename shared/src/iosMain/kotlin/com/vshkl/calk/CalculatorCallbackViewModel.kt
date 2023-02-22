package com.vshkl.calk

import co.touchlab.kermit.Logger

@Suppress("Unused") // Members are called from Swift
class CalculatorCallbackViewModel(
    evaluateExpression: EvaluateExpression,
    observeCalculationsHistory: ObserveCalculationsHistory,
    calculatorRepository: CalculatorRepository,
    log: Logger,
) : CallbackViewModel() {

    override val viewModel = CalculatorViewModel(
        evaluateExpression,
        observeCalculationsHistory,
        calculatorRepository,
        log,
    )

    val calculatorState = viewModel.calculatorState.asCallbacks()

    fun modifyInput(inputAction: InputAction) {
        viewModel.modifyInput(inputAction)
    }
}
