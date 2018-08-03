package com.josegrillo.kotlinmvp.domain.usecase

import com.josegrillo.kotlinmvp.data.local.interfaces.ArticleRepoInterface
import io.reactivex.Observable
import javax.inject.Inject

class GetArticleSelected @Inject constructor(private val articleRepoHelper: ArticleRepoInterface) {

    fun isArticleRepoEmpty(): Observable<Boolean> = articleRepoHelper.isArticleRepoEmpty()

}