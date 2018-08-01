package com.josegrillo.kotlinmvp.view.ui

import android.os.Bundle
import com.josegrillo.kotlinmvp.R
import com.josegrillo.kotlinmvp.di.component.DaggerActivitiesComponent
import com.josegrillo.kotlinmvp.di.module.ActivitiesModule
import com.josegrillo.kotlinmvp.view.base.BaseActivity
import com.josegrillo.kotlinmvp.view.contracts.RegisterContract
import kotlinx.android.synthetic.main.activity_register.*
import javax.inject.Inject

class RegisterActivity : BaseActivity(), RegisterContract.View {

    @Inject
    lateinit var presenter: RegisterContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        setContentView(R.layout.activity_register)
        super.onCreate(savedInstanceState)

    }

    override fun injectDependency() {

        val registerComponent = DaggerActivitiesComponent.builder()
                .activitiesModule(ActivitiesModule())
                .build()

        registerComponent.inject(this)
        presenter.attach(this)
    }


    override fun setCustomFonts() {

        activityRegisterTitle.setTypeface(this.customFont)
        activityRegisterButton.setTypeface(this.customFont)

    }

}
