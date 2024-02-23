package com.champions.formula.leaders.race.app.ui.demonstration

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.champions.formula.leaders.race.app.domain.DriverModel
import com.champions.formula.leaders.race.app.repo.FormulaRepo
import com.champions.formula.leaders.race.app.ui.base.BaseViewModel
import com.champions.formula.leaders.race.app.ui.base.Event
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ViewDriversViewModel(val repo: FormulaRepo) : BaseViewModel<Event>() {

    private val _drivers = MutableLiveData<List<DriverModel>?>()
    val drivers: MutableLiveData<List<DriverModel>?> = _drivers

    init {
        addStaticDriverData()
    }

    private fun addStaticDriverData() {
        viewModelScope.launch {
            try {
                val driversList = fetchDrivers()
                _drivers.postValue(driversList) // Use postValue() for background updates
            } catch (e: Exception) {
                _drivers.postValue(null) // Indicate error
                Log.e("ViewDriversViewModel", "Error fetching drivers: ${e.message}")
            }
        }
    }

    private suspend fun fetchDrivers(): List<DriverModel> {
        return withContext(Dispatchers.IO) { // Ensure repo call is also in IO
            repo.getListDrivers()
        }
    }
}