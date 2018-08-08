package com.josegrillo.kotlinmvp.view.ui

import android.content.Intent
import android.os.Bundle
import android.view.View
import com.josegrillo.kotlinmvp.R
import com.josegrillo.kotlinmvp.di.component.DaggerActivitiesComponent
import com.josegrillo.kotlinmvp.di.module.ActivitiesModule
import com.josegrillo.kotlinmvp.di.module.LocalRepositoryModule
import com.josegrillo.kotlinmvp.domain.model.ArticleView
import com.josegrillo.kotlinmvp.utils.GlideApp
import com.josegrillo.kotlinmvp.view.base.BaseActivity
import com.josegrillo.kotlinmvp.view.contracts.DetailContract
import kotlinx.android.synthetic.main.activity_detail.*
import javax.inject.Inject

class DetailActivity : BaseActivity(), DetailContract.View, View.OnClickListener {

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

    override fun initializeOnClickListeners() {
        this.activityDetailBackImageview.setOnClickListener(this)
    }

    override fun setArticleInfo(articleView: ArticleView) {

        activityDetailTitleTextview.text = articleView.title
        activityDetailContentTitleTextview.text = articleView.title
        activityDetailContentTextview.text = articleView.content
        activityDetailAreaTextview.text = articleView.area
        GlideApp.with(this).load(articleView.imageUrl).into(activityDetailContentImageview)

    }

    override fun navigateToList() {
        val detailIntent = Intent().setClass(
                this@DetailActivity, ListActivity::class.java)
        startActivity(detailIntent)
        finish()
    }


    override fun onClick(v: View?) {
        when (v?.id) {
            activityDetailBackImageview.id -> presenter.listArticles()
        }
    }
}
