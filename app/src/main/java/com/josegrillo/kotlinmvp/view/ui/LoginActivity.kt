package com.josegrillo.kotlinmvp.view.ui

import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import android.view.View
import com.josegrillo.kotlinmvp.R
import com.josegrillo.kotlinmvp.di.component.DaggerActivitiesComponent
import com.josegrillo.kotlinmvp.di.module.ActivitiesModule
import com.josegrillo.kotlinmvp.view.base.BaseActivity
import com.josegrillo.kotlinmvp.view.contracts.LoginContract
import com.josegrillo.kotlinmvp.view.utils.DialogUtils
import kotlinx.android.synthetic.main.activity_login.*
import javax.inject.Inject


class LoginActivity : BaseActivity(), LoginContract.View, View.OnClickListener {

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

    override fun initializeOnClickListeners() {
        activityLoginButton.setOnClickListener(this)
        activityLoginRegisterButton.setOnClickListener(this)
    }

    override fun navigateToRegister() {
        val loginIntent = Intent().setClass(
                this@LoginActivity, RegisterActivity::class.java)
        startActivity(loginIntent)
        finish()
    }

    override fun showLoading() {
        dialog = DialogUtils.showLoadingDialog(this, "Probando Loading\niiififififif", this.customFont)
    }

    override fun hideLoading() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showEmailError(message: String) {
        activityLoginEmailEdittext.setError(message)
    }

    override fun showPasswordError(message: String) {
        activityLoginPasswordEdittext.setError(message)
    }


    override fun clearFormErrors() {
        activityLoginEmailEdittext.setError(null)
        activityLoginPasswordEdittext.setError(null)
    }

    override fun onClick(v: View?) {
        when (v?.id) {

            activityLoginButton.id -> presenter.validateUserLogin(activityLoginEmailEdittext.text.toString(), activityLoginPasswordEdittext.text.toString())

            activityLoginPasswordEdittext.id -> presenter.registerUser()

        }
    }


}
