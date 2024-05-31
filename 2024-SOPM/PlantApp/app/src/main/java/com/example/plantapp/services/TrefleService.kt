package com.example.plantapp.services

import com.example.plantapp.api.PlantDataResponse
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface TrefleService {

    @GET("/api/v1/plants?token=${token}")
    suspend fun getPlants(): PlantDataResponse

    companion object {
        private const val token = "yH69zDMPGX90eAdnxHphMWf7_UNmaXspm5ojhbJoKsI"
        private const val BASE_URL = "https://trefle.io/"

        fun create(): TrefleService {
            val logger =
                HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BASIC }

            val client = OkHttpClient.Builder()
                .addInterceptor(logger)
                .build()

            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(TrefleService::class.java)
        }
    }
}