package com.champions.formula.leaders.race.app.data

import android.content.Context

data class DriverInfo(
    val lastCurrentTeam: String,
    val country: String,
    val podiums: String,
    val grandsPrixEntered: String,
    val worldChampionships: String,
    val racesWon: String,
    val dateOfBirth: String,
    val placeOfBirth: String
)

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

    fun getDriverInfoList(): List<DriverInfo> {
        val driverInfoString = sharedPreferences.getString("driverInfoList", "") ?: ""
        return if (driverInfoString.isEmpty()) {
            emptyList()
        } else {
            // Разделение строки на подстроки
            driverInfoString.split("\n\n").map { parseDriverInfoString(it) }
        }
    }

    private fun parseDriverInfoString(driverInfoString: String): DriverInfo {
        // Разделение подстроки на компоненты
        val infoArray = driverInfoString.lines()
        return DriverInfo(
            lastCurrentTeam = infoArray[0].substringAfter(":").trim(),
            country = infoArray[1].substringAfter(":").trim(),
            podiums = infoArray[2].substringAfter(":").trim(),
            grandsPrixEntered = infoArray[3].substringAfter(":").trim(),
            worldChampionships = infoArray[4].substringAfter(":").trim(),
            racesWon = infoArray[5].substringAfter(":").trim(),
            dateOfBirth = infoArray[6].substringAfter(":").trim(),
            placeOfBirth = infoArray[7].substringAfter(":").trim()
        )
    }
}

// Использование
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

