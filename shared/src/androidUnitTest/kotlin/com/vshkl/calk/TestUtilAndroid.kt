package com.vshkl.calk

import android.app.Application
import androidx.test.core.app.ApplicationProvider
import com.squareup.sqldelight.android.AndroidSqliteDriver
import com.squareup.sqldelight.db.SqlDriver
import com.squareup.sqldelight.sqlite.driver.JdbcSqliteDriver
import com.vshkl.calk.db.CalkDb

internal actual fun testDbConnection(): SqlDriver {
    // Try to use the android driver (which only works if we're on robolectric).
    // Fall back to jdbc if that fails.
    return try {
        val app = ApplicationProvider.getApplicationContext<Application>()
        AndroidSqliteDriver(CalkDb.Schema, app, "calkdb")
    } catch (exception: IllegalStateException) {
        JdbcSqliteDriver(JdbcSqliteDriver.IN_MEMORY)
            .also { CalkDb.Schema.create(it) }
    }
}
