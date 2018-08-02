package com.josegrillo.kotlinmvp.view.presenter

import com.josegrillo.kotlinmvp.domain.model.UserView
import com.josegrillo.kotlinmvp.domain.usecase.InsertUser
import com.josegrillo.kotlinmvp.domain.usecase.RegisterUser
import com.josegrillo.kotlinmvp.view.contracts.RegisterContract
import javax.inject.Inject

class RegisterPresenter @Inject constructor(val registerUser: RegisterUser, val insertUser: InsertUser) : RegisterContract.Presenter {

    private lateinit var view: RegisterContract.View

    override fun unsubscribe() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun attach(view: RegisterContract.View) {
        this.view = view
    }

    override fun subscribe() {
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

        }


    }

    override fun loginUser() {
        this.view.navigateToLogin()
    }
}