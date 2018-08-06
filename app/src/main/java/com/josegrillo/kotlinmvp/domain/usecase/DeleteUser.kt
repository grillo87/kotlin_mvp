package com.josegrillo.kotlinmvp.domain.usecase

import com.josegrillo.kotlinmvp.data.local.interfaces.UserRepoInterface
import com.josegrillo.kotlinmvp.domain.model.User
import io.reactivex.Observable
import javax.inject.Inject

class DeleteUser @Inject constructor(private val userRepoHelper: UserRepoInterface) {

    fun deleteUser(users: List<User>): Observable<Boolean> = userRepoHelper.deleteUser(users)

}