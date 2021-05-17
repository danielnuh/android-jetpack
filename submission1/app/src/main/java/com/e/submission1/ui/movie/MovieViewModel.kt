package com.e.submission1.ui.movie

import androidx.lifecycle.ViewModel
import com.e.submission1.data.MovieEntity
import com.e.submission1.utils.DataDummy

class MovieViewModel:ViewModel() {

    fun getData():List<MovieEntity> = DataDummy.generatedDummyMovie()
}