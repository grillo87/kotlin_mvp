package com.josegrillo.kotlinmvp.view.ui

import android.app.Dialog
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.view.Window
import android.widget.TextView
import com.josegrillo.kotlinmvp.R
import com.josegrillo.kotlinmvp.di.component.DaggerActivitiesComponent
import com.josegrillo.kotlinmvp.di.module.ActivitiesModule
import com.josegrillo.kotlinmvp.di.module.LocalRepositoryModule
import com.josegrillo.kotlinmvp.domain.model.ArticleView
import com.josegrillo.kotlinmvp.view.adapter.ArticlesRecyclerViewAdapter
import com.josegrillo.kotlinmvp.view.base.BaseActivity
import com.josegrillo.kotlinmvp.view.contracts.ListContract
import com.josegrillo.kotlinmvp.view.utils.DialogUtils
import com.josegrillo.kotlinmvp.view.utils.ToastUtils
import kotlinx.android.synthetic.main.activity_list.*
import javax.inject.Inject

class ListActivity : BaseActivity(), ListContract.View, View.OnClickListener {

    @Inject
    lateinit var presenter: ListContract.Presenter
    lateinit var dialogCloseSession: Dialog
    lateinit var dialogCloseSessionAcceptTextview: TextView
    lateinit var dialogCloseSessionCancelTextview: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        setContentView(R.layout.activity_list)
        super.onCreate(savedInstanceState)

    }

    override fun initializeSupportActionBar() {

        setSupportActionBar(activityListToolBar)
        supportActionBar?.title = resources.getString(R.string.kotlin_list_title)

    }

    override fun onDestroy() {
        presenter.unsubscribe()
        super.onDestroy()
    }

    override fun injectDependency() {
        val listComponent = DaggerActivitiesComponent.builder()
                .localRepositoryModule(LocalRepositoryModule(applicationContext))
                .activitiesModule(ActivitiesModule())
                .build()

        listComponent.inject(this)
        presenter.attach(this)
    }

    override fun showLoading() {
        dialog = DialogUtils.showLoadingDialog(this, resources.getString(R.string.loading_articles_text), this.customFont)
        dialog?.show()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        menuInflater.inflate(R.menu.toolbar_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {

            R.id.actionGitlab -> presenter.openGitlab()
            R.id.actionCloseSession -> presenter.displayDialogInformation()
        }


        return true
    }

    override fun hideLoading() {
        dialog?.dismiss()
    }

    override fun showErrorMessage(message: String) {
        ToastUtils.showToastMessage(applicationContext, message)
    }

    override fun showUnavailableError() {
        ToastUtils.showToastMessage(applicationContext, resources.getString(R.string.unavailable_error_message))
    }

    override fun showUnexpectedError() {
        ToastUtils.showToastMessage(applicationContext, resources.getString(R.string.unexpected_error_message))
    }

    override fun setArticlesList(articles: ArrayList<ArticleView>) {
        activityListRecyclerView.adapter = ArticlesRecyclerViewAdapter(articles, this)
        activityListRecyclerView.layoutManager = LinearLayoutManager(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            dialogCloseSessionAcceptTextview?.id -> presenter.closeSession()
            dialogCloseSessionCancelTextview?.id -> presenter.dismissDialogInformation()
        }
    }

    override fun onTouchArticle(view: View, position: Int) {
        presenter.setArticleSelected(position)

    }

    override fun navigateToDetail() {
        val listIntent = Intent().setClass(
                this@ListActivity, DetailActivity::class.java)
        startActivity(listIntent)
    }

    override fun navigateToLogin() {
        val loginIntent = Intent().setClass(
                this@ListActivity, LoginActivity::class.java)
        startActivity(loginIntent)
        finish()
    }

    override fun showCloseSessionDialog() {
        dialogCloseSession = Dialog(this)
        dialogCloseSession.setCancelable(false)
        dialogCloseSession.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialogCloseSession.setContentView(R.layout.dialog_close_session)

        dialogCloseSessionAcceptTextview = dialogCloseSession.findViewById(R.id.dialogCloseSessionConfirmAcceptTextview) as TextView
        dialogCloseSessionCancelTextview = dialogCloseSession.findViewById(R.id.dialogCloseSessionConfirmCancelTextview) as TextView
        val dialogCloseSessionTitleTextview = dialogCloseSession.findViewById(R.id.dialogCloseSessionConfirmTitleTextview) as TextView

        dialogCloseSessionAcceptTextview.setTypeface(this.customFont)
        dialogCloseSessionCancelTextview.setTypeface(this.customFont)
        dialogCloseSessionTitleTextview.setTypeface(this.customFont)

        dialogCloseSessionAcceptTextview.setOnClickListener(this)
        dialogCloseSessionCancelTextview.setOnClickListener(this)

        dialogCloseSession?.show()
    }

    override fun dismissDialog() {
        dialogCloseSession?.dismiss()
    }

    override fun redirectToGitlab() {

        val gitlabIntent = Intent(Intent.ACTION_VIEW, Uri.parse(resources.getString(R.string.gitlab_url_repository)))
        startActivity(gitlabIntent)

    }

}
