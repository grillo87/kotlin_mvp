package com.josegrillo.kotlinmvp.domain.model.database

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "articles")
data class Article(
        @PrimaryKey var id: Long? = null,
        var title: String? = null,
        var area: String? = null,
        var imageUrl: String? = null,
        var content: String? = null) {

    constructor() : this(-1, "", "", "", "")

}