package com.e.session3academy.data.source.remote

import com.e.submission1.api.response.MovieItem
import com.e.submission1.api.response.MovieResponse
import com.e.submission1.api.response.TvShowItem
import com.e.submission1.api.response.TvShowResponse
import com.e.submission1.data.network.api.ApiConfig
import com.e.submission1.data.network.response.MovieDetailResponse
import com.e.submission1.data.network.response.TvShowDetailResponse
import com.e.submission1.utils.EspressoIdlingResource
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RemoteDataSource{

    companion object {

        @Volatile
        private var instance: RemoteDataSource? = null

        fun getInstance(): RemoteDataSource = instance ?: synchronized(this) {
            instance ?: RemoteDataSource().apply { instance = this }
        }
    }

    fun getMovieList(callback: LoadListMovieCallback){
        EspressoIdlingResource.increment()

        ApiConfig.getApiService().getMovie().enqueue(object : Callback<MovieResponse>{
            override fun onResponse(call: Call<MovieResponse>, response: Response<MovieResponse>) {
                if (response.isSuccessful){
                    callback.onResult(response.body()!!.results)
                }else{
                    callback.onFailure("")
                }
                EspressoIdlingResource.decrement()
            }

            override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
                callback.onFailure("")
                EspressoIdlingResource.decrement()
            }

        })
    }

    fun getTvShowList(callback: LoadListTvShowCallback){
        EspressoIdlingResource.increment()

        ApiConfig.getApiService().getTvShow().enqueue(object :Callback<TvShowResponse>{
            override fun onResponse(
                call: Call<TvShowResponse>,
                response: Response<TvShowResponse>
            ) {
                if (response.isSuccessful){
                    callback.onResult(response.body()!!.results)
                }else{
                    callback.onFailure("")
                }
                EspressoIdlingResource.decrement()
            }

            override fun onFailure(call: Call<TvShowResponse>, t: Throwable) {
                callback.onFailure("")
                EspressoIdlingResource.decrement()
            }

        })
    }

    fun getMovieDetail(id:Int,callback: LoadDetailMovieCallback){
        EspressoIdlingResource.increment()

        ApiConfig.getApiService().getDetailMovie(id).enqueue(object : Callback<MovieDetailResponse>{
            override fun onResponse(
                call: Call<MovieDetailResponse>,
                response: Response<MovieDetailResponse>
            ) {
                if (response.isSuccessful){
                    response.body()?.let { callback.onResult(it) }
                }else{
                    callback.onFailure("")
                }
                EspressoIdlingResource.decrement()
            }

            override fun onFailure(call: Call<MovieDetailResponse>, t: Throwable) {
                callback.onFailure("")
                EspressoIdlingResource.decrement()
            }

        })
    }

    fun getTvShowDetail(id: Int, callback: LoadDetailTvShowCallback){
        EspressoIdlingResource.increment()

        ApiConfig.getApiService().getDetailTvShow(id).enqueue(object :Callback<TvShowDetailResponse>{
            override fun onResponse(
                call: Call<TvShowDetailResponse>,
                response: Response<TvShowDetailResponse>
            ) {
                if (response.isSuccessful){
                    response.body()?.let { callback.onResult(it) }
                }else{
                    callback.onFailure("")
                }
                EspressoIdlingResource.decrement()
            }

            override fun onFailure(call: Call<TvShowDetailResponse>, t: Throwable) {
                callback.onFailure("")
                EspressoIdlingResource.decrement()
            }

        })
    }

    interface LoadListMovieCallback{
        fun onResult(movieResponse: List<MovieItem>)
        fun onFailure(string :String)
    }

    interface LoadDetailMovieCallback{
        fun onResult(movieDetailResponse: MovieDetailResponse)
        fun onFailure(string :String)
    }

    interface LoadListTvShowCallback{
        fun onResult(tvShowResponse: List<TvShowItem>)
        fun onFailure(string :String)
    }

    interface LoadDetailTvShowCallback{
        fun onResult(tvShowDetailResponse: TvShowDetailResponse)
        fun onFailure(string :String)
    }
}