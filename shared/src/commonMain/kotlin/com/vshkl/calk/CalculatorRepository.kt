package com.vshkl.calk

import co.touchlab.kermit.Logger
import co.touchlab.stately.ensureNeverFrozen
import com.github.murzagalin.evaluator.Evaluator
import com.vshkl.calk.db.Calculation
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

    fun getCalculations(): Flow<List<Calculation>> {
        return dbHelper.selectAllCalculations()
    }

    suspend fun insertCalculation(input: String, result: String) {
        dbHelper.insertCalculation(input, result)
    }
}