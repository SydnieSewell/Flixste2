package com.example.flixster


import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView


private const val TAG = "MovieAdapter"
class MovieAdapter(private val context: Context, private val movies: List<Movie>):
    RecyclerView.Adapter<MovieAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        Log.i(TAG, "onCreateViewHolder")
        val view = LayoutInflater.from(context).inflate(R.layout.item_movie, parent, false)
        return ViewHolder(view)
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Log.i(TAG, "onBindViewHolder position $position")
        val movie = movies[position]
        holder.bind(movie)
    }

   override fun getItemCount() = movies.size

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val ivPoster = itemView.findViewById<ImageView>(R.id.ivPoster)
        private val showTitle = itemView.findViewById<TextView>(R.id.mvTitle)
        private val showOverview = itemView.findViewById<TextView>(R.id.mvOverview)

        fun bind(movie: Movie) {
            showTitle.text = movie.title
            showOverview.text = movie.overview


        //The snippet for the glide
            Glide.with(context).load(movie.posterPath).placeholder(R.drawable.placeholder_image)
                .error(R.drawable.placeholder_image)
                .into(ivPoster)
        }
    }
}