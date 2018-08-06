package com.josegrillo.kotlinmvp.view.contracts

import com.josegrillo.kotlinmvp.domain.model.ArticleView

class ListContract {

    interface View : BaseContract.View {

        fun showLoading()
        fun hideLoading()
        fun showErrorMessage(message: String)
        fun setArticlesList(articles: Array<ArticleView>)
        fun navigateToDetail()


    }

    interface Presenter : BaseContract.Presenter<View> {

        fun loadArticles()
        fun setArticleSelected(article: ArticleView)
        fun insertArticleSelected(article: ArticleView)
        fun deleteArticlesSelected()

    }

}