package com.example.movielisterapp.data

import com.squareup.moshi.Json

data class Movie(

    val adult: Boolean,
    @Json(name = "backdrop_path") val backdropImagePath: String,
    @Json(name = "genre_ids") val genreIds: List<Int>,
    val id: Int,
    @Json(name = "original_language") val originalLanguage: String,
    @Json(name = "original_title") val originalTitle: String,
    val overview: String,
    val popularity: Double,
    @Json(name = "poster_path") val posterImagePath: String,
    @Json(name = "release_date") val posterDate: String,
    val title: String,
    val video: Boolean,
    @Json(name = "vote_average") val voteAverage: Double,
    @Json(name = "vote_count") val voteCount: Int,

    )