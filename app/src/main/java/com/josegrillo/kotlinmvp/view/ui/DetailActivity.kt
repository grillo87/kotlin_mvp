package com.josegrillo.kotlinmvp.view.ui

import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.Window
import android.widget.TextView
import com.josegrillo.kotlinmvp.R
import com.josegrillo.kotlinmvp.di.component.DaggerActivitiesComponent
import com.josegrillo.kotlinmvp.di.module.ActivitiesModule
import com.josegrillo.kotlinmvp.di.module.LocalRepositoryModule
import com.josegrillo.kotlinmvp.domain.model.ArticleView
import com.josegrillo.kotlinmvp.utils.GlideApp
import com.josegrillo.kotlinmvp.view.base.BaseActivity
import com.josegrillo.kotlinmvp.view.contracts.DetailContract
import com.josegrillo.kotlinmvp.view.utils.ToastUtils
import kotlinx.android.synthetic.main.activity_detail.*
import javax.inject.Inject

class DetailActivity : BaseActivity(), DetailContract.View, View.OnClickListener {

    @Inject
    lateinit var presenter: DetailContract.Presenter
    lateinit var dialogCloseSession: Dialog
    lateinit var dialogCloseSessionAcceptTextview: TextView
    lateinit var dialogCloseSessionCancelTextview: TextView


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
        this.activityDetailProfileImageview.setOnClickListener(this)
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

    override fun showUnexpectedError() {
        ToastUtils.showToastMessage(applicationContext, resources.getString(R.string.unexpected_error_message))
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


    override fun onClick(v: View?) {
        when (v?.id) {
            activityDetailBackImageview.id -> presenter.listArticles()
            activityDetailProfileImageview.id -> presenter.displayDialogInformation()
            dialogCloseSessionAcceptTextview?.id -> presenter.closeSession()
            dialogCloseSessionCancelTextview?.id -> presenter.dismissDialogInformation()
        }
    }

    override fun navigateToLogin() {
        val loginIntent = Intent().setClass(
                this@DetailActivity, LoginActivity::class.java)
        startActivity(loginIntent)
        finish()
    }

}
