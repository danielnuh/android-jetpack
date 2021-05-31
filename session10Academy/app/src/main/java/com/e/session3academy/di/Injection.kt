package com.e.session3academy.di

import android.content.Context
import com.e.session3academy.data.source.AcademyRepository
import com.e.session3academy.data.source.local.LocalDataSource
import com.e.session3academy.data.source.local.room.AcademyDatabase
import com.e.session3academy.data.source.remote.RemoteDataSource
import com.e.session3academy.utils.AppExecutors
import com.e.session3academy.utils.JsonHelper

object Injection {
    fun provideRepository(context: Context): AcademyRepository {

        val database = AcademyDatabase.getInstance(context)

        val remoteDataSource = RemoteDataSource.getInstance(JsonHelper(context))
        val localDataSource = LocalDataSource.getInstance(database.academyDao())
        val appExecutors = AppExecutors()

        return AcademyRepository.getInstance(remoteDataSource, localDataSource, appExecutors)
    }
}