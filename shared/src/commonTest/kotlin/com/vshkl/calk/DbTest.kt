package com.vshkl.calk

import co.touchlab.kermit.Logger
import co.touchlab.kermit.StaticConfig
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNull
import kotlin.test.assertTrue

class DbTest {

    private lateinit var dbHelper: DatabaseHelper

    @BeforeTest
    fun setup() = runTest {
        dbHelper = DatabaseHelper(
            testDbConnection(),
            Logger(StaticConfig()),
            Dispatchers.Default
        )
        dbHelper.deleteAllCalculations()
    }

    @Test
    fun `writes calculations successfully`() = runTest {
        val expectedInput = "2x2"
        val expectedResult = "4"

        dbHelper
            .insertCalculation(expectedInput, expectedResult)

        val calculation = dbHelper
            .selectAllCalculations()
            .first()
            .first()

        assertEquals(expectedInput, calculation.input)
        assertEquals(expectedResult, calculation.result)
    }

    @Test
    fun `deletes calculations successfully`() = runTest {
        val expectedInput = "2x2"
        val expectedResult = "4"

        dbHelper
            .insertCalculation(expectedInput, expectedResult)

        assertTrue {
            dbHelper
                .selectAllCalculations()
                .first()
                .isNotEmpty()
        }

        dbHelper
            .deleteAllCalculations()

        assertTrue {
            dbHelper
                .selectAllCalculations()
                .first()
                .isEmpty()
        }
    }
}
