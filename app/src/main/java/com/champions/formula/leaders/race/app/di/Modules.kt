package com.champions.formula.leaders.race.app.di

import com.champions.formula.leaders.race.app.api.ApiService
import com.champions.formula.leaders.race.app.api.FormulaWebService
import com.champions.formula.leaders.race.app.ui.demonstration.ViewDriversViewModel
import com.champions.formula.leaders.race.app.ui.localstorage.PreferenceHelper
import com.champions.formula.leaders.race.app.ui.main.MainViewModel
import com.champions.formula.leaders.race.app.utils.Constants
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module


val vmModule = module {
    viewModelOf(::MainViewModel)
    viewModelOf(::ViewDriversViewModel)
}

val appModule = module {
    single { PreferenceHelper(get()) }
    single { androidContext().resources }
    single { FormulaWebService().provideApi(Constants.BASE_URL, get()) }
}
