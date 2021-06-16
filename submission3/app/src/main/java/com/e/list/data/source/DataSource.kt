package com.e.list.data.source

import androidx.lifecycle.LiveData
import androidx.paging.PagedList
import com.e.list.data.source.local.entity.MovieEntity
import com.e.list.data.source.local.entity.TvShowEntity
import com.e.list.vo.Resource

interface DataSource {
    fun getMovieList(): LiveData<Resource<PagedList<MovieEntity>>>

    fun getDetailMovie(id: String): LiveData<Resource<MovieEntity>>

    fun getTvShowList(): LiveData<Resource<PagedList<TvShowEntity>>>

    fun getDetailTvShow(id: String): LiveData<Resource<TvShowEntity>>

    fun setFavoriteMovie(movieEntity: MovieEntity)

    fun setFavoriteTvShow(tvShowEntity: TvShowEntity)

    fun getFavoriteMovie():LiveData<PagedList<MovieEntity>>

    fun getFavoriteTvShow(): LiveData<PagedList<TvShowEntity>>
}