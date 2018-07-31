package com.josegrillo.kotlinmvp.view.ui

import android.os.Bundle
import android.view.View
import com.josegrillo.kotlinmvp.R
import com.josegrillo.kotlinmvp.view.base.BaseActivity
import kotlinx.android.synthetic.main.activity_splash.*
import android.content.Intent
import java.util.*


class SplashActivity : BaseActivity() {

    val fadeInAnimationDuration: Long = 3000
    val splashTimeDuration: Long = 5000


    override fun onCreate(savedInstanceState: Bundle?) {
        setContentView(R.layout.activity_splash)
        super.onCreate(savedInstanceState)

        defineAnimations()
        startAnimations()
        startSplashTimer()

    }


    override fun setCustomFonts() {

        activitySplashTitleTextview.setTypeface(this.customFont)
        activitySplashSubtitleTextview.setTypeface(this.customFont)

    }


    fun defineAnimations() {

        activitySplashTitleTextview.setAlpha(0f)
        activitySplashTitleTextview.setVisibility(View.VISIBLE)

        activitySplashSubtitleTextview.setAlpha(0f)
        activitySplashSubtitleTextview.setVisibility(View.VISIBLE)

        activitySplashKotlinLogoImageview.setAlpha(0f)
        activitySplashKotlinLogoImageview.setVisibility(View.VISIBLE)

    }

    fun startAnimations() {


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


    fun startSplashTimer() {

        val task = object : TimerTask() {
            override fun run() {

                val loginIntent = Intent().setClass(
                        this@SplashActivity, LoginActivity::class.java)
                startActivity(loginIntent)
                finish()


            }
        }

        val timer = Timer()
        timer.schedule(task, splashTimeDuration)

    }

}
