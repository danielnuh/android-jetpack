package com.e.submission1.ui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.e.submission1.R
import com.e.submission1.data.MovieEntity
import com.e.submission1.data.TvShowEntity
import com.e.submission1.databinding.ActivityDetailBinding
import java.text.SimpleDateFormat

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

        val viewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory())[DetailViewModel::class.java]


        if(intent.getParcelableExtra<MovieEntity>(EXTRA_MOVIE)!=null){
            val data = intent.getParcelableExtra<MovieEntity>(EXTRA_MOVIE)

            if (data != null) {
                viewModel.setMovie(data)
                val temp = viewModel.getMovie()

                binding.title.text = temp.title
                binding.date.text = SimpleDateFormat("dd MMMM yyyy").format(SimpleDateFormat("MM/dd/yyyy").parse(temp.date)).toString()
                binding.image.setImageResource(temp.image)
                binding.description.text = temp.description
            }
        }else{
            val data = intent.getParcelableExtra<TvShowEntity>(EXTRA_TV_SHOW)

            if (data != null) {
                viewModel.setTvShow(data)
                val temp = viewModel.getTvShow()

                binding.title.text = temp.title
                binding.date.text = SimpleDateFormat("dd MMMM yyyy").format(SimpleDateFormat("MM/dd/yyyy").parse(temp.date)).toString()
                binding.image.setImageResource(temp.image)
                binding.description.text = temp.description
            }
        }

    }
}