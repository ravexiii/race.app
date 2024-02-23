package com.champions.formula.leaders.race.app.utils

import com.squareup.moshi.Moshi
import okhttp3.Response

// Обработчик ошибок.



//object ApiErrorUtils {
//
//    private val moshi = Moshi.Builder().build()
//
//    fun parseError(response: Response<T>): ApiError {
//        val errorBody = response.errorBody()
//        return try {
//            val errorResponse = moshi.adapter(ApiError::class.java).fromJson(errorBody?.string())
//            errorResponse
//        } catch (e: Exception) {
//            ApiError(message = e.localizedMessage)
//        }
//    }
//}
//
//data class ApiError(
//    val message: String,
//    val code: Int? = null
//)

