package com.josegrillo.kotlinmvp.view.contracts

import com.josegrillo.kotlinmvp.domain.model.database.User

class LoginContract {

    interface View : BaseContract.View {

        fun navigateToRegister()
        fun navigateToList()
        fun showLoading()
        fun hideLoading()
        fun clearFormErrors()
        fun showEmptyError()
        fun showEmailError()
        fun showPasswordError()
        fun showUnavailableError()
        fun showUnexpectedError()
        fun showErrorMessage(message: String)

    }

    interface Presenter : BaseContract.Presenter<View> {

        fun loginUser(email: String, password: String)
        fun registerUser()
        fun insertUser(user: User)

    }

}