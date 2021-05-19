package com.e.submission1.ui.detail

import com.e.submission1.utils.DataDummy
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class DetailViewModelTest{
    private lateinit var viewModel: DetailViewModel
    private var dummyMovie = DataDummy.generatedDummyMovie()[0]
    private var dummyTvShow = DataDummy.generatedDummyTvShow()[0]

    @Before
    fun setUp(){
        viewModel = DetailViewModel()
        viewModel.setMovie(dummyMovie)
        viewModel.setTvShow(dummyTvShow)
    }

    @Test
    fun getMovie(){
        val movieEntity = viewModel.getMovie()
        val dataMovie = DataDummy.generatedDummyMovie()[0]
        Assert.assertNotNull(movieEntity)

        Assert.assertNotNull(movieEntity)
        Assert.assertEquals(movieEntity.id, dataMovie.id)
        Assert.assertEquals(movieEntity.title, dataMovie.title)
        Assert.assertEquals(movieEntity.date, dataMovie.date)
        Assert.assertEquals(movieEntity.description, dataMovie.description)
        Assert.assertEquals(movieEntity.image, dataMovie.image)
    }

    @Test
    fun getTvShow(){
        val tvShowEntity = viewModel.getTvShow()
        val dataTvShow = DataDummy.generatedDummyTvShow()[0]
        Assert.assertNotNull(tvShowEntity)

        Assert.assertNotNull(tvShowEntity)
        Assert.assertEquals(tvShowEntity.id, dataTvShow.id)
        Assert.assertEquals(tvShowEntity.title, dataTvShow.title)
        Assert.assertEquals(tvShowEntity.date, dataTvShow.date)
        Assert.assertEquals(tvShowEntity.description, dataTvShow.description)
        Assert.assertEquals(tvShowEntity.image, dataTvShow.image)
    }
}