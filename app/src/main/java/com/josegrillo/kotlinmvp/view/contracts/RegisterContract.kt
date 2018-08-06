package com.josegrillo.kotlinmvp.view.contracts

import com.josegrillo.kotlinmvp.domain.model.database.User

class RegisterContract {

    interface View : BaseContract.View {

        fun showLoading()
        fun hideLoading()
        fun navigateToLogin()
        fun navigateToList()
        fun showEmptyError()
        fun showEmailError()
        fun showPasswordError()
        fun showPasswordMissMatchError()
        fun showErrorMessage(message: String)
        fun showUnavailableError()
        fun showUnexpectedError()
        fun clearFormErrors()

    }

    interface Presenter : BaseContract.Presenter<View> {

        fun registerUser(email: String, password: String, confirmPassword: String)
        fun loginUser()
        fun insertUser(user: User)

    }

}