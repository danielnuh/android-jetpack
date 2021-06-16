package com.e.list.di

import android.content.Context
import com.e.list.data.source.Repository
import com.e.list.data.source.local.LocalDataSource
import com.e.list.data.source.local.room.CatalogDatabase
import com.e.list.data.source.remote.RemoteDataSource
import com.e.list.utils.AppExecutors

object Injection {
    fun provideRepository(context: Context): Repository {

        val database = CatalogDatabase.getInstance(context)

        val remoteDataSource = RemoteDataSource.getInstance()
        val localDataSource = LocalDataSource.getInstance(database.dao())
        val appExecutors = AppExecutors()

        return Repository.getInstance(remoteDataSource, localDataSource, appExecutors)
    }
}