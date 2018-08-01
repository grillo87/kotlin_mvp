package com.josegrillo.kotlinmvp.view.presenter

import com.josegrillo.kotlinmvp.view.contracts.LoginContract

class LoginPresenter : LoginContract.Presenter {

    private lateinit var view: LoginContract.View

    override fun subscribe() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun unsubscribe() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun attach(view: LoginContract.View) {
        this.view = view
        this.view.showLoading()
    }

    override fun validateUserLogin(email: String, password: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun registerUser() {

    }

}