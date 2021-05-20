package com.e.submission1.ui.movie

import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class MovieViewModelTest{
    private lateinit var viewModel : MovieViewModel

    @Before
    fun setUp(){
        viewModel = MovieViewModel()
    }
    @Test
    fun getCourse(){
        val movieEntity = viewModel.getData()
        assertNotNull(movieEntity)
        assertEquals(10, movieEntity.size)
    }
}