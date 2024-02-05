package com.champions.formula.leaders.race.app.ui.localstorage

import android.content.Context
import com.champions.formula.leaders.race.app.data.DriverInfo

class PreferenceHelper(context: Context) {

    private val sharedPreferences =
        context.getSharedPreferences("DriverPreferences", Context.MODE_PRIVATE)

    fun saveDriverInfoList(driverInfoList: List<DriverInfo>) {
        // Преобразование списка в одну строку
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

        // Сохранение строки в SharedPreferences
        sharedPreferences.edit().putString("driverInfoList", driverInfoString).apply()
    }

    fun getDriverInfoList(): List<DriverInfo>? {
        val driverInfoString = sharedPreferences.getString("driverInfoList", "") ?: ""
        return if (driverInfoString.isEmpty()) {
            emptyList()
        } else {
            // Разделение строки на подстроки
            driverInfoString.split("\n\n").map { parseDriverInfoString(it) }
        }
    }

    private fun parseDriverInfoString(driverInfoString: String): DriverInfo {
        val infoArray = driverInfoString.lines().map { it.substringAfter(":").trim() }
        return DriverInfo(
            lastCurrentTeam = infoArray[0],
            country = infoArray[1],
            podiums = infoArray[2],
            grandsPrixEntered = infoArray[3],
            worldChampionships = infoArray[4],
            racesWon = infoArray[5],
            dateOfBirth = infoArray[6],
            placeOfBirth = infoArray[7]
        )
    }

}

