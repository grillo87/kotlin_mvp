package com.josegrillo.kotlinmvp.domain.usecase

import com.josegrillo.kotlinmvp.data.local.interfaces.ArticleRepoInterface
import com.josegrillo.kotlinmvp.domain.model.database.Article
import io.reactivex.Observable
import io.reactivex.Single
import javax.inject.Inject

class LoadArticleSelected @Inject constructor(private val articleRepoHelper: ArticleRepoInterface) {

    fun loadArticleSelected(): Single<List<Article>> = articleRepoHelper.loadArticle()

}