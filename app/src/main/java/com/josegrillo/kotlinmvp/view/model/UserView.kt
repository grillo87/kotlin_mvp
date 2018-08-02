package com.josegrillo.kotlinmvp.domain.model

data class UserView(
        var email: String,
        var password: String) {

    constructor() : this("", "")

    fun isValidEmail(): Boolean {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(this.email).matches()
    }

    fun isValidPassword(): Boolean {

        var result: Boolean = false

        if (this.password.length >= 4) {

            result = true

        }

        return result
    }

}