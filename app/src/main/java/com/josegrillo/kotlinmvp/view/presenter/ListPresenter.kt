package com.josegrillo.kotlinmvp.view.presenter

import com.josegrillo.kotlinmvp.domain.model.ArticleView
import com.josegrillo.kotlinmvp.domain.usecase.DeleteArticleSelected
import com.josegrillo.kotlinmvp.domain.usecase.GetArticles
import com.josegrillo.kotlinmvp.domain.usecase.InsertArticleSelected
import com.josegrillo.kotlinmvp.view.contracts.ListContract
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class ListPresenter @Inject constructor(val getArticles: GetArticles, val insertArticleSelected: InsertArticleSelected, val deleteArticleSelected: DeleteArticleSelected, val subscriptions :CompositeDisposable) : ListContract.Presenter {

    private lateinit var view: ListContract.View
    private val LOG_TAG = "ListPresenter"

    override fun unsubscribe() {
        subscriptions.clear()
    }

    override fun attach(view: ListContract.View) {
        this.view = view
    }

    override fun loadArticles() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun setArticleSelected(article: ArticleView) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun insertArticleSelected(article: ArticleView) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun deleteArticlesSelected() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}