package com.josegrillo.kotlinmvp.domain.model

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
data class User(
        @SerializedName("idServer") @PrimaryKey var id: Long,
        @SerializedName("email") var email: String,
        @SerializedName("password") var password: String) {

    constructor() : this(-1, "", "")

}