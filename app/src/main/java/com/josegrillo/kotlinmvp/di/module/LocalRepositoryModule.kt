package com.josegrillo.kotlinmvp.di.module

import android.arch.persistence.room.Room
import android.content.Context
import com.josegrillo.kotlinmvp.data.local.configuration.AppDatabase
import com.josegrillo.kotlinmvp.data.local.interfaces.ArticleRepoInterface
import com.josegrillo.kotlinmvp.data.local.interfaces.UserRepoInterface
import com.josegrillo.kotlinmvp.data.local.repository.ArticleRepo
import com.josegrillo.kotlinmvp.data.local.repository.UserRepo
import com.josegrillo.kotlinmvp.utils.AppConstants
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class LocalRepositoryModule constructor(val mApplication: Context) {

    @Provides
    @Singleton
    fun provideAppDatabase(): AppDatabase = Room.databaseBuilder(mApplication, AppDatabase::class.java, AppConstants.APP_DB_NAME).build()

    @Provides
    fun provideUserRepoHelper(appDatabase: AppDatabase): UserRepoInterface = UserRepo(appDatabase.usersDao())

    @Provides
    fun provideArticleRepoHelper(appDatabase: AppDatabase): ArticleRepoInterface = ArticleRepo(appDatabase.articlesDao())

}