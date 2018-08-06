package com.josegrillo.kotlinmvp.di.module

import com.josegrillo.kotlinmvp.data.remote.AppApi
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RemoteRepositoryModule {

    @Provides
    @Singleton
    fun provideAppApi(): AppApi = AppApi.create()

}