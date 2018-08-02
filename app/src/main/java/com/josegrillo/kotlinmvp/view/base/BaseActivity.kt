package com.josegrillo.kotlinmvp.view.base

import android.app.Activity
import android.app.Dialog
import android.graphics.Typeface
import android.os.Bundle
import com.josegrillo.kotlinmvp.base.KotlinApplication
import com.josegrillo.kotlinmvp.view.utils.ScreenUtils

open class BaseActivity : Activity() {

    var customFont: Typeface? = null
    var dialog: Dialog? = null
    val Activity.app: KotlinApplication
        get() = application as KotlinApplication


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        injectDependency()
        defineCustomFont()
        setCustomFonts()
        setStatusBar()
        setAppOrientation()
        initializeOnClickListeners()

    }

    private fun defineCustomFont() {

        this.customFont = Typeface.createFromAsset(applicationContext.assets, "fonts/kotlin.otf")
    }

    private fun setStatusBar() {

        ScreenUtils.tintStatusBar(this)

    }


    private fun setAppOrientation() {

        ScreenUtils.setPortaitOrientation(this)

    }

    open fun setCustomFonts() {}

    open fun injectDependency() {}

    open fun initializeOnClickListeners() {}

}