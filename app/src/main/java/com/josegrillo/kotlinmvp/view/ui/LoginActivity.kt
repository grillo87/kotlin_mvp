package com.josegrillo.kotlinmvp.view.ui

import android.content.Intent
import android.os.Bundle
import com.josegrillo.kotlinmvp.R
import com.josegrillo.kotlinmvp.di.component.DaggerActivitiesComponent
import com.josegrillo.kotlinmvp.di.module.ActivitiesModule
import com.josegrillo.kotlinmvp.view.base.BaseActivity
import com.josegrillo.kotlinmvp.view.contracts.LoginContract
import kotlinx.android.synthetic.main.activity_login.*
import javax.inject.Inject


class LoginActivity : BaseActivity(), LoginContract.View {

    @Inject
    lateinit var presenter: LoginContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        setContentView(R.layout.activity_login)
        super.onCreate(savedInstanceState)

    }

    override fun injectDependency() {
        val loginComponent = DaggerActivitiesComponent.builder()
                .activitiesModule(ActivitiesModule())
                .build()

        loginComponent.inject(this)
        presenter.attach(this)
    }

    override fun setCustomFonts() {
        activityLoginTitleTextview.setTypeface(this.customFont)
        activityLoginButton.setTypeface(this.customFont)
        activityLoginRegisterButton.setTypeface(this.customFont)
    }


    fun navigateToRegister() {

        val loginIntent = Intent().setClass(
                this@LoginActivity, RegisterActivity::class.java)
        startActivity(loginIntent)
        finish()

    }

}
