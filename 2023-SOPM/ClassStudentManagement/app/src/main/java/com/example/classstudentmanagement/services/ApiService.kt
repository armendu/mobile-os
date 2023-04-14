package com.example.classstudentmanagement.services

import com.example.classstudentmanagement.models.Course
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface ApiService {
    @GET("Courses")
    fun getCourses(): Call<List<Course>>

    companion object {

        private const val BASE_URL = "http://10.0.2.2:5125"

        fun getService() : ApiService {
            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            return retrofit.create(ApiService::class.java)
        }
    }
}