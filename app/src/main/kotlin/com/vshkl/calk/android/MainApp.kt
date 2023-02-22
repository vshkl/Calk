package com.vshkl.calk.android

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import android.util.Log
import com.vshkl.calk.AppInfo
import com.vshkl.calk.CalculatorViewModel
import com.vshkl.calk.initKoin
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.parameter.parametersOf
import org.koin.dsl.module

class MainApp : Application() {

    override fun onCreate() {
        super.onCreate()
        initKoin(
            module {
                single<Context> { this@MainApp }
                viewModel {
                    CalculatorViewModel(get(), get { parametersOf("CalculatorViewModel") })
                }
                single<SharedPreferences> {
                    get<Context>().getSharedPreferences(
                        "KAMPSTARTER_SETTINGS",
                        Context.MODE_PRIVATE
                    )
                }
                single<AppInfo> { AndroidAppInfo }
                single {
                    { Log.i("Startup", "Hello from Android/Kotlin!") }
                }
            }
        )
    }
}

object AndroidAppInfo : AppInfo {
    override val appId: String = BuildConfig.APPLICATION_ID
}
