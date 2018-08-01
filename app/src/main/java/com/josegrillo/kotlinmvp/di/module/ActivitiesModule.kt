package com.josegrillo.kotlinmvp.di.module

import com.josegrillo.kotlinmvp.view.contracts.*
import com.josegrillo.kotlinmvp.view.presenter.*
import dagger.Module
import dagger.Provides

@Module
class ActivitiesModule {

    @Provides
    fun provideSplashPresenter(): SplashContract.Presenter {
        return SplashPresenter()
    }

    @Provides
    fun provideLoginPresenter(): LoginContract.Presenter {
        return LoginPresenter()
    }

    @Provides
    fun provideRegisterPresenter(): RegisterContract.Presenter {
        return RegisterPresenter()
    }

    @Provides
    fun provideListPresenter(): ListContract.Presenter {
        return ListPresenter()
    }

    @Provides
    fun provideDetailPresenter(): DetailContract.Presenter {
        return DetailPresenter()
    }


}