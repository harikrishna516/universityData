package com.sample.network

import com.sample.model.UniversityModel
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface ApiService {

    @GET("search?country=United+States")
    suspend fun getUniversities(): UniversityModel

    companion object {
        private const val BASE_URL = "http://universities.hipolabs.com/"
        fun create(): ApiService {
            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            return retrofit.create(ApiService::class.java)
        }
    }
}