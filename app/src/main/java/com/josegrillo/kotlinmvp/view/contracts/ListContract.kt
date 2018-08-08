package com.josegrillo.kotlinmvp.view.contracts

import com.josegrillo.kotlinmvp.domain.model.ArticleView
import com.josegrillo.kotlinmvp.domain.model.database.Article

class ListContract {

    interface View : BaseContract.View {

        fun showLoading()
        fun hideLoading()
        fun showErrorMessage(message: String)
        fun showUnavailableError()
        fun showUnexpectedError()
        fun setArticlesList(articles: ArrayList<ArticleView>)
        fun navigateToDetail()
        fun onTouchArticle(view: android.view.View, position: Int)


    }

    interface Presenter : BaseContract.Presenter<View> {

        fun loadArticles()
        fun checkArticleSelected()
        fun loadUserInformation()
        fun setArticleSelected(position: Int)
        fun insertArticleSelected(article: Article)
        fun deleteArticlesSelected()

    }

}