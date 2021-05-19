package com.e.submission1.ui.detail

import androidx.lifecycle.ViewModel
import com.e.submission1.data.MovieEntity
import com.e.submission1.data.TvShowEntity
import com.e.submission1.utils.DataDummy

class DetailViewModel: ViewModel() {
    private lateinit var movieEntityTemp: MovieEntity
    private lateinit var tvShowEntityTemp: TvShowEntity

    fun setMovie(movieEntity: MovieEntity){
        movieEntityTemp = movieEntity
    }

    fun setTvShow(tvShowEntity: TvShowEntity){
        tvShowEntityTemp = tvShowEntity
    }

    fun getMovie():MovieEntity{
        lateinit var movieEntity:MovieEntity

        for (item in DataDummy.generatedDummyMovie()){
            if (item.id == movieEntityTemp.id){
                movieEntity = item
            }
        }

        return movieEntity
    }

    fun getTvShow():TvShowEntity{
        lateinit var tvShowEntity: TvShowEntity

        for (item in DataDummy.generatedDummyTvShow()){
            if (item.id == tvShowEntityTemp.id){
                tvShowEntity = item
            }
        }

        return tvShowEntity
    }
}