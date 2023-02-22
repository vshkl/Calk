package com.vshkl.calk

data class CalculatorState(
    val input: String = "",
    val result: String = "",
    val history: List<String> = emptyList(),
)
