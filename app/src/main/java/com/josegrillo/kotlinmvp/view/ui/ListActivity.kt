package com.josegrillo.kotlinmvp.view.ui

import android.os.Bundle
import com.josegrillo.kotlinmvp.R
import com.josegrillo.kotlinmvp.di.component.DaggerActivitiesComponent
import com.josegrillo.kotlinmvp.di.module.ActivitiesModule
import com.josegrillo.kotlinmvp.view.base.BaseActivity
import com.josegrillo.kotlinmvp.view.contracts.ListContract
import kotlinx.android.synthetic.main.activity_list.*
import javax.inject.Inject

class ListActivity : BaseActivity(), ListContract.View {

    @Inject
    lateinit var presenter: ListContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        setContentView(R.layout.activity_list)
        super.onCreate(savedInstanceState)

    }

    override fun injectDependency() {
        val listComponent = DaggerActivitiesComponent.builder()
                .activitiesModule(ActivitiesModule())
                .build()

        listComponent.inject(this)
        presenter.attach(this)
    }


    override fun setCustomFonts() {
        activityListTitleTextview.setTypeface(this.customFont)
    }

}
