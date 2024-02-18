package com.champions.formula.leaders.race.app.ui.demonstration

import android.content.res.Resources
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.champions.formula.leaders.race.app.R
import com.champions.formula.leaders.race.app.api.ApiService
import com.champions.formula.leaders.race.app.domain.DriverInfo
import com.champions.formula.leaders.race.app.ui.base.BaseViewModel
import com.champions.formula.leaders.race.app.ui.base.Event
import com.champions.formula.leaders.race.app.ui.localstorage.PreferenceHelper

class ViewDriversViewModel(val preferenceHelper: PreferenceHelper, val resources: Resources, val apiService: ApiService) : BaseViewModel<Event>(){

    private val _drivers = MutableLiveData<List<DriverInfo>>()
    val drivers: LiveData<List<DriverInfo>> = _drivers

    init {
        addStaticDriverData()
    }

    private fun addStaticDriverData() {
        val driverInfoList = listOf(
            DriverInfo(
                image = R.mipmap.max_verstappen,
                lastCurrentTeam = "Red Bull Racing",
                country = "Netherlands",
                podiums = "98",
                grandsPrixEntered = "185",
                worldChampionships = "3",
                racesWon = "54",
                dateOfBirth = "30/09/1997",
                placeOfBirth = "Hasselt, Belgium",
                name = "Max Verstappen"
            ),
            DriverInfo(
                image = R.mipmap.graham_hill,
                lastCurrentTeam = "Hill-Ford",
                country = "United Kingdom",
                podiums = "36",
                grandsPrixEntered = "176",
                worldChampionships = "2",
                racesWon = "14",
                dateOfBirth = "19/02/1929",
                placeOfBirth = "London, United Kingdom",
                name = "Graham Hill"
            )
        )
        _drivers.value = driverInfoList
    }
}

