package com.josegrillo.kotlinmvp.view.ui

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.josegrillo.kotlinmvp.R
import com.josegrillo.kotlinmvp.di.component.DaggerActivitiesComponent
import com.josegrillo.kotlinmvp.di.module.ActivitiesModule
import com.josegrillo.kotlinmvp.di.module.LocalRepositoryModule
import com.josegrillo.kotlinmvp.view.base.BaseActivity
import com.josegrillo.kotlinmvp.view.contracts.LoginContract
import com.josegrillo.kotlinmvp.view.utils.DialogUtils
import com.josegrillo.kotlinmvp.view.utils.ToastUtils
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
                .localRepositoryModule(LocalRepositoryModule(applicationContext))
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
        dialog = DialogUtils.showLoadingDialog(this, resources.getString(R.string.loading_login_text), this.customFont)
    }

    override fun hideLoading() {
        dialog?.dismiss()
    }

    override fun showEmptyError() {
        ToastUtils.showToastMessage(applicationContext, resources.getString(R.string.empty_inputs_message))
    }

    override fun showEmailError() {
        activityLoginEmailEdittext.setError(resources.getString(R.string.email_error_format_message))
    }

    override fun showPasswordError() {
        activityLoginEmailEdittext.setError(resources.getString(R.string.password_error_format_message))
    }

    override fun showErrorMessage(message: String) {
        ToastUtils.showToastMessage(applicationContext, message)
    }


    override fun clearFormErrors() {
        activityLoginEmailEdittext.setError(null)
        activityLoginPasswordEdittext.setError(null)
    }

    override fun onClick(v: View?) {

        when (v?.id) {

            activityLoginButton.id -> presenter.loginUser(activityLoginEmailEdittext.text.toString().trim(), activityLoginPasswordEdittext.text.toString().trim())

            activityLoginRegisterButton.id -> presenter.registerUser()

        }
    }


}
