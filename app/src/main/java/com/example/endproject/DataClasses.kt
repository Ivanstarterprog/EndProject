package com.example.endproject

data class Country(
    val country: String
)

data class Genre(
    val genre: String
)

data class Film(
    val kinopoiskId: Int,
    val imdbId: String,
    val nameRu: String,
    val nameEn: String,
    val nameOriginal: String,
    val countries: List<Country>,
    val genres: List<Genre>,
    val ratingKinopoisk: Double,
    val ratingImdb: Double,
    val year: Int,
    val type: String,
    val posterUrl: String,
    val posterUrlPreview: String

)

data class FilmsList(
    val total: Int,
    val totalPages: Int,
    val items: ArrayList<Film>
)