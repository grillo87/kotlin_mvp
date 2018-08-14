package com.josegrillo.kotlinmvp.view.presenter

import android.util.Log
import com.josegrillo.kotlinmvp.domain.model.database.User
import com.josegrillo.kotlinmvp.domain.model.mapper.ArticleMapper
import com.josegrillo.kotlinmvp.domain.usecase.DeleteUser
import com.josegrillo.kotlinmvp.domain.usecase.GetArticleSelected
import com.josegrillo.kotlinmvp.domain.usecase.LoadArticleSelected
import com.josegrillo.kotlinmvp.domain.usecase.LoadUserInformation
import com.josegrillo.kotlinmvp.view.contracts.DetailContract
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class DetailPresenter @Inject constructor(val loadArticleSelected: LoadArticleSelected, val userInformation: LoadUserInformation, val deleteUser: DeleteUser, val subscriptions: CompositeDisposable) : DetailContract.Presenter {

    private lateinit var view: DetailContract.View
    private lateinit var userInfo: User
    private val LOG_TAG = "DetailPresenter"

    override fun unsubscribe() {
        subscriptions.clear()
    }

    override fun attach(view: DetailContract.View) {
        this.view = view
        this.view.loadBanner()
        this.getArticleSelected()
        this.loadUserInformation()
    }


    override fun loadUserInformation() {
        var subscribe = userInformation.loadUserInformation()
                .subscribeOn(Schedulers.io())
                .subscribe(
                        { usersInformation ->
                            usersInformation?.let {
                                it.forEach { userInfo = it }
                            }
                        },
                        { error ->
                            Log.e(LOG_TAG, "Error Message: " + error.message)
                            this.view.showUnexpectedError()
                        })

        subscriptions.add(subscribe)
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


    override fun deleteUserInformation() {

        val users = ArrayList<User>()
        users.add(userInfo)

        var subscribe = Observable.fromCallable {
            deleteUser.deleteUser(users)
        }.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ result ->
                    result.forEach {
                        if (it) {
                            this.view.dismissDialog()
                            this.view.navigateToLogin()
                        } else {
                            this.view.dismissDialog()
                            this.view.showUnexpectedError()
                        }
                    }
                }, { error ->
                    Log.e(LOG_TAG, "Error Message: " + error.message)
                    this.view.dismissDialog()
                    this.view.showUnexpectedError()
                })

        subscriptions.add(subscribe)
    }

    override fun displayDialogInformation() {
        this.view.showCloseSessionDialog()
    }


    override fun dismissDialogInformation() {
        this.view.dismissDialog()
    }

    override fun loginUser() {
        this.view.navigateToLogin()
    }

    override fun closeSession() {
        this.deleteUserInformation()
    }

    override fun openGitlab() {
        this.view.redirectToGitlab()
    }

}