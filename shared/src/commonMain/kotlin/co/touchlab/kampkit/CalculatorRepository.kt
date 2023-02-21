package co.touchlab.kampkit

import co.touchlab.kampkit.db.Calculation
import co.touchlab.kermit.Logger
import co.touchlab.stately.ensureNeverFrozen
import com.github.murzagalin.evaluator.Evaluator
import kotlinx.coroutines.flow.Flow

class CalculatorRepository(
    private val dbHelper: DatabaseHelper,
    private val evaluator: Evaluator,
    log: Logger,
) {

    private val log = log.withTag("CalculatorRepository")

    init {
        ensureNeverFrozen()
    }

    fun evaluateExpression(expression: String): Double? {
        fun String.normalize(): String {
            return this
                .replace("÷", "/")
                .replace("×", "*")
        }

        log.d { "Evaluating expression: $expression" }

        return try {
            evaluator.evaluateDouble(expression.normalize())
        } catch (e: IllegalArgumentException) {
            null
        } catch (e: IndexOutOfBoundsException) {
            null
        }
    }

    fun getCalculations(): Flow<List<Calculation>> {
        return dbHelper.selectAllCalculations()
    }

    suspend fun insertCalculation(input: String, result: String) {
        dbHelper.insertCalculation(input, result)
    }
}