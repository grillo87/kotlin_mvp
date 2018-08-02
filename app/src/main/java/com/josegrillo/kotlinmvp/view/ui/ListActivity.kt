package com.josegrillo.kotlinmvp.view.ui

import android.content.Intent
import android.os.Bundle
import com.josegrillo.kotlinmvp.R
import com.josegrillo.kotlinmvp.di.component.DaggerActivitiesComponent
import com.josegrillo.kotlinmvp.di.module.ActivitiesModule
import com.josegrillo.kotlinmvp.domain.model.ArticleView
import com.josegrillo.kotlinmvp.view.base.BaseActivity
import com.josegrillo.kotlinmvp.view.contracts.ListContract
import com.josegrillo.kotlinmvp.view.utils.DialogUtils
import com.josegrillo.kotlinmvp.view.utils.ToastUtils
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

    override fun showLoading() {
        dialog = DialogUtils.showLoadingDialog(this, resources.getString(R.string.loading_articles_text), this.customFont)
    }

    override fun hideLoading() {
        dialog?.dismiss()
    }

    override fun showErrorMessage(message: String) {
        ToastUtils.showToastMessage(applicationContext, message)
    }

    override fun setArticlesList(articles: Array<ArticleView>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun navigateToDetail() {
        val listIntent = Intent().setClass(
                this@ListActivity, DetailActivity::class.java)
        startActivity(listIntent)
        finish()
    }

}
