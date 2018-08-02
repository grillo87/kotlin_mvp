package com.josegrillo.kotlinmvp.view.contracts

class LoginContract {

    interface View : BaseContract.View {

        fun navigateToRegister()
        fun showLoading()
        fun hideLoading()
        fun clearFormErrors()
        fun showEmptyError()
        fun showEmailError()
        fun showPasswordError()
        fun showErrorMessage(message: String)

    }

    interface Presenter : BaseContract.Presenter<View> {

        fun loginUser(email: String, password: String)
        fun registerUser()

    }

}