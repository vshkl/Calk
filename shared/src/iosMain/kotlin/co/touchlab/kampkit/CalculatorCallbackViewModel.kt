package co.touchlab.kampkit

import co.touchlab.kampkit.features.calculator.InputAction
import co.touchlab.kampkit.features.calculator.CalculatorViewModel
import co.touchlab.kampkit.models.CalculatorRepository
import co.touchlab.kampkit.models.CallbackViewModel
import co.touchlab.kermit.Logger

@Suppress("Unused") // Members are called from Swift
class CalculatorCallbackViewModel(
    calculatorRepository: CalculatorRepository,
    log: Logger,
) : CallbackViewModel() {

    override val viewModel = CalculatorViewModel(calculatorRepository, log)

    val calculatorState = viewModel.calculatorState.asCallbacks()

    val calculationsHistory = viewModel.calculationHistory.asCallbacks()

    fun modifyInput(inputAction: InputAction) {
        viewModel.modifyInput(inputAction)
    }
}
