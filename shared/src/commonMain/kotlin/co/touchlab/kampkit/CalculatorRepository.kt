package co.touchlab.kampkit

import co.touchlab.kampkit.db.Calculation
import co.touchlab.kermit.Logger
import co.touchlab.stately.ensureNeverFrozen
import kotlinx.coroutines.flow.Flow
import kotlinx.datetime.Clock

class CalculatorRepository(
    private val dbHelper: DatabaseHelper,
    log: Logger,
    private val clock: Clock,
) {

    private val log = log.withTag("CalculatorRepository")

    companion object {
        internal const val DB_TIMESTAMP_KEY = "DbTimestampKey"
    }

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