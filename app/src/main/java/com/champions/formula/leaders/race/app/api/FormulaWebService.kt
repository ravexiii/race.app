package com.champions.formula.leaders.race.app.api

import android.content.Context
import okhttp3.Interceptor

class FormulaWebService {

    fun provideApi(
        serverUrl: String,
        context: Context
    ): ApiService {
        return ApiService(
            serverUrl,
            context
        )
    }
}