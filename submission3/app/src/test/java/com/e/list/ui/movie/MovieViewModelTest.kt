package com.e.list.ui.movie

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import com.e.list.data.source.Repository
import com.e.list.data.source.local.entity.MovieEntity
import com.e.list.utils.DataDummy
import com.e.list.vo.Resource
import junit.framework.TestCase
import org.junit.Assert
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
    private lateinit var observer: Observer<Resource<PagedList<MovieEntity>>>

    @Mock
    private lateinit var pageList: PagedList<MovieEntity>


    @Before
    fun setup(){
        viewModel = MovieViewModel(repository)
    }

    @Test
    fun getData(){
        val dummy = Resource.success(pageList)
        Mockito.`when`(dummy.data?.size).thenReturn(5)

        val movie = MutableLiveData<Resource<PagedList<MovieEntity>>>()
        movie.value = dummy

        Mockito.`when`(repository.getMovieList()).thenReturn(movie)

        val entities = viewModel.getMovie().value?.data
        Mockito.verify(repository).getMovieList()
        Assert.assertNotNull(entities)
        TestCase.assertEquals(5, entities?.size)

        viewModel.getMovie().observeForever(observer)
        Mockito.verify(observer).onChanged(dummy)
    }
}