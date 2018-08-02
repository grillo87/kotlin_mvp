package com.josegrillo.kotlinmvp.view.presenter

import com.josegrillo.kotlinmvp.domain.model.UserView
import com.josegrillo.kotlinmvp.domain.usecase.InsertUser
import com.josegrillo.kotlinmvp.domain.usecase.LoginUser
import com.josegrillo.kotlinmvp.view.contracts.LoginContract
import javax.inject.Inject

class LoginPresenter @Inject constructor(val loginUser: LoginUser, val insertUser: InsertUser) : LoginContract.Presenter {

    private lateinit var view: LoginContract.View

    override fun subscribe() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun unsubscribe() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun attach(view: LoginContract.View) {
        this.view = view
    }

    override fun loginUser(email: String, password: String) {

        this.view.clearFormErrors()

        val user: UserView = UserView(email, password)

        if ((user.email.isEmpty()) || (user.password.isEmpty())) {

            this.view.showEmptyError()

        } else if (!user.isValidEmail()) {

            this.view.showEmailError()

        } else if (!user.isValidPassword()) {

            this.view.showPasswordError()

        } else {

            this.view.showLoading()


        }


    }

    override fun registerUser() {
        this.view.navigateToRegister()
    }

}