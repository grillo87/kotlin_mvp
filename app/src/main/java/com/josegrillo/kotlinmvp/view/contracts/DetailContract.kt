package com.josegrillo.kotlinmvp.view.contracts

import com.josegrillo.kotlinmvp.domain.model.ArticleView

class DetailContract {

    interface View : BaseContract.View {

        fun setArticleInfo(articleView: ArticleView)
        fun showUnexpectedError()
        fun showCloseSessionDialog()
        fun redirectToGitlab()
        fun dismissDialog()
        fun navigateToLogin()

    }

    interface Presenter : BaseContract.Presenter<View> {

        fun getArticleSelected()
        fun loadUserInformation()
        fun deleteUserInformation()
        fun loginUser()
        fun displayDialogInformation()
        fun dismissDialogInformation()
        fun closeSession()
        fun openGitlab()

    }

}