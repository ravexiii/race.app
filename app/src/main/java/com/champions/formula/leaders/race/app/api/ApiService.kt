package com.champions.formula.leaders.race.app.api

import android.annotation.SuppressLint
import android.content.Context
import android.os.Build
import com.champions.formula.leaders.race.app.api.models.DriversResponse
import com.champions.formula.leaders.race.app.domain.PreferenceHelper
import com.squareup.moshi.Moshi
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query
import java.math.BigDecimal
import java.math.BigInteger
import java.security.MessageDigest
import java.util.concurrent.TimeUnit

class ApiService(
    serverUrl: String,
    private val appContext: Context
) {
    private val userAgent: String by lazy {
        val stringId = appContext.applicationInfo.labelRes
        val applicationName: String = if (stringId == 0) {
            appContext.applicationInfo.nonLocalizedLabel.toString()
        } else {
            appContext.getString(stringId)
        }
        "$applicationName/${Build.VERSION.BASE_OS}; Android: ${Build.VERSION.RELEASE}; Model:${Build.MODEL};"
        //${okhttp3.internal.userAgent}"
    }

    val v1Api: FOneApi by lazy {
        val moshi = Moshi.Builder()
            .build()
        Retrofit.Builder()
            .client(createOkHttpClient())
            .baseUrl(serverUrl)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()
            .create(FOneApi::class.java)
    }

    private fun createOkHttpClient(contentType: String = "application/json"): OkHttpClient {
        return OkHttpClient.Builder()
            .readTimeout(60, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)
            .addInterceptor { chain ->
                val original = chain.request()
                val method = original.method()

                val request = original
                    .newBuilder()
                    .method(method, original.body())
                    .header("User-Agent", userAgent)
                    .header("Accept", contentType)
                    .build()

                chain.proceed(request)
            }
            .build()
    }

    interface FOneApi {
        @GET("$API_V1/drivers")
        suspend fun fetchDrivers(
        ): DriversResponse

        companion object {

            private const val API_V1 = "/v1"
            private const val API_SECRET = "af12aff359D25f2C414A689bKL5c30473"
            private const val TEST_API = "s_e_c_r_e_t"

            /**
             * returns signature for [args]
             */
            @SuppressLint("DefaultLocale")
            fun getMD5Signature(vararg args: Any?): String {
                val signature = args.filterNotNull()
                    .joinToString("") { it.toString() }
                    .plus(API_SECRET)
                val md = MessageDigest.getInstance("MD5")
                return BigInteger(1, md.digest(signature.toByteArray()))
                    .toString(16)
                    .padStart(32, '0')
            }

            /**
             * returns current time stamp
             */
            fun getTimeStamp(): String =
                BigDecimal.valueOf(System.currentTimeMillis() / 1000.0).toPlainString()

        }
    }
}