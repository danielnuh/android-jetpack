package com.e.list.ui.detail

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.e.list.data.source.Repository
import com.e.list.data.source.local.entity.MovieEntity
import com.e.list.data.source.local.entity.TvShowEntity
import com.e.list.utils.DataDummy
import com.e.list.vo.Resource
import junit.framework.Assert.assertEquals
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
    private lateinit var viewModel: DetailViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var repository: Repository

    @Mock
    private lateinit var observerMovie: Observer<Resource<MovieEntity>>


    @Before
    fun setup(){
        viewModel = DetailViewModel(repository)
    }

    @Test
    fun getMovieDetail(){
        val dummy = Resource.success(DataDummy.generatedDummyMovieEntity()[0])
        val movie = MutableLiveData<Resource<MovieEntity>>()
        movie.value = dummy

        Mockito.`when`(repository.getDetailMovie(dummy.data!!.id)).thenReturn(movie)
        val data = viewModel.getMovieDetail(dummy.data!!.id).value
        Mockito.verify(repository).getDetailMovie(dummy.data!!.id)
        TestCase.assertNotNull(data)

        viewModel.getMovieDetail(dummy.data!!.id).observeForever(observerMovie)
        Mockito.verify(observerMovie).onChanged(dummy)
        assertEquals(dummy.data!!.id, data?.data?.id)
    }

    @Mock
    private lateinit var observerTvShow: Observer<Resource<TvShowEntity>>

    @Test
    fun getTvShowDetail(){
        val dummy = Resource.success(DataDummy.generatedDummyTvShowEntity()[0])
        val tvShow = MutableLiveData<Resource<TvShowEntity>>()
        tvShow.value = dummy

        Mockito.`when`(repository.getDetailTvShow(dummy.data!!.id)).thenReturn(tvShow)
        val data = viewModel.getTvShowDetail(dummy.data!!.id).value
        Mockito.verify(repository).getDetailTvShow(dummy.data!!.id)
        TestCase.assertNotNull(data)

        viewModel.getTvShowDetail(dummy.data!!.id).observeForever(observerTvShow)
        Mockito.verify(observerTvShow).onChanged(dummy)
        assertEquals(dummy.data!!.id, data?.data?.id)
    }
}