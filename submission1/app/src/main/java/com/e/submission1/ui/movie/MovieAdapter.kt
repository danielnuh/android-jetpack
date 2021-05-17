package com.e.submission1.ui.movie

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.e.submission1.data.MovieEntity
import com.e.submission1.databinding.ItemsMovieBinding
import com.e.submission1.ui.detail.DetailActivity
import java.text.SimpleDateFormat

class MovieAdapter:RecyclerView.Adapter<MovieAdapter.MoviewViewHolder>() {

    private val listMovie = ArrayList<MovieEntity>()

    fun setData(listMovie : List<MovieEntity>){
        this.listMovie.clear()
        this.listMovie.addAll(listMovie)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviewViewHolder {
        return MoviewViewHolder(ItemsMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: MoviewViewHolder, position: Int) {
        holder.bind(listMovie[position])
    }

    override fun getItemCount(): Int = listMovie.size

    class MoviewViewHolder(private val binding: ItemsMovieBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(movie:MovieEntity){
            with(binding){
                title.text = movie.title
                date.text = SimpleDateFormat("dd MMMM yyyy").format(SimpleDateFormat("MM/dd/yyyy").parse(movie.date)).toString()
                image.setImageResource(movie.image)
                itemView.setOnClickListener {
                    val intent = Intent(itemView.context, DetailActivity::class.java)
                    intent.putExtra(DetailActivity.EXTRA_MOVIE, movie)
                    itemView.context.startActivity(intent)
                }
            }
        }
    }
}