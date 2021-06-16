package com.e.list.ui.favorite.movie


import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import com.e.list.data.source.Repository
import com.e.list.data.source.local.entity.MovieEntity
import junit.framework.TestCase.assertNotNull
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner.Silent::class)
class FavoriteMovieViewModelTest{
    private lateinit var viewModel: FavoriteMovieViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var repository: Repository

    @Mock
    private lateinit var observer: Observer<PagedList<MovieEntity>>

    @Mock
    private lateinit var pageList: PagedList<MovieEntity>


    @Before
    fun setup(){
        viewModel = FavoriteMovieViewModel(repository)
    }

    @Test
    fun getData(){
        val dummy = pageList
        `when`(dummy.size).thenReturn(5)

        val movie = MutableLiveData<PagedList<MovieEntity>>()
        movie.value = dummy

        `when`(repository.getFavoriteMovie()).thenReturn(movie)
        val data = viewModel.getMovie().value
        verify(repository).getFavoriteMovie()
        assertNotNull(data)
        assertEquals(5, data?.size)

        viewModel.getMovie().observeForever(observer)
        verify(observer).onChanged(dummy)
    }
}