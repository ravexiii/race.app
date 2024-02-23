package com.champions.formula.leaders.race.app.network

import com.champions.formula.leaders.race.app.utils.Constants
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

object ApiClient {

    fun <T> create(service: Class<T>): T {
        val mLoggingInterceptor = HttpLoggingInterceptor()
        mLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

        val mClient = OkHttpClient.Builder()
            .addInterceptor(mLoggingInterceptor)
            .readTimeout(30, TimeUnit.SECONDS)
            .connectTimeout(30, TimeUnit.SECONDS)
            .build()

        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .client(mClient)
            .build()
            .create(service)
    }
}


