package com.josegrillo.kotlinmvp.view.presenter

import com.josegrillo.kotlinmvp.domain.usecase.DeleteArticleSelected
import com.josegrillo.kotlinmvp.domain.usecase.GetUser
import com.josegrillo.kotlinmvp.view.contracts.SplashContract
import javax.inject.Inject

class SplashPresenter @Inject constructor(val getUser: GetUser, val deleteArticleSelected: DeleteArticleSelected) : SplashContract.Presenter {

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

    override fun checkUserSession() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun deleteArticlesSelected() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


}