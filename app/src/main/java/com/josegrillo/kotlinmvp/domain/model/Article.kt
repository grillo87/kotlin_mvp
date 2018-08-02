package com.josegrillo.kotlinmvp.domain.model

data class Article(val title: String,
                   val area: String,
                   val imageUrl: String,
                   val content: String) {

    constructor() : this("", "", "", "")

}