package com.vshkl.calk

import co.touchlab.kermit.Logger
import com.github.murzagalin.evaluator.Evaluator
import kotlin.math.roundToLong

class EvaluateExpressionUseCase(
    private val evaluator: Evaluator,
    log: Logger,
) {

    private val log = log.withTag("EvaluateExpressionUseCase")

    operator fun invoke(expression: String): String? {
        fun String.normalize(): String {
            return this
                .replace("÷", "/")
                .replace("×", "*")
        }

        log.d { "Evaluating expression: $expression" }

        return try {
            evaluator
                .evaluateDouble(expression.normalize())
                .toFloat()
                .toString()
                .removeSuffix(".0")
        } catch (e: IllegalArgumentException) {
            null
        } catch (e: IndexOutOfBoundsException) {
            null
        }
    }
}