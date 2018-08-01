package com.josegrillo.kotlinmvp.view.presenter

import com.josegrillo.kotlinmvp.view.contracts.ListContract

class ListPresenter : ListContract.Presenter {

    private lateinit var view: ListContract.View

    override fun subscribe() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun unsubscribe() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun attach(view: ListContract.View) {
        this.view = view
    }
}