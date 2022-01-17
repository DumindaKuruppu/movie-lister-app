package com.example.movielisterapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
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


    class MovieViewHolder(cardView: View) : RecyclerView.ViewHolder(cardView) {

        private var movieTitle: TextView = cardView.movieTitle
        private var movieOriginalTitle: TextView = cardView.movieDetail
        private var movieImage: ImageView = cardView.movieImage

        fun bind(movieData: Result) {

            val IMAGE_BASE_URL = "https://image.tmdb.org/t/p/w500/"

            movieTitle.text = movieData.title
            movieOriginalTitle.text = movieData.originalTitle
            Glide.with(movieImage).load(IMAGE_BASE_URL + movieData.posterPath).into(movieImage)
        }
    }
}
