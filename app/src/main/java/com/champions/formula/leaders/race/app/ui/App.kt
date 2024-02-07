package com.champions.formula.leaders.race.app.ui

import android.app.Application
import com.champions.formula.leaders.race.app.di.appModule
import com.champions.formula.leaders.race.app.di.vmModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidFileProperties
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level


class App : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(Level.ERROR) // Включить логирование ошибок Koin
            androidContext(this@App)
            androidFileProperties()
            modules(vmModule, appModule)
        }
    }
}