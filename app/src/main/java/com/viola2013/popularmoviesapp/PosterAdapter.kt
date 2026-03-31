package com.viola2013.popularmoviesapp

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import com.squareup.picasso.Picasso

class PosterAdapter(private val context: Context, private val movies: Array<Movie>) : BaseAdapter() {

    override fun getCount(): Int = movies.size

    override fun getItem(position: Int): Movie = movies[position]

    override fun getItemId(position: Int): Long = 0

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val imageView = if (convertView == null) {
            ImageView(context).apply {
                adjustViewBounds = true
            }
        } else {
            convertView as ImageView
        }

        Picasso.get()
            .load(movies[position].getFullPosterPath())
            .resize(
                context.resources.getInteger(R.integer.tmdb_poster_w185_width),
                context.resources.getInteger(R.integer.tmdb_poster_w185_height)
            )
            .error(R.drawable.not_found)
            .placeholder(R.drawable.searching)
            .into(imageView)

        return imageView
    }
}
