package com.josegrillo.kotlinmvp.domain.usecase

import com.josegrillo.kotlinmvp.data.local.interfaces.UserRepoInterface
import com.josegrillo.kotlinmvp.domain.model.User
import io.reactivex.Observable
import javax.inject.Inject

class InsertUser @Inject constructor(private val userRepoHelper: UserRepoInterface) {

    fun insertUser(users: List<User>): Observable<Boolean> = userRepoHelper.insertUsers(users)


}