package com.josegrillo.kotlinmvp.view.presenter

import android.util.Log
import com.josegrillo.kotlinmvp.domain.usecase.DeleteArticleSelected
import com.josegrillo.kotlinmvp.domain.usecase.GetArticleSelected
import com.josegrillo.kotlinmvp.domain.usecase.GetUser
import com.josegrillo.kotlinmvp.view.contracts.SplashContract
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class SplashPresenter @Inject constructor(val getUser: GetUser, val getArticleSelected: GetArticleSelected, val deleteArticleSelected: DeleteArticleSelected) : SplashContract.Presenter {

    private lateinit var view: SplashContract.View
    private val LOG_TAG = "SplashPresenter"


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

        getUser.isUserLoggin().subscribeOn(Schedulers.io())
                .subscribe(
                        { isEmpty ->
                            navigateNextView(isEmpty)
                        },
                        { error ->
                            Log.e(LOG_TAG, "Error Message: " + error.message)
                        }
                )

    }

    override fun deleteArticlesSelected() {
        deleteArticleSelected.deleteArticlesRepo().subscribeOn(Schedulers.io())
                .subscribe(
                        { _ ->
                            checkUserSession()
                        },
                        { error ->
                            Log.e(LOG_TAG, "Error Message: " + error.message)
                        }
                )
    }

    override fun checkArticleSelected() {
        getArticleSelected.isArticleRepoEmpty().subscribeOn(Schedulers.io())
                .subscribe(
                        { articleRepoEmpty ->
                            if (!articleRepoEmpty) {
                                deleteArticlesSelected()
                            } else {
                                checkUserSession()
                            }

                        },
                        { error ->
                            Log.e(LOG_TAG, "Error Message: " + error.message)
                        }
                )
    }

    override fun navigateNextView(isEmpty: Boolean) {
        if (isEmpty) {
            this.view.navigateToLogin()
        } else {
            this.view.navigateToList()
        }
    }


}