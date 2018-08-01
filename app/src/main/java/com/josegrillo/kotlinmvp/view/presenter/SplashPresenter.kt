package com.josegrillo.kotlinmvp.view.presenter

import com.josegrillo.kotlinmvp.view.contracts.SplashContract

class SplashPresenter : SplashContract.Presenter {

    private lateinit var view: SplashContract.View


    override fun initializeViewElements() {
        this.view.defineAnimations()
        this.view.startAnimations()
        this.view.startSplashTimer()
    }

    override fun subscribe() {
    }

    override fun unsubscribe() {
    }

    override fun attach(view: SplashContract.View) {
        this.view = view
        initializeViewElements()
    }


}