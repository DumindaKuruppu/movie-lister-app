package com.example.movielisterapp.data

data class MoviesListData(
    val page: Double,
    val results: List<Result>,
    val total_pages: Double,
    val total_results: Double
)