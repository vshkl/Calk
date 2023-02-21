package co.touchlab.kampkit.android.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.lifecycle.flowWithLifecycle
import co.touchlab.kampkit.features.calculator.CalculatorState
import co.touchlab.kampkit.features.calculator.CalculatorViewModel
import co.touchlab.kermit.Logger
import kotlinx.coroutines.flow.Flow

@Composable
fun CalculatorScreen(
    viewModel: CalculatorViewModel,
    log: Logger,
) {
    val lifecycleOwner = LocalLifecycleOwner.current

    val lifecycleAwareCalculatorFlow: Flow<CalculatorState> =
        remember(viewModel.calculatorState, lifecycleOwner) {
            viewModel.calculatorState.flowWithLifecycle(lifecycleOwner.lifecycle)
        }

    val calculatorState: CalculatorState by lifecycleAwareCalculatorFlow
        .collectAsState(viewModel.calculatorState.value)

    CalculatorScreenContent(
        calculatorState = calculatorState,
        onInput = viewModel::modifyInput,
    )
}
