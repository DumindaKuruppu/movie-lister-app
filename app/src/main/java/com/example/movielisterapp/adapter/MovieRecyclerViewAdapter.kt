package com.example.movielisterapp.adapter

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.movielisterapp.R
import com.example.movielisterapp.binding
import com.example.movielisterapp.data.Results
import com.example.movielisterapp.databinding.MovieCardBinding

class MovieRecyclerViewAdapter() : RecyclerView.Adapter<MovieRecyclerViewAdapter.MovieViewHolder>() {

    private var movieList: List<Results>? = null

    private var images = R.drawable.matrix

    fun setMovieList(movieList: Results) {
        this.movieList = listOf(movieList)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        return MovieViewHolder(MovieCardBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
//        holder.bind(data?.get(position)!!,activity)
//        holder.bind(movieList?.get(position)!!, activity = Activity())

        holder.itemTitle.text = "The Matrix Resurrections"
        holder.itemDetails.text = "I thought this is going to be the best!"
        holder.itemImage.setImageResource(images)
    }

    override fun getItemCount(): Int {
        return if (movieList == null) { 4
    //            binding.progressBar.visibility = View.VISIBLE
        } else {
            binding.progressBar.visibility = View.GONE
            movieList?.size!!
        }
    }

    class MovieViewHolder(binding: MovieCardBinding) : RecyclerView.ViewHolder(binding.root) {

        var itemTitle = binding.movieTitle
        var itemDetails = binding.itemDetail
        var itemImage = binding.itemImage

        fun bind(data: Results, activity: Activity){

            itemTitle.text = data.title
            itemDetails.text = data.overview




        }
    }
}
