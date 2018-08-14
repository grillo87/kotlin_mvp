package com.josegrillo.kotlinmvp.view.ui

import android.app.Dialog
import android.content.Intent
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.text.Html
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.view.Window
import android.widget.TextView
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.MobileAds
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

    override fun initializeSupportActionBar() {

        setSupportActionBar(activityDetailToolbar)
        supportActionBar?.title = resources.getString(R.string.kotlin_detail_title)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.toolbar_menu, menu);
        return true;
    }


    override fun injectDependency() {
        val detailComponent = DaggerActivitiesComponent.builder()
                .localRepositoryModule(LocalRepositoryModule(applicationContext))
                .activitiesModule(ActivitiesModule())
                .build()

        detailComponent.inject(this)
        presenter.attach(this)
    }

    override fun setArticleInfo(articleView: ArticleView) {

        activityDetailContentTitleTextview.text = articleView.title
        activityDetailAreaTextview.text = articleView.area
        GlideApp.with(this).load(articleView.imageUrl).into(activityDetailContentImageview)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {

            activityDetailContentTextview.text = Html.fromHtml(articleView.content, Html.FROM_HTML_MODE_LEGACY)


        } else {

            activityDetailContentTextview.text = Html.fromHtml(articleView.content)

        }

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

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {

            R.id.actionGitlab -> presenter.openGitlab()
            R.id.actionRateApp -> presenter.openGooglePlay()
            R.id.actionCloseSession -> presenter.displayDialogInformation()
        }


        return false
    }

    override fun onClick(v: View?) {
        when (v?.id) {
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

    override fun redirectToGitlab() {

        val gitlabIntent = Intent(Intent.ACTION_VIEW, Uri.parse(resources.getString(R.string.gitlab_url_repository)))
        startActivity(gitlabIntent)

    }

    override fun loadBanner() {

        MobileAds.initialize(this, resources.getString(R.string.activity_detail_banner_unitid))
        val adRequest = AdRequest.Builder().build()
        activityDetailBannerAdview.loadAd(adRequest)

    }

    override fun redirectToGooglePlay() {

        var googlePlayIntent: Intent? = null

        try {

            googlePlayIntent = Intent(Intent.ACTION_VIEW, Uri.parse(resources.getString(R.string.google_play_deep_linking)))

        } catch (anfe: android.content.ActivityNotFoundException) {

            googlePlayIntent = Intent(Intent.ACTION_VIEW, Uri.parse(resources.getString(R.string.google_play_url)))
        }

        startActivity(googlePlayIntent)


    }


}
