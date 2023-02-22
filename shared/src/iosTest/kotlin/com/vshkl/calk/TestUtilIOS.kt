package com.vshkl.calk

import co.touchlab.sqliter.DatabaseConfiguration
import com.squareup.sqldelight.db.SqlDriver
import com.squareup.sqldelight.drivers.native.NativeSqliteDriver
import com.squareup.sqldelight.drivers.native.wrapConnection
import com.vshkl.calk.db.CalkDb

internal actual fun testDbConnection(): SqlDriver {
    val schema = Calk.Schema
    return NativeSqliteDriver(
        DatabaseConfiguration(
            name = "calkdb",
            version = schema.version,
            create = { connection ->
                wrapConnection(connection) { schema.create(it) }
            },
            upgrade = { connection, oldVersion, newVersion ->
                wrapConnection(connection) { schema.migrate(it, oldVersion, newVersion) }
            },
            inMemory = true
        )
    )
}