package com.htech.ktorkoin.data.remote

import android.util.Log
import com.htech.ktorkoin.core.Failure
import io.ktor.client.HttpClient
import io.ktor.client.engine.android.Android
import io.ktor.client.plugins.HttpResponseValidator
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.http.URLBuilder
import io.ktor.http.takeFrom
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

object KtorClientFactory {
    fun create(baseUrl: String): HttpClient = HttpClient(Android) {
        install(ContentNegotiation) {
            json(
                Json {
                    ignoreUnknownKeys = true
                    isLenient = true
                    encodeDefaults == true
                }
            )
        }
        install(Logging) {
            level = LogLevel.INFO
            logger = object : Logger {
                override fun log(message: String) {
                    Log.d("Ktor", message)
                }
            }
        }
        defaultRequest {
            url.takeFrom(URLBuilder().takeFrom(baseUrl).apply {
            })
            headers.append("Accept", "application/json")
        }
        HttpResponseValidator {
            handleResponseExceptionWithRequest { cause, request ->
                throw when(cause){
                    is kotlinx.serialization.SerializationException-> RuntimeException(Failure.Serialization().message,cause)
                    else -> cause
                }
            }
        }
    }
}