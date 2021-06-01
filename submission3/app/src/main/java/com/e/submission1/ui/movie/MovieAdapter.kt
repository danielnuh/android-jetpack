package com.e.submission1.ui.movie

import android.annotation.SuppressLint
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.e.submission1.R
import com.e.submission1.data.MovieEntity
import com.e.submission1.databinding.ItemsMovieBinding
import com.e.submission1.ui.detail.DetailActivity
import com.e.submission1.utils.Helper
import com.facebook.shimmer.Shimmer
import com.facebook.shimmer.ShimmerDrawable
import kotlin.collections.ArrayList

class MovieAdapter:RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    private val listMovie = ArrayList<MovieEntity>()

    fun setData(listMovie : List<MovieEntity>){
        this.listMovie.clear()
        this.listMovie.addAll(listMovie)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        return MovieViewHolder(ItemsMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bind(listMovie[position])
    }

    override fun getItemCount(): Int = listMovie.size

    class MovieViewHolder(private val binding: ItemsMovieBinding) : RecyclerView.ViewHolder(binding.root){
        @SuppressLint("ResourceType")
        fun bind(movie:MovieEntity){

            with(binding){
                title.text = movie.title
                date.text = Helper.formatDate(movie.date)
                Glide.with(itemView.context)
                    .load(movie.image)
                    .placeholder(Helper.shimmerImage())
                    .error(R.drawable.ic_image_broken)
                    .into(image)

                itemView.setOnClickListener {
                    val intent = Intent(itemView.context, DetailActivity::class.java)
                    intent.putExtra(DetailActivity.EXTRA_MOVIE, movie)
                    itemView.context.startActivity(intent)
                }
            }
        }
    }
}