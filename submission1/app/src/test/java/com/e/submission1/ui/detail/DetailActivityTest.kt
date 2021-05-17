package com.e.submission1.ui.detail

import com.e.submission1.utils.DataDummy
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Test

class DetailActivityTest{
    private var dataMovie = DataDummy.generatedDummyMovie()[0]
    private var dataTvShow = DataDummy.generatedDummyTvShow()[0]

    @Test
    fun getMovie(){
        var tempDataMovie = DataDummy.generatedDummyMovie()[0]

        assertNotNull(dataMovie)
        assertEquals(tempDataMovie.id, dataMovie.id)
        assertEquals(tempDataMovie.title, dataMovie.title)
        assertEquals(tempDataMovie.date, dataMovie.date)
        assertEquals(tempDataMovie.description, dataMovie.description)
        assertEquals(tempDataMovie.image, dataMovie.image)
    }

    @Test
    fun getTvShow(){
        var tempDataTvShow = DataDummy.generatedDummyTvShow()[0]

        assertNotNull(dataTvShow)
        assertEquals(tempDataTvShow.id, dataTvShow.id)
        assertEquals(tempDataTvShow.title, dataTvShow.title)
        assertEquals(tempDataTvShow.date, dataTvShow.date)
        assertEquals(tempDataTvShow.description, dataTvShow.description)
        assertEquals(tempDataTvShow.image, dataTvShow.image)
    }

}