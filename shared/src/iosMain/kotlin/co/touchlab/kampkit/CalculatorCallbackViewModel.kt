package co.touchlab.kampkit

import co.touchlab.kermit.Logger

@Suppress("Unused") // Members are called from Swift
class CalculatorCallbackViewModel(
    calculatorRepository: CalculatorRepository,
    log: Logger,
) : CallbackViewModel() {

    override val viewModel = CalculatorViewModel(calculatorRepository, log)

    val calculatorState = viewModel.calculatorState.asCallbacks()

    fun modifyInput(inputAction: InputAction) {
        viewModel.modifyInput(inputAction)
    }
}
