package com.e.submission1.viewModel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.e.session3academy.data.source.remote.RemoteDataSource
import com.e.submission1.data.network.response.MovieDetailResponse
import com.e.submission1.data.network.response.TvShowDetailResponse
import com.e.submission1.ui.detail.DetailViewModel
import com.e.submission1.ui.movie.MovieViewModel
import com.e.submission1.ui.tvShow.TvShowViewModel
import com.e.submission1.utils.DataDummy
import com.e.submission1.utils.LiveDataTestUtil
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.doAnswer
import com.nhaarman.mockitokotlin2.eq
import com.nhaarman.mockitokotlin2.verify
import org.junit.Assert
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.mock
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class RepositoryTest{
    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private val remote = mock(RemoteDataSource::class.java)
    private val repository = FakeRepository(remote)

    private val listMovieResponse = DataDummy.generatedDummyMovie()
    private val listTvShowResponse = DataDummy.generatedDummyTvShow()

    private lateinit var movieDetail : MovieDetailResponse
    private lateinit var tvShowDetail : TvShowDetailResponse

    private lateinit var movieViewModel: MovieViewModel
    private lateinit var tvShowViewModel: TvShowViewModel
    private lateinit var detailViewModel: DetailViewModel

    @Mock
    private lateinit var realRepository: Repository


    @Before
    fun setUp() {
        movieViewModel = MovieViewModel(realRepository)
        tvShowViewModel = TvShowViewModel(realRepository)
        detailViewModel = DetailViewModel(realRepository)

        var tempMovie = DataDummy.generatedDummyMovie()[0]
        var tempTvShow = DataDummy.generatedDummyTvShow()[0]

        movieDetail = MovieDetailResponse(
            tempMovie.id,
            tempMovie.title,
            tempMovie.overview,
            tempMovie.releaseDate,
            tempMovie.posterPath
        )

        tvShowDetail = TvShowDetailResponse(
            tempTvShow.id,
            tempTvShow.name,
            tempTvShow.overview,
            tempTvShow.firstAirDate,
            tempTvShow.posterPath,
        )
    }

    @Test
    fun getMovieList(){
        doAnswer { invocation->
            (invocation.arguments[0] as RemoteDataSource.LoadListMovieCallback).onResult(listMovieResponse)
            null
        }.`when`(remote).getMovieList(any())

        val movieList = LiveDataTestUtil.getValue(repository.getMovieList(movieViewModel.state))
        verify(remote).getMovieList(any())
        Assert.assertNotNull(movieList)
        assertEquals(movieList.size.toLong(), movieList.size.toLong())
    }

    @Test
    fun getTvShowList(){
        doAnswer { invocation->
            (invocation.arguments[0] as RemoteDataSource.LoadListTvShowCallback).onResult(listTvShowResponse)
            null
        }.`when`(remote).getTvShowList(any())

        val tvshowList = LiveDataTestUtil.getValue(repository.getTvShowList(tvShowViewModel.state))
        verify(remote).getTvShowList(any())
        Assert.assertNotNull(tvshowList)
        assertEquals(tvshowList.size.toLong(), tvshowList.size.toLong())
    }

    @Test
    fun getDetailMovie(){
        doAnswer { invocation->
            (invocation.arguments[1] as RemoteDataSource.LoadDetailMovieCallback).onResult(movieDetail)
            null
        }.`when`(remote).getMovieDetail(eq(movieDetail.id),any())

        val movie = LiveDataTestUtil.getValue(repository.getDetailMovie(movieDetail.id.toString(),detailViewModel.state))
        verify(remote).getMovieDetail(eq(movieDetail.id),any())

        Assert.assertNotNull(movie)
    }

    @Test
    fun getDetailTvShow(){
        doAnswer { invocation->
            (invocation.arguments[1] as RemoteDataSource.LoadDetailTvShowCallback).onResult(tvShowDetail)
            null
        }.`when`(remote).getTvShowDetail(eq(tvShowDetail.id),any())
        val tvShow = LiveDataTestUtil.getValue(repository.getDetailTvShow(tvShowDetail.id.toString(),detailViewModel.state))
        verify(remote).getTvShowDetail(eq(tvShowDetail.id),any())

        Assert.assertNotNull(tvShow)
    }
}