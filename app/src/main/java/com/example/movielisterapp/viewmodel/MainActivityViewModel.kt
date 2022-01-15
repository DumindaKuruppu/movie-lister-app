package com.example.movielisterapp.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.movielisterapp.data.Movie
import com.example.movielisterapp.data.MoviesListData
import com.example.movielisterapp.data.Result
import com.example.movielisterapp.retrofit.RetroInstance
import com.example.movielisterapp.retrofit.RetroServiceInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivityViewModel {

    lateinit var liveDataList: MutableLiveData<List<MoviesListData>>

    init {
        liveDataList = MutableLiveData()
    }

    fun getLiveDataObserver(): MutableLiveData<List<MoviesListData>> {
        return liveDataList
    }

//    fun makeApiCall() {
//        val retroInstance = RetroInstance.getRetroInstance()
//        val retroService = retroInstance.create(RetroServiceInterface::class.java)
//        val call = retroService.getMovieList()
//        call.enqueue(object : Callback<List<MoviesListData>> {
//
//            //            override fun onResponse(call: Call<List<Movie>>, response: Response<List<Movie>>) {
//            override fun onResponse(call: Call<List<MoviesListData>>, response: Response<List<MoviesListData>>) {
//                Log.i("Mai", response.toString())
////                liveDataList.postValue(response.body())
//            }
//
//            override fun onFailure(call: Call<List<MoviesListData>>, t: Throwable) {
//                Log.i("Mai", "No Response")
//                liveDataList.postValue(null)
//            }
//
//        })
//
//    }


    fun makeApiCall() {
        val retroInstance = RetroInstance.getRetroInstance()
        val retroService = retroInstance.create(RetroServiceInterface::class.java)
        val call = retroService.getAnything()
        call.enqueue(object : Callback<List<MoviesListData>> {

            //            override fun onResponse(call: Call<List<Movie>>, response: Response<List<Movie>>) {
            override fun onResponse(call: Call<List<MoviesListData>>, response: Response<List<MoviesListData>>) {
                Log.i("Mai", response.toString())
//                liveDataList.postValue(response.body())
            }

            override fun onFailure(call: Call<List<MoviesListData>>, t: Throwable) {
                Log.i("Mai", "No Response")
                liveDataList.postValue(null)
            }

        })

    }


}