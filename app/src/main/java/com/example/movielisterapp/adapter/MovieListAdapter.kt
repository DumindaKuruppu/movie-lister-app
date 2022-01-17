package com.example.movielisterapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.movielisterapp.R
import com.example.movielisterapp.data.Result
import kotlinx.android.synthetic.main.movie_card.view.*

class MovieListAdapter : RecyclerView.Adapter<MovieListAdapter.MovieViewHolder>() {

    private var movieList: List<Result>? = null

    fun setMovieList(movieList: List<Result>) {
        this.movieList = movieList
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.movie_card, parent, false)
        return MovieViewHolder(view)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bind(movieList?.get(position)!!)
    }

    override fun getItemCount(): Int {
        return if (movieList == null) {
            0
        } else movieList?.size!!
    }


    class MovieViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private var itemTitle: TextView = view.movieTitle
        private var itemOriginalTitle: TextView = view.movieDetail

        fun bind(movieData: Result) {

            itemTitle.text = movieData.title
            itemOriginalTitle.text = movieData.originalTitle



        }
    }
}
