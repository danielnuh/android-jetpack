package com.e.submission1.data.source.remote

import androidx.lifecycle.LiveData
import com.e.submission1.data.MovieEntity
import com.e.submission1.data.TvShowEntity
import com.e.submission1.ui.detail.DetailState
import com.e.submission1.ui.movie.MovieState
import com.e.submission1.ui.tvShow.TvShowState
import com.e.submission1.utils.SingleLiveEvent

interface DataSource {
    fun getMovieList(state: SingleLiveEvent<MovieState>): LiveData<List<MovieEntity>>

    fun getTvShowList(state: SingleLiveEvent<TvShowState>): LiveData<List<TvShowEntity>>

    fun getDetailMovie(id: String, state:SingleLiveEvent<DetailState>): LiveData<MovieEntity>

    fun getDetailTvShow(id: String, state:SingleLiveEvent<DetailState>): LiveData<TvShowEntity>
}