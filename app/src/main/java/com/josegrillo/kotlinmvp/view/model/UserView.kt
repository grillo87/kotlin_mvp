package com.josegrillo.kotlinmvp.domain.model

import android.util.Patterns
import java.util.regex.Pattern

data class UserView(
        var email: String,
        var password: String) {

    constructor() : this("", "")

    fun isValidEmail(): Boolean {
        return Patterns.EMAIL_ADDRESS.matcher(this.email).matches()
    }

    fun isValidPassword(): Boolean {

        var result: Boolean = false

        if (this.password.length >= 4) {

            result = true

        }

        return result
    }

}