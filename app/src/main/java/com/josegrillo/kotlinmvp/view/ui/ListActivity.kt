package com.josegrillo.kotlinmvp.view.ui

import android.os.Bundle
import com.josegrillo.kotlinmvp.R
import com.josegrillo.kotlinmvp.view.base.BaseActivity
import kotlinx.android.synthetic.main.activity_list.*

class ListActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        setContentView(R.layout.activity_list)
        super.onCreate(savedInstanceState)

    }


    override fun setCustomFonts() {
        activityListTitleTextview.setTypeface(this.customFont)
    }

}
