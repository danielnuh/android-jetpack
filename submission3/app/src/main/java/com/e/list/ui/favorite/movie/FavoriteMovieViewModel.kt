package com.e.list.ui.favorite.movie

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.e.list.data.source.Repository
import com.e.list.data.source.local.entity.MovieEntity

class FavoriteMovieViewModel(private val  repository: Repository): ViewModel() {

    fun getMovie(): LiveData<PagedList<MovieEntity>> = repository.getFavoriteMovie()
}