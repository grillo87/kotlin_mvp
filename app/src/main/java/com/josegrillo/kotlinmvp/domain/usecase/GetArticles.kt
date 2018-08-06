package com.josegrillo.kotlinmvp.domain.usecase

import com.josegrillo.kotlinmvp.data.remote.AppApi
import javax.inject.Inject

class GetArticles @Inject constructor(private val appApi: AppApi) {
}