package com.josegrillo.kotlinmvp.domain.model

import com.josegrillo.kotlinmvp.utils.AppConstants

data class UserView(
        var email: String,
        var password: String) {

    constructor() : this("", "")

    fun isValidEmail(): Boolean {

        return AppConstants.EMAIL_ADDRESS_PATTERN.matcher(this.email).matches()
    }

    fun isValidPassword(): Boolean {

        var result: Boolean = false

        if (this.password.length >= 4) {

            result = true

        }

        return result
    }

}