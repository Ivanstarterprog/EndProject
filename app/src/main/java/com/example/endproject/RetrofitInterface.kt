package com.example.endproject

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query
import retrofit2.http.Path


interface KinopoiskApiService {
    @Headers("X-API-KEY: 5fe0e1e8-f301-4e84-a058-b6693498a697")
    @GET("v2.2/films")
    fun getAllFilms() : Call<FilmsList>
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