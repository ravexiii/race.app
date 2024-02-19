package com.champions.formula.leaders.race.app.domain

import com.squareup.moshi.Json

data class DriverModel(
    val driver_number: Int,
    val broadcast_name: String,
    @field:Json(name = "full_name")
    val name: String,
    val name_acronym: String,
    @field:Json(name = "lastCurrentTeam")
    val team_name: String,
    val team_colour: String,
    val first_name: String,
    val last_name: String,
    @field:Json(name = "headshot_url")
    val image: String,
    val country_code: String,
    val session_key: Int,
    val meeting_key: Int
)
