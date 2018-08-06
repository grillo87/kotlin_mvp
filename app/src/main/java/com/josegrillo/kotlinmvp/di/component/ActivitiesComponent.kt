package com.josegrillo.kotlinmvp.di.component

import com.josegrillo.kotlinmvp.di.module.*
import com.josegrillo.kotlinmvp.view.ui.*
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(ActivitiesModule::class, UseCaseModule::class, LocalRepositoryModule::class, RemoteRepositoryModule::class))
interface ActivitiesComponent {

    fun inject(splashActivity: SplashActivity)

    fun inject(loginActivity: LoginActivity)

    fun inject(registerActivity: RegisterActivity)

    fun inject(listActivity: ListActivity)

    fun inject(detailActivity: DetailActivity)


}