package com.e.list.data.source.remote.api

import com.e.list.BuildConfig
import com.e.list.data.source.remote.response.MovieDetailResponse
import com.e.list.data.source.remote.response.MovieResponse
import com.e.list.data.source.remote.response.TvShowDetailResponse
import com.e.list.data.source.remote.response.TvShowResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiServiceMovie {
    @GET("movie/popular")
    fun getMovie(
        @Query("api_key")token:String = BuildConfig.API_KEY,
        @Query("page")page:Int = 1
    ):Call<MovieResponse>

    @GET("movie/{id}")
    fun getDetailMovie(
        @Path("id") id: Int,
        @Query("api_key")token:String = BuildConfig.API_KEY,
    ):Call<MovieDetailResponse>
}