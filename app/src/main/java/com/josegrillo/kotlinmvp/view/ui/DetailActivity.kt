package com.josegrillo.kotlinmvp.view.ui

import android.content.Intent
import android.os.Bundle
import com.josegrillo.kotlinmvp.R
import com.josegrillo.kotlinmvp.di.component.DaggerActivitiesComponent
import com.josegrillo.kotlinmvp.di.module.ActivitiesModule
import com.josegrillo.kotlinmvp.di.module.LocalRepositoryModule
import com.josegrillo.kotlinmvp.domain.model.ArticleView
import com.josegrillo.kotlinmvp.view.base.BaseActivity
import com.josegrillo.kotlinmvp.view.contracts.DetailContract
import kotlinx.android.synthetic.main.activity_detail.*
import javax.inject.Inject

class DetailActivity : BaseActivity(), DetailContract.View {

    @Inject
    lateinit var presenter: DetailContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        setContentView(R.layout.activity_detail)
        super.onCreate(savedInstanceState)

    }

    override fun onDestroy() {
        presenter.unsubscribe()
        super.onDestroy()
    }


    override fun injectDependency() {
        val detailComponent = DaggerActivitiesComponent.builder()
                .localRepositoryModule(LocalRepositoryModule(applicationContext))
                .activitiesModule(ActivitiesModule())
                .build()

        detailComponent.inject(this)
        presenter.attach(this)
    }


    override fun setCustomFonts() {
        activityDetailTitleTextview.setTypeface(this.customFont)
    }

    override fun setArticleInfo(articleView: ArticleView) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun navigateToList() {
        val detailIntent = Intent().setClass(
                this@DetailActivity, ListActivity::class.java)
        startActivity(detailIntent)
        finish()
    }
}
