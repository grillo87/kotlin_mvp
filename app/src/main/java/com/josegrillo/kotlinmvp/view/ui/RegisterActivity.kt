package com.josegrillo.kotlinmvp.view.ui

import android.content.Intent
import android.os.Bundle
import android.view.View
import com.josegrillo.kotlinmvp.R
import com.josegrillo.kotlinmvp.di.component.DaggerActivitiesComponent
import com.josegrillo.kotlinmvp.di.module.ActivitiesModule
import com.josegrillo.kotlinmvp.di.module.LocalRepositoryModule
import com.josegrillo.kotlinmvp.view.base.BaseActivity
import com.josegrillo.kotlinmvp.view.contracts.RegisterContract
import com.josegrillo.kotlinmvp.view.utils.DialogUtils
import com.josegrillo.kotlinmvp.view.utils.ToastUtils
import kotlinx.android.synthetic.main.activity_register.*
import javax.inject.Inject

class RegisterActivity : BaseActivity(), RegisterContract.View, View.OnClickListener {

    @Inject
    lateinit var presenter: RegisterContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        setContentView(R.layout.activity_register)
        super.onCreate(savedInstanceState)

    }

    override fun injectDependency() {

        val registerComponent = DaggerActivitiesComponent.builder()
                .localRepositoryModule(LocalRepositoryModule(applicationContext))
                .activitiesModule(ActivitiesModule())
                .build()

        registerComponent.inject(this)
        presenter.attach(this)
    }


    override fun setCustomFonts() {

        activityRegisterTitle.setTypeface(this.customFont)
        activityRegisterButton.setTypeface(this.customFont)

    }

    override fun initializeOnClickListeners() {
        activityDetailBackImageview.setOnClickListener(this)
        activityRegisterButton.setOnClickListener(this)
    }

    override fun showLoading() {
        dialog = DialogUtils.showLoadingDialog(this, resources.getString(R.string.loading_register_text), this.customFont)
    }

    override fun hideLoading() {
        dialog?.dismiss()
    }

    override fun navigateToLogin() {
        val registerIntent = Intent().setClass(
                this@RegisterActivity, LoginActivity::class.java)
        startActivity(registerIntent)
        finish()
    }

    override fun showEmptyError() {
        ToastUtils.showToastMessage(applicationContext, resources.getString(R.string.empty_inputs_message))
    }

    override fun showEmailError() {
        activityRegisterEmailEdittext.setError(resources.getString(R.string.email_error_format_message))
    }

    override fun showPasswordError() {
        activityRegisterPasswordEdittext.setError(resources.getString(R.string.password_error_format_message))
    }

    override fun showPasswordMissMatchError() {
        activityRegisterPasswordEdittext.setError(resources.getString(R.string.password_missmatch_error_message))
    }

    override fun showErrorMessage(message: String) {
        ToastUtils.showToastMessage(applicationContext, message)
    }

    override fun clearFormErrors() {
        activityRegisterEmailEdittext.setError(null)
        activityRegisterPasswordEdittext.setError(null)
        activityRegisterConfirmPasswordEdittext.setError(null)
    }

    override fun onClick(v: View?) {
        when (v?.id) {

            activityDetailBackImageview.id -> presenter.loginUser()
            activityRegisterButton.id -> presenter.registerUser(activityRegisterEmailEdittext.text.toString(), activityRegisterPasswordEdittext.text.toString(), activityRegisterConfirmPasswordEdittext.text.toString())


        }
    }


}
