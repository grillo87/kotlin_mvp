package com.josegrillo.kotlinmvp.domain.model.database

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "articles")
data class Article(@PrimaryKey(autoGenerate = true) var id: Long? = null,
                   var title: String = "",
                   var area: String = "",
                   var imageUrl: String = "",
                   var content: String = "") {

    constructor() : this(-1, "", "", "", "")

}