package com.josegrillo.kotlinmvp.view.ui

import android.os.Bundle
import com.josegrillo.kotlinmvp.R
import com.josegrillo.kotlinmvp.view.base.BaseActivity

class ListActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        setContentView(R.layout.activity_list)
        super.onCreate(savedInstanceState)

    }
}
