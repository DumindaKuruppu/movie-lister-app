package com.example.movielisterapp.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object ServiceBuilder {

    private const val URL = "https://api.themoviedb.org/3/movie/top_rated?api_key=55957fcf3ba81b137f8fc01ac5a31fb5&language=en-US&page=1"

    private val moshi = Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()

    private val okHttp2 : OkHttpClient.Builder = OkHttpClient.Builder()

    private val builder : Retrofit.Builder = Retrofit.Builder().baseUrl(URL)
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .client(okHttp2.build())


    private val retrofit : Retrofit = builder.build()

    fun <T> buildService(serviceType : Class <T>) :T {
        return retrofit.create(serviceType)
    }



}

//    private val retrofit = Retrofit.Builder()
//        .addConverterFactory(MoshiConverterFactory.create(moshi))
//        .baseUrl(URL)
//        .build()


