package com.vshkl.calk.usecases

import co.touchlab.kermit.Logger
import co.touchlab.kermit.StaticConfig
import com.github.murzagalin.evaluator.Evaluator
import com.vshkl.calk.usecases.EvaluateExpression
import kotlinx.coroutines.test.runTest
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNull

class EvaluateExpressionUseCaseTest {

    private lateinit var evaluateExpression: EvaluateExpression

    @BeforeTest
    fun setup() = runTest {
        evaluateExpression = EvaluateExpression(
            evaluator = Evaluator(),
            log = Logger(StaticConfig()),
        )
    }

    @Test
    fun `should evaluate expression when valid one is passed`() = runTest {
        val expression = "2+3×4÷2"
        val expectedResult = "8"

        assertEquals(
            expectedResult,
            evaluateExpression(expression),
        )
    }

    @Test
    fun `should return result with decimal part`() = runTest {
        val expression = "2+3×4.1÷2"
        val expectedResult = "8.15"

        assertEquals(
            expectedResult,
            evaluateExpression(expression),
        )
    }

    @Test
    fun `should return null for invalid expression`() = runTest {
        val expression = "(2+3×4.1"

        assertNull(evaluateExpression(expression))
    }
}