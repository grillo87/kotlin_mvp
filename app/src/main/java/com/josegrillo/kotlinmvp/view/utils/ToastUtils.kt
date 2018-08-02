package com.josegrillo.kotlinmvp.view.utils

import android.content.Context
import android.widget.Toast

class ToastUtils {

    companion object {

        fun showToastMessage(context: Context, message: String) {

            Toast.makeText(context, message, Toast.LENGTH_LONG).show()
        }


    }


}