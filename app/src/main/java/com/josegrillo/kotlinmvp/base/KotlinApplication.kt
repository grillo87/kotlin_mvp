package com.josegrillo.kotlinmvp.base

import android.app.Application
import com.josegrillo.kotlinmvp.di.component.AppComponent
import com.josegrillo.kotlinmvp.di.component.DaggerAppComponent
import com.josegrillo.kotlinmvp.di.module.AppModule


class KotlinApplication : Application() {


    val component: AppComponent by lazy {
        DaggerAppComponent
                .builder()
                .appModule(AppModule(this))
                .build()
    }

    override fun onCreate() {
        super.onCreate()
        component.inject(this)
    }

}