package com.josegrillo.kotlinmvp.domain.model.api.response

data class UserResponse(var status: Int,
                        var user: User? = null,
                        var message: String? = null)