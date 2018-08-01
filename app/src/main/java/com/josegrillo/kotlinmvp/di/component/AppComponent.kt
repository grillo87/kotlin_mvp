package com.josegrillo.kotlinmvp.di.component

import com.josegrillo.kotlinmvp.base.KotlinApplication
import com.josegrillo.kotlinmvp.di.module.*
import com.josegrillo.kotlinmvp.view.ui.*
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(AppModule::class))
interface AppComponent {

    fun inject(app: KotlinApplication)


}