package com.e.submission1.ui.movie

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.e.submission1.data.MovieEntity
import com.e.submission1.utils.DataDummy
import com.e.submission1.utils.SingleLiveEvent
import com.e.submission1.viewModel.Repository

class MovieViewModel(private val repository: Repository):ViewModel() {

    var state: SingleLiveEvent<MovieState> = SingleLiveEvent()

    fun getData():LiveData<List<MovieEntity>> = repository.getMovieList(state)
}

sealed class MovieState{
    data class OnMassage(val message: String) : MovieState()
    data class OnLoading(val boolean: Boolean) : MovieState()
    data class OnShowData(val boolean: Boolean) : MovieState()
    data class IsEmpty(val boolean: Boolean) : MovieState()
}