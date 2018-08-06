package com.josegrillo.kotlinmvp.domain.usecase

import com.josegrillo.kotlinmvp.data.local.interfaces.UserRepoInterface
import com.josegrillo.kotlinmvp.domain.model.database.User
import io.reactivex.Observable
import io.reactivex.Single
import javax.inject.Inject

class GetUser @Inject constructor(private val userRepoHelper: UserRepoInterface) {

    fun isUserLoggin(): Observable<Boolean> = userRepoHelper.isUserRepoEmpty()

}