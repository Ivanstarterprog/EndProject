package com.example.endproject

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query


interface KinopoiskApiService {
    @Headers("X-API-KEY: your_api_key") // Замените на ваш API-ключ
    @GET("v2.2/films/top")
    fun getTopFilms(@Query("type") type: String, @Query("page") page: Int): Call<FilmsList>
}

object RetrofitClient {
    private const val BASE_URL = "https://kinopoiskapiunofficial.tech/api/"

    val instance: KinopoiskApiService by lazy {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        retrofit.create(KinopoiskApiService::class.java)
    }
}