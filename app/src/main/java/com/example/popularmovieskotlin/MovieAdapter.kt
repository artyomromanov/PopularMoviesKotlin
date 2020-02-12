package com.example.popularmovieskotlin

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class MovieAdapter(val movieModel: MovieModel, val movieClickListener: OnViewClickListener) : RecyclerView.Adapter<MovieAdapter.ViewHolder?>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.movies_list, parent, false)

        return ViewHolder(view)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

       holder.bind(movieClickListener, movieModel.results!![position])

    }

    override fun getItemCount(): Int {

        return movieModel.results!!.size

    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val tvTitle: TextView = itemView.findViewById(R.id.tv_title)
        val mRatingBar: RatingBar = itemView.findViewById(R.id.rb_rating)
        val mMovieImage: ImageView = itemView.findViewById(R.id.iv_poster)

        fun bind(movieClickListener: OnViewClickListener, item : Result) {

            //rating

            val rateMovie: Double? = (item.voteAverage)

            mRatingBar.rating = rateMovie!!.toFloat() / 2

            //title

            tvTitle.text = item.title

            //image

            val fullMovieUrlPath: String = BASE_IMAGE_URL + BASE_FILE_SIZE_SMALL + item.posterPath

            Picasso.get().load(fullMovieUrlPath).into(mMovieImage)

            //listener

            itemView.setOnClickListener { movieClickListener.onRecyclerItemClicked(item.id as Int) }

        }

    }

}


