package com.champions.formula.leaders.race.app.network

import com.champions.formula.leaders.race.app.domain.DriverModel
import com.champions.formula.leaders.race.app.utils.Constants
import com.squareup.moshi.Moshi
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET


interface FormulaApi {

    @GET("v1/drivers")
    suspend fun getDrivers() : List<DriverModel>
}