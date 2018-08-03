package com.josegrillo.kotlinmvp.view.ui

import android.content.Intent
import android.os.Bundle
import android.view.View
import com.josegrillo.kotlinmvp.R
import com.josegrillo.kotlinmvp.di.component.DaggerActivitiesComponent
import com.josegrillo.kotlinmvp.di.module.ActivitiesModule
import com.josegrillo.kotlinmvp.di.module.LocalRepositoryModule
import com.josegrillo.kotlinmvp.view.base.BaseActivity
import com.josegrillo.kotlinmvp.view.contracts.SplashContract
import com.josegrillo.kotlinmvp.view.utils.DialogUtils
import kotlinx.android.synthetic.main.activity_splash.*
import java.util.*
import javax.inject.Inject


class SplashActivity : BaseActivity(), SplashContract.View {

    @Inject
    lateinit var presenter: SplashContract.Presenter

    val fadeInAnimationDuration: Long = 3000
    val splashTimeDuration: Long = 5000


    override fun onCreate(savedInstanceState: Bundle?) {
        setContentView(R.layout.activity_splash)
        super.onCreate(savedInstanceState)

    }

    override fun injectDependency() {
        val splashComponent = DaggerActivitiesComponent.builder()
                .localRepositoryModule(LocalRepositoryModule(applicationContext))
                .activitiesModule(ActivitiesModule())
                .build()

        splashComponent.inject(this)
        presenter.attach(this)
    }


    override fun setCustomFonts() {

        activitySplashTitleTextview.setTypeface(this.customFont)
        activitySplashSubtitleTextview.setTypeface(this.customFont)

    }


    override fun defineAnimations() {

        activitySplashTitleTextview.setAlpha(0f)
        activitySplashTitleTextview.setVisibility(View.VISIBLE)

        activitySplashSubtitleTextview.setAlpha(0f)
        activitySplashSubtitleTextview.setVisibility(View.VISIBLE)

        activitySplashKotlinLogoImageview.setAlpha(0f)
        activitySplashKotlinLogoImageview.setVisibility(View.VISIBLE)

    }

    override fun startAnimations() {


        activitySplashTitleTextview.animate()
                .alpha(1f)
                .setDuration(fadeInAnimationDuration)
                .setListener(null)

        activitySplashSubtitleTextview.animate()
                .alpha(1f)
                .setDuration(fadeInAnimationDuration)
                .setListener(null)

        activitySplashKotlinLogoImageview.animate()
                .alpha(0.3f)
                .setDuration(fadeInAnimationDuration)
                .setListener(null)

    }


    override fun startSplashTimer() {

        val task = object : TimerTask() {
            override fun run() {

                presenter.checkArticleSelected()

            }
        }

        val timer = Timer()
        timer.schedule(task, splashTimeDuration)

    }


    override fun navigateToLogin() {
        val loginIntent = Intent().setClass(
                this@SplashActivity, LoginActivity::class.java)
        startActivity(loginIntent)
        finish()
    }

    override fun navigateToList() {
        val listIntent = Intent().setClass(
                this@SplashActivity, ListActivity::class.java)
        startActivity(listIntent)
        finish()
    }

}
