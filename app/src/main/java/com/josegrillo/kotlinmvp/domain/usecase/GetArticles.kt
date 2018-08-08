package com.josegrillo.kotlinmvp.domain.usecase

import com.josegrillo.kotlinmvp.data.remote.AppApi
import com.josegrillo.kotlinmvp.domain.model.api.response.Article
import com.josegrillo.kotlinmvp.domain.model.api.response.UserResponse
import io.reactivex.Observable
import javax.inject.Inject

class GetArticles @Inject constructor(private val appApi: AppApi) {

    fun getArticles(): Observable<List<Article>> = appApi.getArticles()

}