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

interface ApiServiceTvShow {

    @GET("tv/popular")
    fun getTvShow(
        @Query("api_key")token:String = BuildConfig.API_KEY,
        @Query("page")page:Int = 1
    ):Call<TvShowResponse>

    @GET("tv/{id}")
    fun getDetailTvShow(
        @Path("id") id: Int,
        @Query("api_key")token:String = BuildConfig.API_KEY,
    ):Call<TvShowDetailResponse>
}