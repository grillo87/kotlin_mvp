package com.josegrillo.kotlinmvp.di.module

import com.josegrillo.kotlinmvp.domain.usecase.*
import dagger.Module
import dagger.Provides

@Module
class UseCaseModule {


    @Provides
    fun provideLoginUser(): LoginUser {
        return LoginUser()
    }

    @Provides
    fun provideDeleteUser(): DeleteUser {
        return DeleteUser()
    }

    @Provides
    fun provideGetArticles(): GetArticles {
        return GetArticles()
    }

    @Provides
    fun provideGetUser(): GetUser {
        return GetUser()
    }

    @Provides
    fun provideRegisterUser(): RegisterUser {
        return RegisterUser()
    }

    @Provides
    fun provideInsertUser(): InsertUser {
        return InsertUser()
    }

    @Provides
    fun provideInsertArticleSelected(): InsertArticleSelected {
        return InsertArticleSelected()
    }

    @Provides
    fun provideGetArticleSelected(): GetArticleSelected {
        return GetArticleSelected()
    }

    @Provides
    fun provideDeleteArticleSelected(): DeleteArticleSelected {
        return DeleteArticleSelected()
    }


}