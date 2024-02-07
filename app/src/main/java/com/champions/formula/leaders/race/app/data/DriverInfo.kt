package com.champions.formula.leaders.race.app.data

import android.content.Context
import android.content.res.Resources

data class DriverInfo(
    val name: String,
    val image: Int,
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
    private val sharedPreferences = context.getSharedPreferences("DriverPreferences", Context.MODE_PRIVATE)

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
            Image: ${driverInfo.image}
            Name: ${driverInfo.name}
            """.trimIndent()
        }
        sharedPreferences.edit().putString("driverInfoList", driverInfoString).apply()
    }

    fun getDriverInfoList(): List<DriverInfo> {
        val driverInfoString = sharedPreferences.getString("driverInfoList", "") ?: ""
        return if (driverInfoString.isEmpty()) {
            emptyList()
        } else {
            driverInfoString.split("\n\n").map { parseDriverInfoString(it) }
        }
    }

    private fun parseDriverInfoString(driverInfoString: String): DriverInfo {
        val infoMap = driverInfoString.lines().associateBy({ it.substringBefore(":").trim() }, { it.substringAfter(":").trim() })
        return DriverInfo(
            lastCurrentTeam = infoMap["Last/Current Team"] ?: "",
            country = infoMap["Country"] ?: "",
            podiums = infoMap["Podiums"] ?: "",
            grandsPrixEntered = infoMap["Grands Prix entered"] ?: "",
            worldChampionships = infoMap["World Championships"] ?: "",
            racesWon = infoMap["Races won"] ?: "",
            dateOfBirth = infoMap["Date of birth"] ?: "",
            placeOfBirth = infoMap["Place of birth"] ?: "",
            image = infoMap["Image"]?.toInt() ?: 0,
            name = infoMap["Name"] ?: ""
        )
    }
}
