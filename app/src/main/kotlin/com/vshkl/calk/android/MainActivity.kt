package com.vshkl.calk.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import co.touchlab.kermit.Logger
import com.vshkl.calk.CalculatorViewModel
import com.vshkl.calk.android.ui.CalculatorScreen
import com.vshkl.calk.android.ui.theme.CalkTheme
import com.vshkl.calk.injectLogger
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.component.KoinComponent

class MainActivity : ComponentActivity(), KoinComponent {

    private val log: Logger by injectLogger("MainActivity")
    private val calculatorViewModel: CalculatorViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CalkTheme {
                CalculatorScreen(
                    viewModel = calculatorViewModel,
                    log = log,
                )
            }
        }
    }
}
