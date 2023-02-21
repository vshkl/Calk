package co.touchlab.kampkit

import co.touchlab.kampkit.db.Calculation
import co.touchlab.kampkit.db.KaMPKitDb
import co.touchlab.kermit.Logger
import com.squareup.sqldelight.db.SqlDriver
import com.squareup.sqldelight.runtime.coroutines.asFlow
import com.squareup.sqldelight.runtime.coroutines.mapToList
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn

class DatabaseHelper(
    sqlDriver: SqlDriver,
    private val log: Logger,
    private val backgroundDispatcher: CoroutineDispatcher
) {

    private val dbRef: KaMPKitDb = KaMPKitDb(sqlDriver)

    fun selectAllCalculations(): Flow<List<Calculation>> =
        dbRef.calculationQueries
            .selectAll()
            .asFlow()
            .mapToList(Dispatchers.Default)
            .flowOn(backgroundDispatcher)

    suspend fun insertCalculation(input: String, result: String) {
        log.d { "Inserting calculation with input: $input and result $result into database" }
        dbRef.transactionWithContext(backgroundDispatcher) {
            dbRef.calculationQueries.insertCalculation(input, result)
        }
    }

    suspend fun deleteAllCalculations() {
        log.i { "Calculations Cleared" }
        dbRef.transactionWithContext(backgroundDispatcher) {
            dbRef.calculationQueries.deleteAll()
        }
    }
}
