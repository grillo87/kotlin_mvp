package com.josegrillo.kotlinmvp.domain.model

data class ArticleView(val title: String,
                   val area: String,
                   val imageUrl: String,
                   val content: String) {

    constructor() : this("", "", "", "")

}