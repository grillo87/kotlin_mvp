package com.josegrillo.kotlinmvp.domain.usecase

import com.josegrillo.kotlinmvp.data.local.interfaces.ArticleRepoInterface
import com.josegrillo.kotlinmvp.domain.model.database.Article
import io.reactivex.Observable
import javax.inject.Inject

class InsertArticleSelected @Inject constructor(private val articleRepoHelper: ArticleRepoInterface) {

    fun insertArticleSelected(articles: List<Article>): Observable<Boolean> = articleRepoHelper.insertArticles(articles)

}