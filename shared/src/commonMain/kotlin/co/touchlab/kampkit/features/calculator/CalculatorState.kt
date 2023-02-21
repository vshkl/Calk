package co.touchlab.kampkit.features.calculator

data class CalculatorState(
    val input: String = "",
    val result: String = "",
    val history: List<String> = emptyList(),
)
