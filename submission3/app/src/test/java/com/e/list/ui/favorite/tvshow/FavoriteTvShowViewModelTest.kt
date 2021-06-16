package com.e.list.ui.favorite.tvshow

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import com.e.list.data.source.Repository
import com.e.list.data.source.local.entity.MovieEntity
import com.e.list.data.source.local.entity.TvShowEntity
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
class FavoriteTvShowViewModelTest{
    private lateinit var viewModel: FavoriteTvShowViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var repository: Repository

    @Mock
    private lateinit var observer: Observer<PagedList<TvShowEntity>>

    @Mock
    private lateinit var pageList: PagedList<TvShowEntity>


    @Before
    fun setup(){
        viewModel = FavoriteTvShowViewModel(repository)
    }

    @Test
    fun getData(){
        val dummy = pageList
        `when`(dummy.size).thenReturn(5)

        val tvShow = MutableLiveData<PagedList<TvShowEntity>>()
        tvShow.value = dummy

        `when`(repository.getFavoriteTvShow()).thenReturn(tvShow)
        val data = viewModel.getTvShow().value
        verify(repository).getFavoriteTvShow()
        assertNotNull(data)
        assertEquals(5, data?.size)

        viewModel.getTvShow().observeForever(observer)
        verify(observer).onChanged(dummy)
    }
}