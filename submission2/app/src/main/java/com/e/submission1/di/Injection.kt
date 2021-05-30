package com.e.submission1.di

import android.content.Context
import com.e.session3academy.data.source.remote.RemoteDataSource
import com.e.submission1.viewModel.Repository

object Injection {
    fun provideRepository(context: Context): Repository {

        val remoteDataSource = RemoteDataSource.getInstance()

        return Repository.getInstance(remoteDataSource)
    }
}