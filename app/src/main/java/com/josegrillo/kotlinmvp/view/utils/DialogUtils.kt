package com.josegrillo.kotlinmvp.view.utils

import android.app.Dialog
import android.graphics.Typeface
import android.view.Window
import android.widget.TextView
import com.josegrillo.kotlinmvp.R
import com.josegrillo.kotlinmvp.view.base.BaseActivity


class DialogUtils {

    companion object {

        fun showLoadingDialog(activity: BaseActivity, message: String, typeface: Typeface?): Dialog {

            val dialog = Dialog(activity)
            dialog.setCancelable(false)
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
            dialog.setContentView(R.layout.dialog_loading)
            val dialogLoadingBody = dialog.findViewById(R.id.dialogLoadingBody) as TextView
            dialogLoadingBody.setTypeface(typeface)
            dialogLoadingBody.setText(message)

            return dialog

        }


        fun showConfirmDialog(activity: BaseActivity, typeface: Typeface?): Dialog {

            val dialog = Dialog(activity)
            dialog.setCancelable(false)
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
            dialog.setContentView(R.layout.dialog_close_session)

            val dialogCloseSessionAcceptTextview = dialog.findViewById(R.id.dialogCloseSessionConfirmAcceptTextview) as TextView
            val dialogCloseSessionCancelTextview = dialog.findViewById(R.id.dialogCloseSessionConfirmCancelTextview) as TextView
            val dialogCloseSessionTitleTextview = dialog.findViewById(R.id.dialogCloseSessionConfirmTitleTextview) as TextView

            dialogCloseSessionAcceptTextview.setTypeface(typeface)
            dialogCloseSessionCancelTextview.setTypeface(typeface)
            dialogCloseSessionTitleTextview.setTypeface(typeface)

            return dialog

        }

    }

}