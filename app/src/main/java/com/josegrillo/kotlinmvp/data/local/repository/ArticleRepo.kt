package com.josegrillo.kotlinmvp.data.local.repository

import com.josegrillo.kotlinmvp.data.local.dao.ArticleDAO
import com.josegrillo.kotlinmvp.data.local.interfaces.ArticleRepoInterface
import com.josegrillo.kotlinmvp.domain.model.Article
import io.reactivex.Observable
import io.reactivex.Single
import javax.inject.Inject

class ArticleRepo @Inject constructor(val articleDAO: ArticleDAO) : ArticleRepoInterface {

    override fun isArticleRepoEmpty(): Observable<Boolean> = Observable.fromCallable({ articleDAO.loadArticles().isEmpty() })

    override fun insertArticles(articles: List<Article>): Observable<Boolean> {
        articleDAO.insertArticles(articles)
        return Observable.just(true)
    }

    override fun loadArticle(): Single<List<Article>> = Single.fromCallable({ articleDAO.loadArticles() })

    override fun deleteArticles(): Observable<Boolean> {
        articleDAO.deleteArticles()
        return Observable.just(true)
    }


}