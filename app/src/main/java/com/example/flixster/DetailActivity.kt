package com.example.flixster

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView


private const val TAG = "DetailActivity"
class DetailActivity : AppCompatActivity(){

    private lateinit var tvTitle: TextView
    private lateinit var tvOverview: TextView
    private lateinit var tvReleaseDate: TextView
    private lateinit var tvVoteAverage: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        tvTitle = findViewById(R.id.title)
        tvOverview = findViewById(R.id.overview)
        tvReleaseDate = findViewById(R.id.releaseDate)
        tvVoteAverage = findViewById(R.id.voteAverage)

        val movie = intent.getSerializableExtra(MOVIE_EXTRA) as Movie
        Log.i(TAG, "Movie is $movie")

        tvTitle.text = movie.title
        tvOverview.text = movie.overview
        tvReleaseDate.text = getString(R.string.release_date, movie.releaseDate)
        tvVoteAverage.text = getString(R.string.vote_average, movie.voteAverage.toString())
    }
}