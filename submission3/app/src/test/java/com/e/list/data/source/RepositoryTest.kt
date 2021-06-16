package com.e.list.data.source

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.e.list.data.source.local.LocalDataSource
import com.e.list.data.source.local.entity.MovieEntity
import com.e.list.data.source.local.entity.TvShowEntity
import com.e.list.data.source.remote.RemoteDataSource
import com.e.list.utils.AppExecutors
import com.e.list.utils.DataDummy
import com.e.list.vo.Resource
import com.nhaarman.mockitokotlin2.verify
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock

class RepositoryTest{
    @get:Rule

    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private val remote = mock(RemoteDataSource::class.java)
    private val local = mock(LocalDataSource::class.java)
    private val appExecutors = mock(AppExecutors::class.java)

    private val repository = RepositoryFake(remote, local, appExecutors)

    private val movieResponse = DataDummy.generatedDummyMovie()
    private val tvShowResponse = DataDummy.generatedDummyTvShow()

    private val movieId = DataDummy.generatedDummyMovieEntity()[0].id
    private val tvShowId = DataDummy.generatedDummyTvShowEntity()[0].id

    @Test
    fun getAllMovie(){
        val dataSourceFactory = mock(DataSource.Factory::class.java) as DataSource.Factory<Int, MovieEntity>
        `when`(local.getMovie()).thenReturn(dataSourceFactory)
        repository.getMovieList()

        val movieEntity = Resource.success(PagedListUtil.mockPagedList(DataDummy.generatedDummyMovie()))
        verify(local).getMovie()
        assertNotNull(movieEntity.data)
        assertEquals(movieResponse.size.toLong(), movieEntity.data?.size?.toLong())
    }

    @Test
    fun getAllTvShow(){
        val dataSourceFactory = mock(DataSource.Factory::class.java) as DataSource.Factory<Int, TvShowEntity>
        `when`(local.getTvShow()).thenReturn(dataSourceFactory)
        repository.getTvShowList()

        val tvShowEntity = Resource.success(PagedListUtil.mockPagedList(DataDummy.generatedDummyTvShow()))
        verify(local).getTvShow()
        assertNotNull(tvShowEntity.data)
        assertEquals(tvShowResponse.size.toLong(), tvShowEntity.data?.size?.toLong())
    }

    @Test
    fun getAllFavMovie(){
        val dataSourceFactory = mock(DataSource.Factory::class.java) as DataSource.Factory<Int, MovieEntity>
        `when`(local.getFavoriteMovie()).thenReturn(dataSourceFactory)
        repository.getFavoriteMovie()

        val movieEntity = Resource.success(PagedListUtil.mockPagedList(DataDummy.generatedDummyMovie()))
        verify(local).getFavoriteMovie()
        assertNotNull(movieEntity.data)
        assertEquals(movieResponse.size.toLong(), movieEntity.data?.size?.toLong())
    }

    @Test
    fun getAllFavTvShow(){
        val dataSourceFactory = mock(DataSource.Factory::class.java) as DataSource.Factory<Int, TvShowEntity>
        `when`(local.getFavoriteTvShow()).thenReturn(dataSourceFactory)
        repository.getFavoriteTvShow()

        val tvShowEntity = Resource.success(PagedListUtil.mockPagedList(DataDummy.generatedDummyTvShow()))
        verify(local).getFavoriteTvShow()
        assertNotNull(tvShowEntity.data)
        assertEquals(tvShowResponse.size.toLong(), tvShowEntity.data?.size?.toLong())
    }

    @Test
    fun getDetailMovie(){
        val dummy = MutableLiveData<MovieEntity>()
        dummy.value = DataDummy.generatedDummyMovieEntity()[0]

        `when`(local.getMovie(movieId)).thenReturn(dummy)

        val temp = LiveDataTestUtil.getValue(repository.getDetailMovie(movieId))

        verify(local).getMovie(movieId)
        assertNotNull(temp.data)
    }

    @Test
    fun getDetailTvShow(){
        val dummy = MutableLiveData<TvShowEntity>()
        dummy.value = DataDummy.generatedDummyTvShowEntity()[0]

        `when`(local.getTvShow(tvShowId)).thenReturn(dummy)

        val temp = LiveDataTestUtil.getValue(repository.getDetailTvShow(tvShowId))

        verify(local).getTvShow(tvShowId)
        assertNotNull(temp.data)
    }
}