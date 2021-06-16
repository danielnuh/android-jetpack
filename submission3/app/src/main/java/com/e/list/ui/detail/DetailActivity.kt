package com.e.list.ui.detail

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.e.list.R
import com.e.list.data.source.local.entity.MovieEntity
import com.e.list.data.source.local.entity.TvShowEntity
import com.e.list.databinding.ActivityDetailBinding
import com.e.list.utils.Helper
import com.e.list.viewModel.ViewModelFactory
import com.e.list.vo.Status
import com.google.android.material.snackbar.Snackbar

class DetailActivity : AppCompatActivity() {
    companion object {
        const val EXTRA_TV_SHOW = "extra_tv_show"
        const val EXTRA_MOVIE = "extra_movie"
    }

    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val vactory = ViewModelFactory.getInstance(this)
        val viewModel = ViewModelProvider(this, vactory)[DetailViewModel::class.java]


        if (intent.getParcelableExtra<MovieEntity>(EXTRA_MOVIE) != null) {
            val data = intent.getParcelableExtra<MovieEntity>(EXTRA_MOVIE)

            if (data != null) {
                viewModel.getMovieDetail(data.id).observe(this, { result ->
                    if (result != null) {
                        when (result.status) {
                            Status.LOADING -> {
                                isLoading(true)
                                isHideContent(true)
                            }

                            Status.ERROR -> {
                                isLoading(false)
                                isHideContent(true)
                                message(result.message!!)

                            }

                            Status.SUCCESS -> {
                                if (result.data != null) {

                                    isLoading(false)
                                    isHideContent(false)
                                    binding.title.text = result.data.title
                                    binding.date.text = Helper.formatDate(result.data.date)
                                    binding.description.text = result.data.description
                                    Glide.with(this@DetailActivity)
                                        .load(result.data.image)
                                        .placeholder(Helper.shimmerImage())
                                        .error(R.drawable.ic_image_broken)
                                        .into(binding.image)
                                    isFavorite(result.data.isFavorite)
                                    binding.btnFavorite.setOnClickListener {
                                        viewModel.setFavorite(result.data)
                                    }
                                }
                            }
                        }
                    }
                })
            }
        } else {
            val data = intent.getParcelableExtra<TvShowEntity>(EXTRA_TV_SHOW)

            if (data != null) {
                viewModel.getTvShowDetail(data.id).observe(this, { result ->
                    if (result != null) {
                        when (result.status) {
                            Status.LOADING -> {
                                isLoading(true)
                                isHideContent(true)
                            }

                            Status.ERROR -> {
                                isLoading(false)
                                isHideContent(true)
                                message(result.message!!)

                            }

                            Status.SUCCESS -> {
                                isLoading(false)
                                isHideContent(false)
                                binding.title.text = result.data!!.title
                                binding.date.text = Helper.formatDate(result.data!!.date)
                                binding.description.text = result.data!!.description
                                Glide.with(this@DetailActivity)
                                    .load(result.data!!.image)
                                    .placeholder(Helper.shimmerImage())
                                    .error(R.drawable.ic_image_broken)
                                    .into(binding.image)
                                isFavorite(result.data.isFavorite)
                                binding.btnFavorite.setOnClickListener {
                                    viewModel.setFavorite(result.data)
                                }
                            }
                        }
                    }
                })
            }
        }
    }

    private fun isFavorite(b: Boolean) {
        if (b) {
            binding.btnFavorite.setImageResource(R.drawable.ic_favorite_active)
        } else {
            binding.btnFavorite.setImageResource(R.drawable.ic_favorite_border)
        }
    }

    private fun isLoading(b: Boolean) {
        if (b) {
            binding.progressBar.visibility = View.VISIBLE
        } else {
            binding.progressBar.visibility = View.GONE
        }
    }

    private fun message(s: String) {
        Snackbar.make(window.decorView.rootView, s, Snackbar.LENGTH_SHORT).show()
    }

    private fun isHideContent(b: Boolean) {
        if (b) {
            binding.image.visibility = View.INVISIBLE
            binding.title.visibility = View.INVISIBLE
            binding.date.visibility = View.INVISIBLE
            binding.description.visibility = View.INVISIBLE
            binding.descriptionText.visibility = View.INVISIBLE
        } else {
            binding.image.visibility = View.VISIBLE
            binding.title.visibility = View.VISIBLE
            binding.date.visibility = View.VISIBLE
            binding.description.visibility = View.VISIBLE
            binding.descriptionText.visibility = View.VISIBLE
        }
    }
}