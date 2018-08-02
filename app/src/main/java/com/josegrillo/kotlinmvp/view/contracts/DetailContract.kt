package com.josegrillo.kotlinmvp.view.contracts

import com.josegrillo.kotlinmvp.domain.model.ArticleView

class DetailContract {

    interface View : BaseContract.View {

        fun setArticleInfo(articleView: ArticleView)
        fun navigateToList()

    }

    interface Presenter : BaseContract.Presenter<View> {

        fun getArticleSelected()
        fun listArticles()

    }

}