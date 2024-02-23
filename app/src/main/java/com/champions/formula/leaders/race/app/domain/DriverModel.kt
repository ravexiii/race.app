package com.champions.formula.leaders.race.app.domain

import com.squareup.moshi.Json

data class DriverModel(
    val driver_number: Int,
    val broadcast_name: String,
    @field:Json(name = "first_name")
    val firstName: String,
    val name_acronym: String,
    @field:Json(name = "team_name")
    val lastCurrentTeam: String,
    val team_colour: String,
    @field:Json(name = "last_name")
    val lastName: String,
    @field:Json(name = "headshot_url")
    val image: String?,
    val country_code: String,
    val session_key: Int,
    val meeting_key: Int
)
