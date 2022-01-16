package com.example.movielisterapp.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.movielisterapp.data.MovieModel
import com.example.movielisterapp.data.Results
import com.example.movielisterapp.retrofit.RetroInstance
import com.example.movielisterapp.retrofit.RetroServiceInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivityViewModel : ViewModel() {

    var liveDataList: MutableLiveData<Results> = MutableLiveData()


    fun getLiveDataObserver(): MutableLiveData<Results> {
        return liveDataList
    }


    fun makeApiCall() {

        val retroInstance = RetroInstance.getRetroInstance()
        val retroService = retroInstance.create(RetroServiceInterface::class.java)
        val call = retroService.getMovieList()
        call.enqueue(object : Callback<MovieModel> {


            override fun onResponse(call: Call<MovieModel>, response: Response<MovieModel>) {
                Log.i("Duminda", "Yes you have a response")
                Log.i("Duminda", response.toString())

                if (response.isSuccessful) {
                    val movieResponse = response.body()!!
                    for (results in movieResponse.results!!) {
                        Log.v("Duminda", results.title.toString())
                    }
                }


//                liveDataList.postValue(response.body())


            }

            override fun onFailure(call: Call<MovieModel>, t: Throwable) {
                Log.i("Duminda", "No Response")
                liveDataList.postValue(null)
            }
        })
    }
}



