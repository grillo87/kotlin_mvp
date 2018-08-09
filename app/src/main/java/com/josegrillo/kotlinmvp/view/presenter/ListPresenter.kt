package com.josegrillo.kotlinmvp.view.presenter

import android.util.Log
import com.josegrillo.kotlinmvp.domain.model.ArticleView
import com.josegrillo.kotlinmvp.domain.model.UserView
import com.josegrillo.kotlinmvp.domain.model.api.response.Article
import com.josegrillo.kotlinmvp.domain.model.database.User
import com.josegrillo.kotlinmvp.domain.model.mapper.ArticleMapper
import com.josegrillo.kotlinmvp.domain.usecase.*
import com.josegrillo.kotlinmvp.view.contracts.ListContract
import io.reactivex.Observable
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class ListPresenter @Inject constructor(val getArticles: GetArticles, val getArticleSelected: GetArticleSelected, val insertArticleSelected: InsertArticleSelected, val deleteArticleSelected: DeleteArticleSelected, val loadUserInformation: LoadUserInformation, val deleteUser: DeleteUser, val subscriptions: CompositeDisposable) : ListContract.Presenter {

    private lateinit var view: ListContract.View
    private lateinit var userInfo: User
    private val articlesList = ArrayList<Article>()
    private val LOG_TAG = "ListPresenter"

    override fun unsubscribe() {
        subscriptions.clear()
    }

    override fun attach(view: ListContract.View) {
        this.view = view
        this.view.showLoading()

        this.loadUserInformation()
        this.checkArticleSelected()
        this.loadArticles()
    }

    override fun loadArticles() {
        var subscribe = getArticles.getArticles()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        {
                            articlesList.addAll(it)
                            this.view.setArticlesList(ArticleMapper.articlesApiToViewModel(it))
                            this.view.hideLoading()
                        },
                        { error ->
                            Log.e(LOG_TAG, "Error Message: " + error.message)
                            this.view.hideLoading()
                            this.view.showUnavailableError()
                        })

        subscriptions.add(subscribe)

    }

    override fun checkArticleSelected() {
        var subscribe = getArticleSelected.isArticleRepoEmpty().subscribeOn(Schedulers.io())
                .subscribe(
                        { articleRepoEmpty ->
                            if (!articleRepoEmpty) {
                                deleteArticlesSelected()
                            }

                        },
                        { error ->
                            Log.e(LOG_TAG, "Error Message: " + error.message)
                        }
                )

        subscriptions.add(subscribe)
    }

    override fun loadUserInformation() {
        var subscribe = loadUserInformation.loadUserInformation()
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

    override fun setArticleSelected(position: Int) {
        insertArticleSelected(ArticleMapper.articleApiToDatabase(articlesList.get(position)))

    }

    override fun insertArticleSelected(article: com.josegrillo.kotlinmvp.domain.model.database.Article) {

        val articlesSelected: ArrayList<com.josegrillo.kotlinmvp.domain.model.database.Article> = ArrayList<com.josegrillo.kotlinmvp.domain.model.database.Article>()
        articlesSelected.add(article)

        var subscribe = Observable.fromCallable {
            insertArticleSelected.insertArticleSelected(articlesSelected)
        }
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ result ->
                    result.forEach {
                        if (it) {
                            this.view.navigateToDetail()
                        } else {
                            this.view.showUnexpectedError()
                        }
                    }
                },
                        { error ->
                            Log.e(LOG_TAG, "Error Message: " + error.message)
                            this.view.showUnexpectedError()

                        })

        subscriptions.add(subscribe)
    }


    override fun deleteArticlesSelected() {

        var subscribe = deleteArticleSelected.deleteArticlesRepo().subscribeOn(Schedulers.io())
                .subscribe(
                        { deleted ->
                            if (deleted) {
                                Log.v(LOG_TAG, "articleSelected successfully deleted")
                            } else {
                                Log.e(LOG_TAG, "articleSelected couldn't be deleted")
                            }
                        },
                        { error ->
                            Log.e(LOG_TAG, "Error Message: " + error.message)
                        }
                )

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

    override fun openGitlab() {
        this.view.redirectToGitlab()
    }

}