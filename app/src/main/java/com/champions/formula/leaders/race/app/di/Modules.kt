package com.champions.formula.leaders.race.app.di

import com.champions.formula.leaders.race.app.ui.demonstration.ViewDriversViewModel
import com.champions.formula.leaders.race.app.ui.localstorage.PreferenceHelper
import com.champions.formula.leaders.race.app.ui.main.MainViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


val vmModule = module {
    viewModel { MainViewModel() }
    viewModel { ViewDriversViewModel(get()) }
}

val appModule = module {
    single { PreferenceHelper(get()) }
    single { androidContext().resources }
}
