package com.josegrillo.kotlinmvp.view.ui

import android.content.Intent
import android.os.Bundle
import android.view.View
import com.josegrillo.kotlinmvp.R
import com.josegrillo.kotlinmvp.view.base.BaseActivity
import kotlinx.android.synthetic.main.activity_login.*


class LoginActivity : BaseActivity() {


    fun navigateToRegister() {

        val loginIntent = Intent().setClass(
                this@LoginActivity, RegisterActivity::class.java)
        startActivity(loginIntent)
        finish()

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        setContentView(R.layout.activity_login)
        super.onCreate(savedInstanceState)

    }
}
