package com.josegrillo.kotlinmvp.view.presenter

import android.util.Log
import com.josegrillo.kotlinmvp.domain.model.UserView
import com.josegrillo.kotlinmvp.domain.model.database.User
import com.josegrillo.kotlinmvp.domain.model.mapper.UserMapper
import com.josegrillo.kotlinmvp.domain.usecase.InsertUser
import com.josegrillo.kotlinmvp.domain.usecase.RegisterUser
import com.josegrillo.kotlinmvp.view.contracts.RegisterContract
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class RegisterPresenter @Inject constructor(val registerUser: RegisterUser, val insertUser: InsertUser, val subscriptions: CompositeDisposable) : RegisterContract.Presenter {

    private lateinit var view: RegisterContract.View
    private val LOG_TAG = "RegisterPresenter"

    override fun unsubscribe() {
        subscriptions.clear()
    }

    override fun attach(view: RegisterContract.View) {
        this.view = view
    }

    override fun registerUser(email: String, password: String, confirmPassword: String) {
        this.view.clearFormErrors()

        val user: UserView = UserView(email, password)

        if ((email.isEmpty()) || (password.isEmpty()) || (confirmPassword.isEmpty())) {

            this.view.showEmptyError()

        } else if (!user.isValidEmail()) {

            this.view.showEmailError()

        } else if (!user.isValidPassword()) {

            this.view.showPasswordError()

        } else if (!user.password.equals(confirmPassword)) {

            this.view.showPasswordMissMatchError()

        } else {

            this.view.showLoading()
            var subscribe = registerUser.registerUser(user.email, user.password)
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

    override fun loginUser() {
        this.view.navigateToLogin()
    }
}