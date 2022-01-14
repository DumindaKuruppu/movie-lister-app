package com.example.movielisterapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.movielisterapp.databinding.ActivityMainBinding
import com.example.movielisterapp.overview.MovieRecyclerViewAdapter

lateinit var binding: ActivityMainBinding

private var layoutManager: RecyclerView.LayoutManager? = null
private var adapter: RecyclerView.Adapter<MovieRecyclerViewAdapter.MovieViewHolder>? = null

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val recyclerView : RecyclerView = binding.recyclerViewMovies

        layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager

        adapter = MovieRecyclerViewAdapter()
        recyclerView.adapter = adapter


    }


}