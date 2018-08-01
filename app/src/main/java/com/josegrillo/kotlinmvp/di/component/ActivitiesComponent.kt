package com.josegrillo.kotlinmvp.di.component

import com.josegrillo.kotlinmvp.di.module.ActivitiesModule
import com.josegrillo.kotlinmvp.view.ui.*
import dagger.Component

@Component(modules = arrayOf(ActivitiesModule::class))
interface ActivitiesComponent {

    fun inject(splashActivity: SplashActivity)

    fun inject(loginActivity: LoginActivity)

    fun inject(registerActivity: RegisterActivity)

    fun inject(listActivity: ListActivity)

    fun inject(detailActivity: DetailActivity)


}