package com.josegrillo.kotlinmvp.view.contracts

class LoginContract {

    interface View : BaseContract.View {

        fun navigateToRegister()
        fun showLoading()
        fun hideLoading()
        fun clearFormErrors()
        fun showEmailError(message: String)
        fun showPasswordError(message: String)

    }

    interface Presenter : BaseContract.Presenter<View> {

        fun validateUserLogin(email: String, password: String)
        fun registerUser()

    }

}