package com.josegrillo.kotlinmvp.di.module

import com.josegrillo.kotlinmvp.domain.usecase.*
import com.josegrillo.kotlinmvp.view.contracts.*
import com.josegrillo.kotlinmvp.view.presenter.*
import dagger.Module
import dagger.Provides

@Module
class ActivitiesModule {

    @Provides
    fun provideSplashPresenter(getUser: GetUser, deleteArticleSelected: DeleteArticleSelected): SplashContract.Presenter {
        return SplashPresenter(getUser, deleteArticleSelected)
    }

    @Provides
    fun provideLoginPresenter(loginUser: LoginUser, insertUser: InsertUser): LoginContract.Presenter {
        return LoginPresenter(loginUser, insertUser)
    }

    @Provides
    fun provideRegisterPresenter(registerUser: RegisterUser, insertUser: InsertUser): RegisterContract.Presenter {
        return RegisterPresenter(registerUser, insertUser)
    }

    @Provides
    fun provideListPresenter(getArticles: GetArticles, insertArticleSelected: InsertArticleSelected, deleteArticleSelected: DeleteArticleSelected): ListContract.Presenter {
        return ListPresenter(getArticles, insertArticleSelected, deleteArticleSelected)
    }

    @Provides
    fun provideDetailPresenter(getArticleSelected: GetArticleSelected): DetailContract.Presenter {
        return DetailPresenter(getArticleSelected)
    }


}