package com.example.movielisterapp.overview

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.movielisterapp.databinding.MovieItemBinding

class MovieRecyclerViewAdapter : RecyclerView.Adapter<MovieRecyclerViewAdapter.MovieViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        return MovieViewHolder(
            MovieItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.itemTitle.text = "The Matrix Resurrections"
        holder.itemDetails.text = "I thought this is going to be the best film ever but this sucks !"
    }

    override fun getItemCount(): Int {
        return 4;
    }


    class MovieViewHolder(val binding: MovieItemBinding) : RecyclerView.ViewHolder(binding.root) {

        var itemTitle = binding.movieTitle
        var itemDetails = binding.itemDetail
        var itemImage = binding.itemImage
    }

}