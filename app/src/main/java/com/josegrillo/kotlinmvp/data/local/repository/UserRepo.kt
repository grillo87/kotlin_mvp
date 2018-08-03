package com.josegrillo.kotlinmvp.data.local.repository

import com.josegrillo.kotlinmvp.data.local.dao.UserDAO
import com.josegrillo.kotlinmvp.data.local.interfaces.UserRepoInterface
import com.josegrillo.kotlinmvp.domain.model.User
import io.reactivex.Observable
import io.reactivex.Single
import javax.inject.Inject

class UserRepo @Inject constructor(val userDAO: UserDAO) : UserRepoInterface {

    override fun isUserRepoEmpty(): Observable<Boolean> = Observable.fromCallable({ userDAO.loadUsers().isEmpty() })

    override fun insertUsers(users: List<User>): Observable<Boolean> {
        userDAO.insertUsers(users)
        return Observable.just(true)
    }

    override fun loadUser(): Single<List<User>> = Single.fromCallable({ userDAO.loadUsers() })

    override fun deleteUser(users: List<User>): Observable<Boolean> {
        userDAO.deleteUsers(users)
        return Observable.just(true)
    }
}