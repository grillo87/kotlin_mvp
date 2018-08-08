package com.josegrillo.kotlinmvp.view.contracts

import com.josegrillo.kotlinmvp.domain.model.ArticleView

class DetailContract {

    interface View : BaseContract.View {

        fun setArticleInfo(articleView: ArticleView)
        fun showUnexpectedError()
        fun navigateToList()
        fun showCloseSessionDialog()
        fun dismissDialog()
        fun navigateToLogin()

    }

    interface Presenter : BaseContract.Presenter<View> {

        fun getArticleSelected()
        fun loadUserInformation()
        fun deleteUserInformation()
        fun loginUser()
        fun listArticles()
        fun displayDialogInformation()
        fun dismissDialogInformation()
        fun closeSession()

    }

}