package com.josegrillo.kotlinmvp.view.contracts

class RegisterContract {

    interface View : BaseContract.View {

        fun showLoading()
        fun hideLoading()
        fun navigateToLogin()
        fun showEmptyError()
        fun showEmailError()
        fun showPasswordError()
        fun showPasswordMissMatchError()
        fun showErrorMessage(message: String)
        fun clearFormErrors()

    }

    interface Presenter : BaseContract.Presenter<View> {

        fun registerUser(email: String, password: String, confirmPassword: String)
        fun loginUser()

    }

}