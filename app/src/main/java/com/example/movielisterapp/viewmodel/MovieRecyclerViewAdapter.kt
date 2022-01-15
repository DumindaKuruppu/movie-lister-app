package com.example.movielisterapp.viewmodel

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.movielisterapp.binding
import com.example.movielisterapp.data.Movie
import com.example.movielisterapp.databinding.MovieItemBinding

class MovieRecyclerViewAdapter : RecyclerView.Adapter<MovieRecyclerViewAdapter.MovieViewHolder>() {

    private var movieList: List<Movie>? = null

    fun setMovieList() {
        this.movieList = movieList
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        return MovieViewHolder(MovieItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {

        MainActivityViewModel().makeApiCall()

        holder.itemTitle.text = "The Matrix Resurrections"
        holder.itemDetails.text = "I thought this is going to be the best film ever but this sucks !"


    }

    override fun getItemCount(): Int {
        if (movieList == null) {
//            binding.progressBar.visibility = View.VISIBLE
            return 4
        }
        else {
            binding.progressBar.visibility = View.GONE
            return movieList?.size!!
        }
    }

    class MovieViewHolder(private val binding: MovieItemBinding) : RecyclerView.ViewHolder(binding.root) {

        var itemTitle = binding.movieTitle
        var itemDetails = binding.itemDetail
        var itemImage = binding.itemImage

        fun bind(data: Movie){

        }
    }

}