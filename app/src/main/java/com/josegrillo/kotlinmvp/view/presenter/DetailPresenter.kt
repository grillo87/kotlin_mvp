package com.josegrillo.kotlinmvp.view.presenter

import com.josegrillo.kotlinmvp.domain.usecase.GetArticleSelected
import com.josegrillo.kotlinmvp.view.contracts.DetailContract
import javax.inject.Inject

class DetailPresenter @Inject constructor(val getArticleSelected: GetArticleSelected) : DetailContract.Presenter {

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

    override fun getArticleSelected() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun listArticles() {
        this.view.navigateToList()
    }
}