package com.vshkl.calk.usecases

import co.touchlab.kermit.Logger
import co.touchlab.stately.ensureNeverFrozen
import com.vshkl.calk.db.DatabaseHelper
import com.vshkl.calk.db.Calculation
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class ObserveCalculationsHistory(
    private val dbHelper: DatabaseHelper,
    log: Logger,
) {

    private val log = log.withTag("ObserveCalculationsHistory")

    init {
        ensureNeverFrozen()
    }

    operator fun invoke(): Flow<List<String>> {
        fun Calculation.asString(): String {
            return "${input}=${result}"
        }

        log.d { "Observing calculations history" }

        return dbHelper
            .selectAllCalculations()
            .map { calculations ->
                calculations.map(Calculation::asString)
            }
    }
}