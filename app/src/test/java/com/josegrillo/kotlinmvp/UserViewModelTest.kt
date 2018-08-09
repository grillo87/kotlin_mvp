package com.josegrillo.kotlinmvp

import com.josegrillo.kotlinmvp.domain.model.UserView
import org.junit.Assert
import org.junit.Test

class UserViewModelTest {

    @Test
    fun emailValidationTest() {

        val userCorrectEmail = UserView("email@test.com", "1234")
        val userWrongEmail = UserView("email", "1234")

        Assert.assertTrue(userCorrectEmail.isValidEmail())
        Assert.assertFalse(userWrongEmail.isValidEmail())

    }


    @Test
    fun passwordValidationTest() {

        val userCorrectPassword = UserView("email@test.com", "1234")
        val userWrongPassword = UserView("email@test.com", "123")

        Assert.assertTrue(userCorrectPassword.isValidPassword())
        Assert.assertFalse(userWrongPassword.isValidPassword())
    }

}