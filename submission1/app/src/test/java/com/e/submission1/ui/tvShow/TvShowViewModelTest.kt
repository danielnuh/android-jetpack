package com.e.submission1.ui.tvShow

import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class TvShowViewModelTest{
    private lateinit var viewModel : TvShowViewModel

    @Before
    fun setUp(){
        viewModel = TvShowViewModel()
    }
    @Test
    fun getCourse(){
        val tvShowEntity = viewModel.getData()
        assertNotNull(tvShowEntity)
        assertEquals(10, tvShowEntity.size)
    }
}