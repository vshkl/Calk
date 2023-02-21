package co.touchlab.kampkit

data class CalculatorState(
    val input: String = "",
    val result: String = "",
    val history: List<String> = emptyList(),
)
