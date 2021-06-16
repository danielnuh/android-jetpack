package com.e.list.data.source.local

import com.e.list.data.source.local.entity.MovieEntity
import com.e.list.data.source.local.entity.TvShowEntity
import com.e.list.data.source.local.room.Dao

class LocalDataSource private constructor(private val dao: Dao) {
    companion object{
        private var INSTANCE: LocalDataSource? = null

        fun getInstance(dao: Dao): LocalDataSource =
            INSTANCE ?: LocalDataSource(dao)
    }

    fun insertMovie(movie:List<MovieEntity>) = dao.insertMovie(movie)

    fun getMovie()= dao.getMovie()

    fun getMovie(id:String) = dao.getMovie(id)

    fun getFavoriteMovie() = dao.getFavoriteMovie()

    fun updateMovie(movieEntity: MovieEntity)= dao.updateMovie(movieEntity)

    fun insertTvShow(tvShow:List<TvShowEntity>) = dao.insertTvShow(tvShow)

    fun getTvShow()= dao.getTvShow()

    fun getTvShow(id:String) = dao.getTvShow(id)

    fun getFavoriteTvShow() = dao.getFavoriteTvShow()

    fun updateTvShow(tvShowEntity: TvShowEntity)= dao.updateTvShow(tvShowEntity)
}