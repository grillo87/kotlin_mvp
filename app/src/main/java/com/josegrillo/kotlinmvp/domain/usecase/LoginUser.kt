package com.josegrillo.kotlinmvp.domain.usecase

import com.josegrillo.kotlinmvp.data.remote.AppApi
import com.josegrillo.kotlinmvp.domain.model.api.request.UserRequest
import com.josegrillo.kotlinmvp.domain.model.api.response.UserResponse
import io.reactivex.Observable
import javax.inject.Inject

class LoginUser @Inject constructor(private val appApi: AppApi) {

    fun loginUser(email: String, password: String): Observable<UserResponse> = appApi.loginUser(userRequest = UserRequest(email, password))


}