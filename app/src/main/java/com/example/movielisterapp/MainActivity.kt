package com.example.movielisterapp

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.movielisterapp.adapter.MovieListAdapter
import com.example.movielisterapp.viewmodel.MainActivityViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var recyclerListAdapter: MovieListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initRecyclerView()
        initViewModel()
    }


    private fun initRecyclerView() {
        movieListRecyclerView.layoutManager = LinearLayoutManager(this)
        recyclerListAdapter = MovieListAdapter()
        movieListRecyclerView.adapter = recyclerListAdapter

    }

    private fun initViewModel() {
        val movieRecyclerViewAdapter: MainActivityViewModel =
            ViewModelProvider(this).get(MainActivityViewModel::class.java)

        movieRecyclerViewAdapter.getLiveDataObserver().observe(this, Observer {
            if (it != null) {
                recyclerListAdapter.setMovieList(it)
                recyclerListAdapter.notifyDataSetChanged()
            } else {
                Toast.makeText(this, "Error getting list", Toast.LENGTH_SHORT).show()
            }
        })

        movieRecyclerViewAdapter.makeApiCall()
    }
}