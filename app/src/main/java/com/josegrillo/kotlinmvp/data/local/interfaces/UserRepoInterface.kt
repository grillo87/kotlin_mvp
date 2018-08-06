package com.josegrillo.kotlinmvp.data.local.interfaces

import com.josegrillo.kotlinmvp.domain.model.database.User
import io.reactivex.Observable
import io.reactivex.Single

interface UserRepoInterface {

    fun isUserRepoEmpty(): Observable<Boolean>

    fun insertUsers(users: List<User>): Observable<Boolean>

    fun loadUser(): Single<List<User>>

    fun deleteUser(users: List<User>): Observable<Boolean>

}