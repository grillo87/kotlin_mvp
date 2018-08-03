package com.josegrillo.kotlinmvp.domain.usecase

import com.josegrillo.kotlinmvp.data.local.interfaces.UserRepoInterface
import io.reactivex.Observable
import javax.inject.Inject

class GetUser @Inject constructor(private val userRepoHelper: UserRepoInterface) {

    fun isUserLoggin(): Observable<Boolean> = userRepoHelper.isUserRepoEmpty()


}