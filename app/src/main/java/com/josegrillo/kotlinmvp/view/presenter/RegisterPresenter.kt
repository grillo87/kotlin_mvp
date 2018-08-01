package com.josegrillo.kotlinmvp.view.presenter

import com.josegrillo.kotlinmvp.view.contracts.RegisterContract

class RegisterPresenter : RegisterContract.Presenter {

    private lateinit var view: RegisterContract.View

    override fun unsubscribe() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun attach(view: RegisterContract.View) {
        this.view = view
    }

    override fun subscribe() {
    }
}