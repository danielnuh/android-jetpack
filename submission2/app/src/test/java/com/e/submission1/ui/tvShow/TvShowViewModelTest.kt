package com.e.submission1.ui.tvShow

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.e.submission1.data.TvShowEntity
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
class TvShowViewModelTest{
    private lateinit var viewModel : TvShowViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var repository: Repository

    @Mock
    private lateinit var observer: Observer<List<TvShowEntity>>


    @Before
    fun setup(){
        viewModel = TvShowViewModel(repository)
    }

    @Test
    fun getData(){
        val dummy = DataDummy.generatedDummyTvShowEntity()
        val tvShow = MutableLiveData<List<TvShowEntity>>()
        tvShow.value = dummy

        Mockito.`when`(repository.getTvShowList(viewModel.state)).thenReturn(tvShow)
        val data = viewModel.getData().value
        Mockito.verify(repository).getTvShowList(viewModel.state)
        TestCase.assertNotNull(data)
        assertEquals(10, data?.size)

        viewModel.getData().observeForever(observer)
        Mockito.verify(observer).onChanged(dummy)
    }
}