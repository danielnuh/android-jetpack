package com.e.submission1.ui.movie

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.e.submission1.data.MovieEntity
import com.e.submission1.utils.DataDummy
import com.e.submission1.viewModel.Repository
import junit.framework.TestCase
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class MovieViewModelTest{
    private lateinit var viewModel : MovieViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var repository: Repository

    @Mock
    private lateinit var observer: Observer<List<MovieEntity>>


    @Before
    fun setup(){
        viewModel = MovieViewModel(repository)
    }

    @Test
    fun getData(){
        val dummy = DataDummy.generatedDummyMovieEntity()
        val tvShow = MutableLiveData<List<MovieEntity>>()
        tvShow.value = dummy

        Mockito.`when`(repository.getMovieList(viewModel.state)).thenReturn(tvShow)
        val data = viewModel.getData().value
        Mockito.verify(repository).getMovieList(viewModel.state)
        TestCase.assertNotNull(data)
        assertEquals(10, data?.size)

        viewModel.getData().observeForever(observer)
        Mockito.verify(observer).onChanged(dummy)
    }
}