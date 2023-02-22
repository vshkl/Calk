package com.vshkl.calk

import com.russhwolf.settings.Settings
import com.russhwolf.settings.SharedPreferencesSettings
import com.squareup.sqldelight.android.AndroidSqliteDriver
import com.squareup.sqldelight.db.SqlDriver
import com.vshkl.calk.db.CalkDb
import org.koin.core.module.Module
import org.koin.dsl.module

actual val platformModule: Module = module {
    single<SqlDriver> {
        AndroidSqliteDriver(
            CalkDb.Schema,
            get(),
            "CalkDb"
        )
    }

    single<Settings> {
        SharedPreferencesSettings(get())
    }
}
