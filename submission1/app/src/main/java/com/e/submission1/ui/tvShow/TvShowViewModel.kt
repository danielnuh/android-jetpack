package com.e.submission1.ui.tvShow

import androidx.lifecycle.ViewModel
import com.e.submission1.data.TvShowEntity
import com.e.submission1.utils.DataDummy

class TvShowViewModel:ViewModel() {
    fun getData():List<TvShowEntity> = DataDummy.generatedDummyTvShow()

}