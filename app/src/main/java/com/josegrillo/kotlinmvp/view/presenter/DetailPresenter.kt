package com.josegrillo.kotlinmvp.view.presenter

import com.josegrillo.kotlinmvp.domain.usecase.GetArticleSelected
import com.josegrillo.kotlinmvp.view.contracts.DetailContract
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class DetailPresenter @Inject constructor(val getArticleSelected: GetArticleSelected, val subscriptions :CompositeDisposable) : DetailContract.Presenter {

    private lateinit var view: DetailContract.View
    private val LOG_TAG = "DetailPresenter"

    override fun unsubscribe() {
        subscriptions.clear()
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