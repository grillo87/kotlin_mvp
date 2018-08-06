package com.josegrillo.kotlinmvp.domain.model.database

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "users")
data class User(
        @PrimaryKey var id: Long? = null,
        var email: String? = "",
        var password: String? = "",
        var idServer: Int? = null) {

    constructor() : this(-1, "", "", -1)

}