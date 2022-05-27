package com.example.e0601roomproject.services

import com.example.e0601roomproject.data.Todo
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

interface TypicodeService {

    @GET("todos/{id}")
    fun getTodo(@Path("id") id: Int): Call<Todo>

    companion object {
        private const val BASE_URL = "https://jsonplaceholder.typicode.com/"

        fun create(): TypicodeService {

            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(TypicodeService::class.java)
        }
    }
}