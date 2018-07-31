package com.josegrillo.kotlinmvp.view.base

import android.app.Activity
import android.graphics.Typeface
import android.os.Bundle

open class BaseActivity : Activity() {

    var customFont: Typeface? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        defineCustomFont()
        setCustomFonts()

    }

    private fun defineCustomFont() {

        this.customFont = Typeface.createFromAsset(applicationContext.assets, "fonts/kotlin.otf")
    }

    open fun setCustomFonts() {}

}