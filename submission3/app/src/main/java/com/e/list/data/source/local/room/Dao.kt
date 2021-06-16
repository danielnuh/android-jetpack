package com.e.list.data.source.local.room

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import androidx.room.*
import androidx.room.Dao
import com.e.list.data.source.local.entity.MovieEntity
import com.e.list.data.source.local.entity.TvShowEntity

@Dao
interface Dao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMovie(movie:List<MovieEntity>)

    @Update
    fun updateMovie(movieEntity: MovieEntity)

    @Query("SELECT * FROM movie")
    fun getMovie():DataSource.Factory<Int, MovieEntity>

    @Query("SELECT * FROM movie WHERE id =:id")
    fun getMovie(id:String):LiveData<MovieEntity>

    @Query("SELECT * FROM movie WHERE isFavorite = 1")
    fun getFavoriteMovie():DataSource.Factory<Int, MovieEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertTvShow(tvShow: List<TvShowEntity>)

    @Update
    fun updateTvShow(tvShowEntity: TvShowEntity)

    @Query("SELECT * FROM tvshow")
    fun getTvShow(): DataSource.Factory<Int, TvShowEntity>

    @Query("SELECT * FROM tvshow WHERE id =:id")
    fun getTvShow(id: String): LiveData<TvShowEntity>

    @Query("SELECT * FROM tvshow WHERE isFavorite = 1")
    fun getFavoriteTvShow(): DataSource.Factory<Int, TvShowEntity>
}