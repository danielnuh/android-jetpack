package com.e.submission1.ui.detail

import android.content.Intent
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.e.submission1.data.MovieEntity
import com.e.submission1.data.TvShowEntity
import com.e.submission1.utils.SingleLiveEvent
import com.e.submission1.viewModel.Repository

class DetailViewModel(private val repository: Repository, ) : ViewModel() {
    var state: SingleLiveEvent<DetailState> = SingleLiveEvent()

    fun getDetailMovie(id: String): LiveData<MovieEntity> = repository.getDetailMovie(id, state)
    fun getDetailTvShow(id: String): LiveData<TvShowEntity> = repository.getDetailTvShow(id, state)

}

sealed class DetailState{
    data class OnMassage(val message: String) : DetailState()
    data class OnLoading(val boolean: Boolean) : DetailState()
    data class OnShowData(val boolean: Boolean) : DetailState()
}