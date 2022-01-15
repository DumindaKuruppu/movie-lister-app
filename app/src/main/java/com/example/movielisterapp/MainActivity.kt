package com.example.movielisterapp

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.movielisterapp.databinding.ActivityMainBinding
import com.example.movielisterapp.adapter.MovieRecyclerViewAdapter
import com.example.movielisterapp.viewmodel.MainActivityViewModel

lateinit var binding: ActivityMainBinding
lateinit var recyclerAdapter: MovieRecyclerViewAdapter

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initRecyclerView()
        initViewModel()
    }


private fun initRecyclerView() {
        val recyclerView: RecyclerView = binding.movieListRecyclerView
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = MovieRecyclerViewAdapter()

    }

    private fun initViewModel() {
        val movieRecyclerViewAdapter:MainActivityViewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)

        movieRecyclerViewAdapter.getLiveDataObserver().observe(this, Observer {
            if(it != null) {
                recyclerAdapter.setMovieList(it)
                recyclerAdapter.notifyDataSetChanged()
            } else {
                Toast.makeText(this, "Error in getting list", Toast.LENGTH_SHORT).show()
            }
        })

        movieRecyclerViewAdapter.makeApiCall()
    }
}


