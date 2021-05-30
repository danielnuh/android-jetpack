package com.e.submission1.ui.tvShow

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.e.submission1.data.TvShowEntity
import com.e.submission1.ui.movie.MovieState
import com.e.submission1.utils.DataDummy
import com.e.submission1.utils.SingleLiveEvent
import com.e.submission1.viewModel.Repository

class TvShowViewModel(private val repository: Repository):ViewModel() {
    var state: SingleLiveEvent<TvShowState> = SingleLiveEvent()

    fun getData():LiveData<List<TvShowEntity>> = repository.getTvShowList(state)

}

sealed class TvShowState{
    data class OnMassage(val message: String) : TvShowState()
    data class OnLoading(val boolean: Boolean) : TvShowState()
    data class OnShowData(val boolean: Boolean) : TvShowState()
    data class IsEmpty(val boolean: Boolean) : TvShowState()
}