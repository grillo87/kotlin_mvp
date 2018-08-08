package com.josegrillo.kotlinmvp.di.module

import com.josegrillo.kotlinmvp.domain.usecase.*
import com.josegrillo.kotlinmvp.view.contracts.*
import com.josegrillo.kotlinmvp.view.presenter.*
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable

@Module
class ActivitiesModule {

    @Provides
    fun provideSubscription(): CompositeDisposable = CompositeDisposable()

    @Provides
    fun provideSplashPresenter(getUser: GetUser, subscriptions: CompositeDisposable): SplashContract.Presenter {
        return SplashPresenter(getUser, subscriptions)
    }

    @Provides
    fun provideLoginPresenter(loginUser: LoginUser, insertUser: InsertUser, subscriptions: CompositeDisposable): LoginContract.Presenter {
        return LoginPresenter(loginUser, insertUser, subscriptions)
    }

    @Provides
    fun provideRegisterPresenter(registerUser: RegisterUser, insertUser: InsertUser, subscriptions: CompositeDisposable): RegisterContract.Presenter {
        return RegisterPresenter(registerUser, insertUser, subscriptions)
    }

    @Provides
    fun provideListPresenter(getArticles: GetArticles, getArticleSelected: GetArticleSelected, insertArticleSelected: InsertArticleSelected, deleteArticleSelected: DeleteArticleSelected, loadUserInformation: LoadUserInformation, deleteUser: DeleteUser, subscriptions: CompositeDisposable): ListContract.Presenter {
        return ListPresenter(getArticles, getArticleSelected, insertArticleSelected, deleteArticleSelected, loadUserInformation, deleteUser, subscriptions)
    }

    @Provides
    fun provideDetailPresenter(loadArticleSelected: LoadArticleSelected, loadUserInformation: LoadUserInformation, deleteUser: DeleteUser, subscriptions: CompositeDisposable): DetailContract.Presenter {
        return DetailPresenter(loadArticleSelected, loadUserInformation, deleteUser, subscriptions)
    }


}