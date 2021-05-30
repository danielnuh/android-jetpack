package com.e.submission1.ui.tvShow

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.e.submission1.R
import com.e.submission1.data.TvShowEntity
import com.e.submission1.databinding.ItemsTvshowBinding
import com.e.submission1.ui.detail.DetailActivity
import com.e.submission1.utils.Helper
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

class TvShowAdapter:RecyclerView.Adapter<TvShowAdapter.TvShowViewHolder>() {

    private val listTvShow = ArrayList<TvShowEntity>()

    fun setData(listTvShow: List<TvShowEntity>){
        this.listTvShow.clear()
        this.listTvShow.addAll(listTvShow)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TvShowViewHolder {
        return TvShowViewHolder(ItemsTvshowBinding.inflate(LayoutInflater.from(parent.context),parent, false))
    }

    override fun onBindViewHolder(holder: TvShowViewHolder, position: Int) {
        holder.bind(listTvShow[position])
    }

    override fun getItemCount(): Int = listTvShow.size

    class TvShowViewHolder(private val binding: ItemsTvshowBinding):RecyclerView.ViewHolder(binding.root){
        fun bind(tvShow :TvShowEntity){
            with(binding){
                title.text = tvShow.title
                date.text = Helper.formatDate(tvShow.date)

                Glide.with(itemView.context)
                    .load(tvShow.image)
                    .placeholder(Helper.shimmerImage())
                    .error(R.drawable.ic_image_broken)
                    .into(image)

                itemView.setOnClickListener {
                    val intent = Intent(itemView.context, DetailActivity::class.java)
                    intent.putExtra(DetailActivity.EXTRA_TV_SHOW, tvShow)
                    itemView.context.startActivity(intent)
                }
            }
        }
    }
}