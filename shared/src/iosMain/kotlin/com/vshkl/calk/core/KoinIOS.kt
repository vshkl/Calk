package com.vshkl.calk.core

import co.touchlab.kermit.Logger
import com.russhwolf.settings.NSUserDefaultsSettings
import com.russhwolf.settings.Settings
import com.squareup.sqldelight.db.SqlDriver
import com.squareup.sqldelight.drivers.native.NativeSqliteDriver
import com.vshkl.calk.AppInfo
import com.vshkl.calk.feature.calculator.CalculatorCallbackViewModel
import com.vshkl.calk.db.CalkDb
import org.koin.core.Koin
import org.koin.core.KoinApplication
import org.koin.core.component.KoinComponent
import org.koin.core.parameter.parametersOf
import org.koin.dsl.module
import platform.Foundation.NSUserDefaults

fun initKoinIos(
    userDefaults: NSUserDefaults,
    appInfo: AppInfo,
    doOnStartup: () -> Unit
): KoinApplication = initKoin(
    module {
        single<Settings> { NSUserDefaultsSettings(userDefaults) }
        single { appInfo }
        single { doOnStartup }
    }
)

actual val platformModule = module {
    single<SqlDriver> {
        NativeSqliteDriver(CalkDb.Schema, "CalkDbx")
    }

    single {
        CalculatorCallbackViewModel(get(), get(), get(), getWith("CalculatorCallbackViewModel"))
    }
}

// Access from Swift to create a logger
@Suppress("unused")
fun Koin.loggerWithTag(tag: String) =
    get<Logger>(qualifier = null) { parametersOf(tag) }

@Suppress("unused") // Called from Swift
object KotlinDependencies : KoinComponent {
    fun getCalculatorViewModel() = getKoin().get<CalculatorCallbackViewModel>()
}
