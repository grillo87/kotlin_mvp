package com.josegrillo.kotlinmvp.di.module

import com.josegrillo.kotlinmvp.base.KotlinApplication
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(val app: KotlinApplication) {

    @Provides
    @Singleton
    fun provideApp() = app

}