package com.e.submission1.data.network.api

import com.e.submission1.BuildConfig
import com.e.submission1.api.response.MovieResponse
import com.e.submission1.api.response.TvShowResponse
import com.e.submission1.data.network.response.MovieDetailResponse
import com.e.submission1.data.network.response.TvShowDetailResponse
import retrofit2.Call
import retrofit2.http.*

interface ApiService {
    @GET("movie/popular")
    fun getMovie(
        @Query("api_key")token:String = BuildConfig.API_KEY,
        @Query("page")page:Int = 1
    ):Call<MovieResponse>

    @GET("tv/popular")
    fun getTvShow(
        @Query("api_key")token:String = BuildConfig.API_KEY,
        @Query("page")page:Int = 1
    ):Call<TvShowResponse>

    @GET("movie/{id}")
    fun getDetailMovie(
        @Path("id") id: Int,
        @Query("api_key")token:String = BuildConfig.API_KEY,
    ):Call<MovieDetailResponse>

    @GET("tv/{id}")
    fun getDetailTvShow(
        @Path("id") id: Int,
        @Query("api_key")token:String = BuildConfig.API_KEY,
    ):Call<TvShowDetailResponse>
}