package com.yourname.cattiktok

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface CatApiService {
    @GET("v1/images/search")
    suspend fun getRandomCat(): List<CatImage>
}

data class CatImage(val url: String)

object RetrofitClient {
    private const val BASE_URL = "https://api.thecatapi.com/"

    val apiService: CatApiService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CatApiService::class.java)
    }
}
