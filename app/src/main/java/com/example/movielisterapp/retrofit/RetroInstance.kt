package com.example.movielisterapp.retrofit

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class RetroInstance {

    companion object {
        private const val BASE_URL = "https://api.themoviedb.org/"
//        private const val API_KEY = "55957fcf3ba81b137f8fc01ac5a31fb5"
        private val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()

        fun getRetroInstance(): Retrofit {
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(MoshiConverterFactory.create(moshi))
                .build()
        }
    }
}

