package com.e.list.ui.tvshow

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import com.e.list.data.source.Repository
import com.e.list.data.source.local.entity.TvShowEntity
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
class TvShowViewModelTest{
    private lateinit var viewModel : TvShowViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var repository: Repository

    @Mock
    private lateinit var observer: Observer<Resource<PagedList<TvShowEntity>>>

    @Mock
    private lateinit var pageList: PagedList<TvShowEntity>


    @Before
    fun setup(){
        viewModel = TvShowViewModel(repository)
    }

    @Test
    fun getData(){
        val dummy = Resource.success(pageList)
        Mockito.`when`(dummy.data?.size).thenReturn(5)

        val tvShow = MutableLiveData<Resource<PagedList<TvShowEntity>>>()
        tvShow.value = dummy

        Mockito.`when`(repository.getTvShowList()).thenReturn(tvShow)

        val entities = viewModel.getTvShow().value?.data
        Mockito.verify(repository).getTvShowList()
        Assert.assertNotNull(entities)
        TestCase.assertEquals(5, entities?.size)

        viewModel.getTvShow().observeForever(observer)
        Mockito.verify(observer).onChanged(dummy)
    }

}