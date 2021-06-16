package com.e.list.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.e.list.data.source.Repository
import com.e.list.data.source.local.entity.MovieEntity
import com.e.list.data.source.local.entity.TvShowEntity
import com.e.list.vo.Resource

class DetailViewModel(private var repository: Repository):ViewModel() {

    fun getMovieDetail(id:String):LiveData<Resource<MovieEntity>> = repository.getDetailMovie(id)

    fun getTvShowDetail(id:String): LiveData<Resource<TvShowEntity>> = repository.getDetailTvShow(id)

    fun setFavorite(movieEntity: MovieEntity){
        movieEntity.isFavorite = swap(movieEntity.isFavorite)
        repository.setFavoriteMovie(movieEntity)
    }

    fun setFavorite(tvShowEntity: TvShowEntity){
        tvShowEntity.isFavorite = swap(tvShowEntity.isFavorite)
        repository.setFavoriteTvShow(tvShowEntity)
    }

    private fun swap(b: Boolean):Boolean{
        if (b) return false
        return true
    }
}