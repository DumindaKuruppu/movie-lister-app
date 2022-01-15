package com.example.movielisterapp.retrofit

import com.example.movielisterapp.data.MoviesListData
import retrofit2.Call
import retrofit2.http.GET

//private const val API_KEY = "55957fcf3ba81b137f8fc01ac5a31fb5"
//https://api.themoviedb.org/3/movie/top_rated?api_key=55957fcf3ba81b137f8fc01ac5a31fb5&language=en-US&page=1

interface RetroServiceInterface {

    @GET("3/movie/top_rated?api_key=55957fcf3ba81b137f8fc01ac5a31fb5&language=en-US&page=1")
    fun getMovieList(): Call<MoviesListData>


}