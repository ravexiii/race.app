package com.champions.formula.leaders.race.app.network

import com.champions.formula.leaders.race.app.domain.DriverModel
import com.champions.formula.leaders.race.app.utils.Constants
import com.squareup.moshi.Moshi
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

class FormulaWebService {

    val v1Api: FormulaApi by lazy {
        val moshi = Moshi.Builder()
            .build()
        val client = OkHttpClient.Builder()
            .build()
        Retrofit.Builder()
            .client(client)
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()
            .create(FormulaApi::class.java)
    }
}
interface FormulaApi {

    @GET("v1/drivers")
    suspend fun getDrivers() : List<DriverModel>
}