package com.josegrillo.kotlinmvp.view.utils

import android.content.pm.ActivityInfo
import android.os.Build
import android.support.v4.content.ContextCompat
import android.view.WindowManager
import com.josegrillo.kotlinmvp.R
import com.josegrillo.kotlinmvp.view.base.BaseActivity


class ScreenUtils {

    companion object {

        fun tintStatusBar(activity: BaseActivity) {

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {

                val window = activity.window
                window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
                window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
                window.statusBarColor = ContextCompat.getColor(activity, R.color.colorPrimaryDark)

            }

        }


        fun setPortaitOrientation(activity: BaseActivity) {
            activity.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_SENSOR_PORTRAIT

        }


    }


}