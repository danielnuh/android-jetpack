package com.e.list.ui.movie

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.e.list.data.source.Repository
import com.e.list.data.source.local.entity.MovieEntity
import com.e.list.vo.Resource

class MovieViewModel(private val repository:Repository):ViewModel() {
    fun getMovie(): LiveData<Resource<PagedList<MovieEntity>>> = repository.getMovieList()
}