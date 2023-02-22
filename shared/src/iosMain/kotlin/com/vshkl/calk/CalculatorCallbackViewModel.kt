package com.vshkl.calk

import co.touchlab.kermit.Logger
import com.vshkl.calk.usecases.EvaluateExpression
import com.vshkl.calk.usecases.ObserveCalculationsHistory
import com.vshkl.calk.usecases.SaveCalculation

@Suppress("Unused") // Members are called from Swift
class CalculatorCallbackViewModel(
    evaluateExpression: EvaluateExpression,
    observeCalculationsHistory: ObserveCalculationsHistory,
    saveCalculation: SaveCalculation,
    log: Logger,
) : CallbackViewModel() {

    override val viewModel = CalculatorViewModel(
        evaluateExpression,
        observeCalculationsHistory,
        saveCalculation,
        log,
    )

    val calculatorState = viewModel.calculatorState.asCallbacks()

    fun modifyInput(inputAction: InputAction) {
        viewModel.modifyInput(inputAction)
    }
}
