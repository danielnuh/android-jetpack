package com.e.submission1.ui.detail

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.e.submission1.R
import com.e.submission1.data.MovieEntity
import com.e.submission1.data.TvShowEntity
import com.e.submission1.databinding.ActivityDetailBinding
import com.e.submission1.utils.Helper
import com.e.submission1.viewModel.ViewModelFactory
import com.google.android.material.snackbar.Snackbar

class DetailActivity : AppCompatActivity() {
    companion object{
        const val EXTRA_TV_SHOW = "extra_tv_show"
        const val EXTRA_MOVIE = "extra_movie"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val viewModel = ViewModelProvider(this, ViewModelFactory.getInstance(this))[DetailViewModel::class.java]

        viewModel.state.observe(this){
            when(it){
                is DetailState.OnMassage -> {
                    Snackbar.make(window.decorView.rootView, it.message, Snackbar.LENGTH_SHORT).show()
                }

                is DetailState.OnShowData->{
                    if (!it.boolean){
                        binding.image.visibility = View.INVISIBLE
                        binding.title.visibility = View.INVISIBLE
                        binding.date.visibility = View.INVISIBLE
                        binding.description.visibility = View.INVISIBLE
                        binding.descriptionText.visibility = View.INVISIBLE
                    }else{
                        binding.image.visibility = View.VISIBLE
                        binding.title.visibility = View.VISIBLE
                        binding.date.visibility = View.VISIBLE
                        binding.description.visibility = View.VISIBLE
                        binding.descriptionText.visibility = View.VISIBLE
                    }
                }

                is DetailState.OnLoading ->{
                    if(it.boolean){
                        binding.progressBar.visibility = View.VISIBLE

                    }else{
                        binding.progressBar.visibility = View.GONE

                    }
                }
            }
        }


        if(intent.getParcelableExtra<MovieEntity>(EXTRA_MOVIE)!=null){
            val data = intent.getParcelableExtra<MovieEntity>(EXTRA_MOVIE)

            if (data != null) {
                viewModel.getDetailMovie(data.id).observe(this,{it ->
                    binding.title.text = it.title
                    binding.date.text = Helper.formatDate(it.date)
                    binding.description.text = it.description
                    Glide.with(this@DetailActivity)
                        .load(it.image)
                        .placeholder(Helper.shimmerImage())
                        .error(R.drawable.ic_image_broken)
                        .into(binding.image)
                })
            }
        }else{
            val data = intent.getParcelableExtra<TvShowEntity>(EXTRA_TV_SHOW)

            if (data != null) {
                viewModel.getDetailTvShow(data.id).observe(this,{it ->
                    binding.title.text = it.title
                    binding.date.text = Helper.formatDate(it.date)
                    binding.description.text = it.description
                    Glide.with(this@DetailActivity)
                        .load(it.image)
                        .placeholder(Helper.shimmerImage())
                        .error(R.drawable.ic_image_broken)
                        .into(binding.image)
                })
            }
        }

    }
}