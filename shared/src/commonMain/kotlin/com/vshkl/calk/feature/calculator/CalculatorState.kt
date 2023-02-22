package com.vshkl.calk.feature.calculator

data class CalculatorState(
    val input: String = "",
    val result: String = "",
    val history: List<String> = emptyList(),
)
