package com.josegrillo.kotlinmvp.view.presenter

import android.util.Log
import com.josegrillo.kotlinmvp.domain.model.UserView
import com.josegrillo.kotlinmvp.domain.model.database.User
import com.josegrillo.kotlinmvp.domain.model.mapper.UserMapper
import com.josegrillo.kotlinmvp.domain.usecase.InsertUser
import com.josegrillo.kotlinmvp.domain.usecase.LoginUser
import com.josegrillo.kotlinmvp.view.contracts.LoginContract
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.functions.Function
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class LoginPresenter @Inject constructor(val loginUser: LoginUser, val insertUser: InsertUser, val subscriptions: CompositeDisposable) : LoginContract.Presenter {

    private lateinit var view: LoginContract.View
    private val LOG_TAG = "LoginPresenter"

    override fun unsubscribe() {
        subscriptions.clear()
    }

    override fun attach(view: LoginContract.View) {
        this.view = view
    }

    override fun loginUser(email: String, password: String) {

        this.view.clearFormErrors()

        val user = UserView(email, password)

        if ((user.email.isEmpty()) || (user.password.isEmpty())) {

            this.view.showEmptyError()

        } else if (!user.isValidEmail()) {

            this.view.showEmailError()

        } else if (!user.isValidPassword()) {

            this.view.showPasswordError()

        } else {

            this.view.showLoading()
            var subscribe = loginUser.loginUser(user.email, user.password)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(
                            { userResponse ->
                                if (userResponse?.status == 200) {

                                    userResponse?.user?.let {
                                        it.email = email
                                        insertUser(UserMapper.userApiToDatabase(it))
                                    }

                                } else {

                                    this.view.hideLoading()
                                    userResponse?.message?.let {
                                        this.view.showErrorMessage(it)
                                    }

                                }
                            },
                            { error ->
                                Log.e(LOG_TAG, "Error Message: " + error.message)
                                this.view.hideLoading()
                                this.view.showUnavailableError()
                            }
                    )

            subscriptions.add(subscribe)


        }

    }


    override fun insertUser(user: User) {

        val users: ArrayList<User> = ArrayList<User>()
        users.add(user)

        var subscribe = Observable.fromCallable {
            insertUser.insertUser(users)
        }.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ result ->
                    result.forEach {
                        if (it) {
                            this.view.hideLoading()
                            this.view.navigateToList()
                        } else {
                            this.view.hideLoading()
                            this.view.showUnexpectedError()
                        }
                    }
                }, { error ->
                    Log.e(LOG_TAG, "Error Message: " + error.message)
                    this.view.hideLoading()
                    this.view.showUnexpectedError()
                })

        subscriptions.add(subscribe)

    }

    override fun registerUser() {
        this.view.navigateToRegister()
    }

}