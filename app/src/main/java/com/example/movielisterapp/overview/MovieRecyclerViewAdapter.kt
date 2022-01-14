package com.example.movielisterapp.overview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.movielisterapp.databinding.MovieItemBinding

class MovieRecyclerViewAdapter : RecyclerView.Adapter<MovieRecyclerViewAdapter.MovieViewHolder>() {

    class MovieViewHolder(val binding: MovieItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        return MovieViewHolder(MovieItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.binding.movieTitle
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

}