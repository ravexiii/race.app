package com.champions.formula.leaders.race.app.ui.localstorage

import android.content.Context
import com.champions.formula.leaders.race.app.data.DriverInfo

class PreferenceHelper(context: Context) {

    private val sharedPreferences =
        context.getSharedPreferences("DriverPreferences", Context.MODE_PRIVATE)

    fun saveDriverInfoList(driverInfoList: List<DriverInfo>) {
        val driverInfoString = driverInfoList.joinToString("\n\n") { driverInfo ->
            """
            Last/Current Team: ${driverInfo.lastCurrentTeam}
            Country: ${driverInfo.country}
            Podiums: ${driverInfo.podiums}
            Grands Prix entered: ${driverInfo.grandsPrixEntered}
            World Championships: ${driverInfo.worldChampionships}
            Races won: ${driverInfo.racesWon}
            Date of birth: ${driverInfo.dateOfBirth}
            Place of birth: ${driverInfo.placeOfBirth}
            """.trimIndent()
        }

        sharedPreferences.edit().putString("driverInfoList", driverInfoString).apply()
    }
}

