package com.e.submission1.ui.detail

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.e.submission1.data.MovieEntity
import com.e.submission1.data.TvShowEntity
import com.e.submission1.utils.DataDummy
import com.e.submission1.viewModel.Repository
import junit.framework.TestCase
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class DetailViewModelTest{
    private lateinit var viewModel : DetailViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var repository: Repository

    @Mock
    private lateinit var observerMovie: Observer<MovieEntity>


    @Before
    fun setup(){
        viewModel = DetailViewModel(repository)
    }

    @Test
    fun getMovieDetail(){
        val dummy = DataDummy.generatedDummyMovieEntity()[0]
        val movie = MutableLiveData<MovieEntity>()
        movie.value = dummy

        Mockito.`when`(repository.getDetailMovie(dummy.id,viewModel.state)).thenReturn(movie)
        val data = viewModel.getDetailMovie(dummy.id).value
        Mockito.verify(repository).getDetailMovie(dummy.id,viewModel.state)
        TestCase.assertNotNull(data)

        viewModel.getDetailMovie(dummy.id).observeForever(observerMovie)
        Mockito.verify(observerMovie).onChanged(dummy)
    }

    @Mock
    private lateinit var observerTvShow: Observer<TvShowEntity>

    @Test
    fun getTvShowDetail(){
        val dummy = DataDummy.generatedDummyTvShowEntity()[0]
        val tvShow = MutableLiveData<TvShowEntity>()
        tvShow.value = dummy

        Mockito.`when`(repository.getDetailTvShow(dummy.id,viewModel.state)).thenReturn(tvShow)
        val data = viewModel.getDetailTvShow(dummy.id).value
        Mockito.verify(repository).getDetailTvShow(dummy.id,viewModel.state)
        TestCase.assertNotNull(data)

        viewModel.getDetailTvShow(dummy.id).observeForever(observerTvShow)
        Mockito.verify(observerTvShow).onChanged(dummy)
    }
}