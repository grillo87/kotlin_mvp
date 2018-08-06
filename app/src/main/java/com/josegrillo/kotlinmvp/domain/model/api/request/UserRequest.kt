package com.josegrillo.kotlinmvp.domain.model.api.request

data class UserRequest(var email: String? = null,
                       var password: String? = null)