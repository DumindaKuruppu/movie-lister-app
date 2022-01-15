package com.example.movielisterapp.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.movielisterapp.data.MoviesListData
import com.example.movielisterapp.retrofit.RetroInstance
import com.example.movielisterapp.retrofit.RetroServiceInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivityViewModel : ViewModel() {



    fun showData(body: MoviesListData) {
        val listOfMovies = body.results
    }

    fun makeApiCall() {

        val retroInstance = RetroInstance.getRetroInstance()
        val retroService = retroInstance.create(RetroServiceInterface::class.java)
        val call = retroService.getMovieList()
        call.enqueue(object : Callback<MoviesListData> {


            override fun onResponse(call: Call<MoviesListData>, response: Response<MoviesListData>) {
                Log.i("Duminda", "Yes you have a response")
//                Log.i("Mai", response.toString())
                showData(response.body()!!)
            }

            override fun onFailure(call: Call<MoviesListData>, t: Throwable) {
                Log.i("Duminda", "No Response")
            }
        })
    }
}



