package com.e.session3academy.di

import android.content.Context
import com.e.session3academy.viewModel.AcademyRepository
import com.e.session3academy.data.source.remote.RemoteDataSource
import com.e.session3academy.utils.JsonHelper

object Injection {
    fun provideRepository(context: Context): AcademyRepository {

        val remoteDataSource = RemoteDataSource.getInstance(JsonHelper(context))

        return AcademyRepository.getInstance(remoteDataSource)
    }
}