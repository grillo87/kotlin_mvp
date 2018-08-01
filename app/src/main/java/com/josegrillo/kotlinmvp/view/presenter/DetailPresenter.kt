package com.josegrillo.kotlinmvp.view.presenter

import com.josegrillo.kotlinmvp.view.contracts.DetailContract

class DetailPresenter : DetailContract.Presenter {

    private lateinit var view: DetailContract.View

    override fun subscribe() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun unsubscribe() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun attach(view: DetailContract.View) {
        this.view = view
    }
}