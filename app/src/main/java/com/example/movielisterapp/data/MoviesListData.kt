package com.example.movielisterapp.data


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class MoviesListData(
    @Json(name = "page")
    val page: Int?,
    @Json(name = "results")
    val results: List<Result>?,
    @Json(name = "total_pages")
    val totalPages: Int?,
    @Json(name = "total_results")
    val totalResults: Int?
)