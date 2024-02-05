package com.champions.formula.leaders.race.app.ui.demonstration

import com.champions.formula.leaders.race.app.data.DriverInfo
import com.champions.formula.leaders.race.app.ui.base.BaseViewModel
import com.champions.formula.leaders.race.app.ui.base.Event
import com.champions.formula.leaders.race.app.ui.localstorage.PreferenceHelper

class ViewDriversViewModel(val preferenceHelper: PreferenceHelper) : BaseViewModel<Event>(){

    init {
        addStaticDriverData()
    }

    private fun addStaticDriverData() {
        val driverInfoList = listOf(
            DriverInfo(
                lastCurrentTeam = "Red Bull Racing",
                country = "Netherlands",
                podiums = "98",
                grandsPrixEntered = "185",
                worldChampionships = "3",
                racesWon = "54",
                dateOfBirth = "30/09/1997",
                placeOfBirth = "Hasselt, Belgium"
            ),
            DriverInfo(
                lastCurrentTeam = "Ferrari",
                country = "Germany",
                podiums = "155",
                grandsPrixEntered = "308",
                worldChampionships = "7",
                racesWon = "91",
                dateOfBirth = "03/01/1969",
                placeOfBirth = "Hürth-Hermülheim, Germany"
            )
        )
        preferenceHelper.saveDriverInfoList(driverInfoList)
    }

    fun fetchDrivers(preferenceHelper: PreferenceHelper): List<DriverInfo>?{
        return preferenceHelper.getDriverInfoList()
    }
}