package com.e.list.data.source.remote.api

import com.e.list.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiConfig {
    companion object{
        private fun init():Retrofit{
            val loggingInterceptor =
                HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
            val client = OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
                .build()
            val retrofit = Retrofit.Builder()
                .baseUrl(BuildConfig.API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build()

            return retrofit
        }

        fun getApiServiceMovie(): ApiServiceMovie {

            return init().create(ApiServiceMovie::class.java)
        }

        fun getApiServiceTvShow():ApiServiceTvShow{
            return init().create(ApiServiceTvShow::class.java)

        }
    }
}