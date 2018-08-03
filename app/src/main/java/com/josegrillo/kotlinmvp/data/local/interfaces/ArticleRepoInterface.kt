package com.josegrillo.kotlinmvp.data.local.interfaces

import com.josegrillo.kotlinmvp.domain.model.Article
import io.reactivex.Observable
import io.reactivex.Single

interface ArticleRepoInterface {

    fun isArticleRepoEmpty(): Observable<Boolean>

    fun insertArticles(articles: List<Article>): Observable<Boolean>

    fun loadArticle(): Single<List<Article>>

    fun deleteArticles(): Observable<Boolean>

}