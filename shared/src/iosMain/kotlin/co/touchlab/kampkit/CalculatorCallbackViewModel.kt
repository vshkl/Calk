package co.touchlab.kampkit

import co.touchlab.kampkit.features.calculator.InputAction
import co.touchlab.kampkit.features.calculator.CalculatorViewModel
import co.touchlab.kampkit.models.CallbackViewModel
import co.touchlab.kermit.Logger

@Suppress("Unused") // Members are called from Swift
class CalculatorCallbackViewModel(
    log: Logger
) : CallbackViewModel() {

    override val viewModel = CalculatorViewModel(log)

    val calculatorState = viewModel.calculatorState.asCallbacks()

    fun modifyInput(inputAction: InputAction) {
        viewModel.modifyInput(inputAction)
    }
}
