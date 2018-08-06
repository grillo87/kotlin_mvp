package com.josegrillo.kotlinmvp.domain.model.mapper

import android.content.Context
import android.widget.Toast
import com.josegrillo.kotlinmvp.domain.model.api.response.User

class UserMapper {

    companion object {

        fun userApiToDatabase(user: User): com.josegrillo.kotlinmvp.domain.model.database.User {

            val userResponse: com.josegrillo.kotlinmvp.domain.model.database.User = com.josegrillo.kotlinmvp.domain.model.database.User(
                    null,
                    user.email,
                    user.password,
                    user.id)

            return userResponse

        }


    }


}