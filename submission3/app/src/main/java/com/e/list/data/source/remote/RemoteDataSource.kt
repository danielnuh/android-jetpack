package com.e.list.data.source.remote

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.e.list.data.source.remote.api.ApiConfig
import com.e.list.data.source.remote.api.ApiResponse
import com.e.list.data.source.remote.response.*
import com.e.list.utils.EspressoIdlingResource
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RemoteDataSource {

    companion object {

        @Volatile
        private var instance: RemoteDataSource? = null

        fun getInstance(): RemoteDataSource = instance ?: synchronized(this) {
            instance ?: RemoteDataSource().apply { instance = this }
        }
    }

    fun getMovieList(): LiveData<ApiResponse<List<MovieItem>>> {
        EspressoIdlingResource.increment()
        val result = MutableLiveData<ApiResponse<List<MovieItem>>>()

        ApiConfig.getApiServiceMovie().getMovie().enqueue(object : Callback<MovieResponse> {
            override fun onResponse(call: Call<MovieResponse>, response: Response<MovieResponse>) {
                if (response.isSuccessful) {
                    result.value = ApiResponse.success(response.body()!!.results)

                } else {
                    result.value = ApiResponse.error("", mutableListOf())
                }
                EspressoIdlingResource.decrement()
            }

            override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
                EspressoIdlingResource.decrement()
                result.value = ApiResponse.error("", mutableListOf())

            }

        })

        return result
    }

    fun getMovieDetail(id: Int): LiveData<ApiResponse<MovieDetailResponse>> {
        EspressoIdlingResource.increment()
        val result = MutableLiveData<ApiResponse<MovieDetailResponse>>()

        ApiConfig.getApiServiceMovie().getDetailMovie(id).enqueue(object :Callback<MovieDetailResponse>{
            override fun onResponse(
                call: Call<MovieDetailResponse>,
                response: Response<MovieDetailResponse>
            ) {
                if (response.isSuccessful) {
                    result.value = ApiResponse.success(response.body()!!)

                } else {
                    result.value = ApiResponse.error("", MovieDetailResponse())

                }
                EspressoIdlingResource.decrement()
            }

            override fun onFailure(call: Call<MovieDetailResponse>, t: Throwable) {
                result.value = ApiResponse.error("",MovieDetailResponse())
                EspressoIdlingResource.decrement()
            }

        })

        return result
    }

    fun getTvSowList(): LiveData<ApiResponse<List<TvShowItem>>> {
        EspressoIdlingResource.increment()
        val result = MutableLiveData<ApiResponse<List<TvShowItem>>>()

        ApiConfig.getApiServiceTvShow().getTvShow().enqueue(object : Callback<TvShowResponse> {
            override fun onResponse(call: Call<TvShowResponse>, response: Response<TvShowResponse>) {
                if (response.isSuccessful) {
                    result.value = ApiResponse.success(response.body()!!.results)

                } else {
                    result.value = ApiResponse.error("", mutableListOf())
                }
                EspressoIdlingResource.decrement()
            }

            override fun onFailure(call: Call<TvShowResponse>, t: Throwable) {
                EspressoIdlingResource.decrement()
                result.value = ApiResponse.error("", mutableListOf())

            }

        })

        return result
    }

    fun getTvShowDetail(id: Int): LiveData<ApiResponse<TvShowDetailResponse>> {
        EspressoIdlingResource.increment()
        val result = MutableLiveData<ApiResponse<TvShowDetailResponse>>()

        ApiConfig.getApiServiceTvShow().getDetailTvShow(id).enqueue(object :Callback<TvShowDetailResponse>{
            override fun onResponse(
                call: Call<TvShowDetailResponse>,
                response: Response<TvShowDetailResponse>
            ) {
                if (response.isSuccessful) {
                    result.value = ApiResponse.success(response.body()!!)

                } else {
                    result.value = ApiResponse.error("", TvShowDetailResponse())

                }
                EspressoIdlingResource.decrement()
            }

            override fun onFailure(call: Call<TvShowDetailResponse>, t: Throwable) {
                result.value = ApiResponse.error("", TvShowDetailResponse())
                EspressoIdlingResource.decrement()
            }

        })

        return result
    }
}