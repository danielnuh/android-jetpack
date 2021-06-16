package com.e.list.ui.favorite.tvshow

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.e.list.data.source.Repository
import com.e.list.data.source.local.entity.TvShowEntity

class FavoriteTvShowViewModel(private val repository: Repository):ViewModel() {
    fun getTvShow(): LiveData<PagedList<TvShowEntity>> = repository.getFavoriteTvShow()
}