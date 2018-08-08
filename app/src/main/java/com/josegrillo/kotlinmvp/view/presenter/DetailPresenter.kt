package com.josegrillo.kotlinmvp.view.presenter

import android.util.Log
import com.josegrillo.kotlinmvp.domain.model.mapper.ArticleMapper
import com.josegrillo.kotlinmvp.domain.usecase.GetArticleSelected
import com.josegrillo.kotlinmvp.domain.usecase.LoadArticleSelected
import com.josegrillo.kotlinmvp.view.contracts.DetailContract
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class DetailPresenter @Inject constructor(val loadArticleSelected: LoadArticleSelected, val subscriptions: CompositeDisposable) : DetailContract.Presenter {

    private lateinit var view: DetailContract.View
    private val LOG_TAG = "DetailPresenter"

    override fun unsubscribe() {
        subscriptions.clear()
    }

    override fun attach(view: DetailContract.View) {
        this.view = view
        this.getArticleSelected()
    }

    override fun getArticleSelected() {
        var subscribe = loadArticleSelected.loadArticleSelected()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        { usersInformation ->
                            usersInformation?.let {
                                it.forEach {
                                    this.view.setArticleInfo(ArticleMapper.articleDatabaseToViewModel(it))
                                }
                            }
                        },
                        { error ->
                            Log.e(LOG_TAG, "Error Message: " + error.message)
                        })

        subscriptions.add(subscribe)
    }

    override fun listArticles() {
        this.view.navigateToList()
    }
}