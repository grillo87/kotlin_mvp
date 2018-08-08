package com.josegrillo.kotlinmvp.domain.model

data class ArticleView(val title: String? = null,
                       val area: String? = null,
                       val imageUrl: String? = null,
                       val content: String? = null) {

    constructor() : this("", "", "", "")

}