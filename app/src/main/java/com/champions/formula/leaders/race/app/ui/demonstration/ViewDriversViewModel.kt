package com.champions.formula.leaders.race.app.ui.demonstration

import android.content.res.Resources
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.champions.formula.leaders.race.app.domain.DriverModel
import com.champions.formula.leaders.race.app.network.FormulaApi
import com.champions.formula.leaders.race.app.repo.FormulaRepo
import com.champions.formula.leaders.race.app.ui.base.BaseViewModel
import com.champions.formula.leaders.race.app.ui.base.Event
import com.champions.formula.leaders.race.app.ui.localstorage.PreferenceHelper
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ViewDriversViewModel(val repo: FormulaRepo) : BaseViewModel<Event>(){

    private val _drivers = MutableLiveData<List<DriverModel>>()
    val drivers: LiveData<List<DriverModel>> = _drivers

    init {
        addStaticDriverData()
    }

    private fun addStaticDriverData() {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val driversList = fetchDrivers()
                _drivers.value = driversList
            } catch (e: Exception) {
                Log.d("ViewDriversViewModel", e.message.toString())
                }
            }
        }

    private suspend fun fetchDrivers(): List<DriverModel>{
        return repo.getListDrivers()
    }

}
