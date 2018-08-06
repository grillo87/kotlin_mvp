package com.josegrillo.kotlinmvp.di.module

import com.josegrillo.kotlinmvp.data.local.interfaces.ArticleRepoInterface
import com.josegrillo.kotlinmvp.data.local.interfaces.UserRepoInterface
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
    fun provideDeleteUser(userRepoHelper: UserRepoInterface): DeleteUser {
        return DeleteUser(userRepoHelper)
    }

    @Provides
    fun provideGetArticles(): GetArticles {
        return GetArticles()
    }

    @Provides
    fun provideGetUser(userRepoHelper: UserRepoInterface): GetUser {
        return GetUser(userRepoHelper)
    }

    @Provides
    fun provideRegisterUser(): RegisterUser {
        return RegisterUser()
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


}