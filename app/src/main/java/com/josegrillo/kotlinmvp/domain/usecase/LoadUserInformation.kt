package com.josegrillo.kotlinmvp.domain.usecase

import android.database.Observable
import com.josegrillo.kotlinmvp.data.local.interfaces.UserRepoInterface
import com.josegrillo.kotlinmvp.domain.model.database.User
import io.reactivex.Single
import javax.inject.Inject

class LoadUserInformation @Inject constructor(private val userRepoHelper: UserRepoInterface) {

    fun loadUserInformation(): Single<List<User>> = userRepoHelper.loadUser()

}