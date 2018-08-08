package com.josegrillo.kotlinmvp.di.module

import com.josegrillo.kotlinmvp.data.local.interfaces.ArticleRepoInterface
import com.josegrillo.kotlinmvp.data.local.interfaces.UserRepoInterface
import com.josegrillo.kotlinmvp.data.remote.AppApi
import com.josegrillo.kotlinmvp.domain.usecase.*
import dagger.Module
import dagger.Provides

@Module
class UseCaseModule {


    @Provides
    fun provideLoginUser(appApi: AppApi): LoginUser {
        return LoginUser(appApi)
    }

    @Provides
    fun provideDeleteUser(userRepoHelper: UserRepoInterface): DeleteUser {
        return DeleteUser(userRepoHelper)
    }

    @Provides
    fun provideGetArticles(appApi: AppApi): GetArticles {
        return GetArticles(appApi)
    }

    @Provides
    fun provideGetUser(userRepoHelper: UserRepoInterface): GetUser {
        return GetUser(userRepoHelper)
    }

    @Provides
    fun provideRegisterUser(appApi: AppApi): RegisterUser {
        return RegisterUser(appApi)
    }

    @Provides
    fun loadUserInformation(userRepoHelper: UserRepoInterface): LoadUserInformation {
        return LoadUserInformation(userRepoHelper)
    }

    @Provides
    fun provideInsertUser(userRepoHelper: UserRepoInterface): InsertUser {
        return InsertUser(userRepoHelper)
    }

    @Provides
    fun provideInsertArticleSelected(articleRepoHelper: ArticleRepoInterface): InsertArticleSelected {
        return InsertArticleSelected(articleRepoHelper)
    }

    @Provides
    fun provideGetArticleSelected(articleRepoHelper: ArticleRepoInterface): GetArticleSelected {
        return GetArticleSelected(articleRepoHelper)
    }

    @Provides
    fun provideDeleteArticleSelected(articleRepoHelper: ArticleRepoInterface): DeleteArticleSelected {
        return DeleteArticleSelected(articleRepoHelper)
    }

    @Provides
    fun provideLoadArticleSelected(articleRepoHelper: ArticleRepoInterface): LoadArticleSelected {
        return LoadArticleSelected(articleRepoHelper)
    }


}