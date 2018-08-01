package com.josegrillo.kotlinmvp.view.base

import android.app.Activity
import android.graphics.Typeface
import android.os.Bundle
import com.josegrillo.kotlinmvp.base.KotlinApplication

open class BaseActivity : Activity() {

    var customFont: Typeface? = null
    val Activity.app: KotlinApplication
        get() = application as KotlinApplication


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        injectDependency()
        defineCustomFont()
        setCustomFonts()

    }

    private fun defineCustomFont() {

        this.customFont = Typeface.createFromAsset(applicationContext.assets, "fonts/kotlin.otf")
    }

    open fun setCustomFonts() {}

    open fun injectDependency() {}

}