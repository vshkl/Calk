package com.vshkl.calk

import co.touchlab.kermit.Logger
import co.touchlab.stately.ensureNeverFrozen

class SaveCalculation(
    private val dbHelper: DatabaseHelper,
    log: Logger,
) {

    private val log = log.withTag("SaveCalculation")

    init {
        ensureNeverFrozen()
    }

    suspend operator fun invoke(input: String, result: String) {
        log.d { "Saving calculations with input $input and result $result" }

        dbHelper.insertCalculation(input, result)
    }
}
