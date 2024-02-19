package com.champions.formula.leaders.race.app.retrofit

import retrofit2.http.GET
import retrofit2.Call

interface ApiService {
//    @GET("v1/drivers?driver_number=1&session_key=9158")
//    suspend fun getDriver() : List<DriverModel>

    @GET("v1/drivers")
    suspend fun getDrivers() : List<DriverModel>
}
